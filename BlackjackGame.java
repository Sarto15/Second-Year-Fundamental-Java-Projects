/**
 *
 * @author Samuil Halachev
 * @studentID 501315102
 */

package coe318.lab5;

public class BlackjackGame
{
    private final CardPile deck       = new CardPile();
    private final CardPile houseCards = new CardPile();
    private final CardPile yourCards  = new CardPile();
    private boolean houseDone  = false;
    private boolean playerDone = false;
    private UserInterface ui;

    public BlackjackGame(UserInterface ui)
    {
        this.ui = ui;
        ui.setGame(this);
        for (int r = 2; r < 15; r++)
        {
            for (int s = 0; s < 4; s++)
            {
                deck.add(new Card(r, s, true));
            }
        }
    }

    public void start()
    {
        Card c;
        c = deck.removeRandom(); c.setFaceUp(false); houseCards.add(c);
        houseCards.add(deck.removeRandom());
        yourCards.add(deck.removeRandom());
        yourCards.add(deck.removeRandom());
        ui.display();
    }

    public void play()
    {
        while (!houseDone || !playerDone)
        {
            // House turn
            if (!houseDone)
            {
                if (score(houseCards) < 17)
                {
                    houseCards.add(deck.removeRandom());
                    ui.display();
                }
                else
                {
                    houseDone = true;
                }
            }

            if (!playerDone)
            {
                if (score(yourCards) > 21)
                {
                    playerDone = true;
                    ui.display();
                    continue;
                }

                if (ui.hitMe())
                {
                    yourCards.add(deck.removeRandom());
                    ui.display();
                }
                else
                {
                    playerDone = true;
                }
            }
        }
    }

    public void end()
    {
        houseCards.getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }
  
    /**
   * Determine the score of a pile of cards.
   *
   * @param p
   * @return the score
   */
    public int score(CardPile p)
    {
        int total = 0;
        for (Card c : p.getCards())
        {
            int r = c.getRank();
            if (r >= 11 && r <= 13)
            {
                total += 10;
            }
            else if (r == 14)
            {
                total += 1;
            }
            else
            {
                total += r;
            }
        }
        return total;
    }
    
  /**
   * @return the houseCards
   */
    public CardPile getHouseCards()
    {
        return houseCards;
    }
    
  /**
   * @return the yourCards
   */
    public CardPile getYourCards()
    {
        return yourCards;
    }

    public static void main(String[] args)
    {
        BlackjackGame game = new BlackjackGame(new SimpleUI());
        game.start();
        game.play();
        game.end();
    }
}