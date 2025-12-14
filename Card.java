/**
 *
 * @author Samuil Halachev
 * @studentID 501315102
 */

package coe318.lab5;

public class Card implements Comparable {  

    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    private final int rank;
    private final int suit;
    private boolean faceUp;

    public Card(int rank, int suit, boolean faceUp) 
    {
        this.rank = rank;
        this.suit = suit;
        this.faceUp = faceUp;
    }
    
   /**
   * @return the faceUp
   */
    public boolean isFaceUp() 
    { 
        return faceUp; 
    }
    
   /**
   * @param faceUp the faceUp to set
   */    
    public void setFaceUp(boolean faceUp) 
    { 
        this.faceUp = faceUp; 
    }
    
  /**
   * @return the rank
   */    
    public int getRank() 
    { 
        return rank; 
    }
    
  /**
   * @return the suit
   */    
    public int getSuit() 
    { 
        return suit; 
    }

    @Override
    public boolean equals(Object ob) 
    {
        if (!(ob instanceof Card)) return false;
        Card c = (Card) ob;
        return rank == c.rank && suit == c.suit;
    }

    @Override
    public int hashCode() //DO NOT MODIFY
    {
        int hash = 7;
        hash = 31 * hash + rank;
        hash = 31 * hash + suit;
        return hash;
    }

    @Override
    public int compareTo(Object obj) //DO NOT MODIFY
    {
        return compareTo((Card) obj);
    }


    public int compareTo(Card c) 
    {
        if (this.rank != c.rank) 
        {
            return this.rank - c.rank;
        }
        return this.suit - c.suit;
    }
    
  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
    public String getRankString() 
    {
        return switch (rank) 
        {
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            case 14 -> "Ace";
            default -> String.valueOf(rank);
        };
    }
    
  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
    public String getSuitString() 
    {
        return switch (suit) 
        {
            case CLUB -> "Clubs";
            case DIAMOND -> "Diamonds";
            case HEART -> "Hearts";
            case SPADE -> "Spades";
            default -> "";
        };
    }
    
  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
    @Override
    public String toString() 
    {
        return faceUp ? getRankString() + " of " + getSuitString() : "?";
    }

    public static void main(String[] args) {
        Card club5 = new Card(5, CLUB, true);
        Card spadeAce = new Card(14, SPADE, true);

        System.out.println("club5: " + club5);
        System.out.println("spadeAce: " + spadeAce);
        System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce));
        System.out.println("club5 compareTo club5: " + club5.compareTo(club5));
        System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce));
        System.out.println("club5 equals club5: " + club5.equals(club5));
    }
}