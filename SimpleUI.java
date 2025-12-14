/**
 *
 * @author Samuil Halachev
 * @studentID 501315102
 */

package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("House holds:");
        for (Card card : game.getHouseCards().getCards()) {
            System.out.println(card.toString());
        }
        System.out.println("You hold:");
        for (Card card : game.getYourCards().getCards()) {
            System.out.println(card.toString());
        }
    }

    @Override
    public boolean hitMe() {
        System.out.print("Another card? ");
        String input = user.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    @Override
    public void gameOver() {
        // Turn all cards face-up
        for (Card card : game.getHouseCards().getCards()) {
            card.setFaceUp(true);
        }
        for (Card card : game.getYourCards().getCards()) {
            card.setFaceUp(true);
        }

        // Display final cards
        System.out.println("Game over");
        System.out.println("House holds:");
        for (Card card : game.getHouseCards().getCards()) {
            System.out.println(card.toString());
        }
        System.out.println("You hold:");
        for (Card card : game.getYourCards().getCards()) {
            System.out.println(card.toString());
        }

        // Calculate and display scores
        int yourScore = calculateScore(game.getYourCards());
        int houseScore = calculateScore(game.getHouseCards());
        System.out.printf("Your score: %d, House score: %d%n", yourScore, houseScore);

        // Determine and display winner
        if (yourScore > 21) {
            System.out.println("The House wins");
        } else if (houseScore > 21) {
            System.out.println("You win");
        } else if (yourScore > houseScore) {
            System.out.println("You win");
        } else {
            System.out.println("The House wins");
        }
    }

    private int calculateScore(CardPile pile) {
        int score = 0;
        for (Card card : pile.getCards()) {
            int rank = card.getRank();
            if (rank >= 11 && rank <= 13) { // Jack, Queen, King
                score += 10;
            } else if (rank == 14) { // Ace
                score += 1;
            } else { // 2-10
                score += rank;
            }
        }
        return score;
    }
}