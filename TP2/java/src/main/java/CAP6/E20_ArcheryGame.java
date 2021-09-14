package CAP6;
/*
(Archery Game) A group of four friends visit a sports club, and they decide to practice
archery. Each player gets 3 chances and in every chance they can score between 0 and 10 points.
The player with the maximum score after adding the scores obtained in all 3 chances wins.
Write an application that simulates this game and prints the scores of all four players in a
tabular format and also prints which player won.
    Each line in the table should contain the following:
        1) The player number
        2) Their first chance score
        3) Their second chance score
        4) Their third chance score
        5) Their score after all three chances
    Use multidimensional arrays to store the scores of players in each chance.
    Use the Secure Random number generation mechanism learnt in the previous chapter to generate
scores between 0 and 10 for each player chance.
*/

import java.security.SecureRandom;

public class E20_ArcheryGame {
    // Define constants.
    static final int PLAYERS = 4;
    static final int CHANCES = 3;

    public static void main(String[] args) {
        // Initialize an array to store each player number, score per chance and total score.
        // Each row represents a player (Starting with 0). Scores of chances follow the following pattern (chance n == column n-1).
        int[][] scores = new int[PLAYERS][CHANCES];

        // Simulate the game with secure random
        SecureRandom rand = new SecureRandom();
        for (int[] player : scores) {
            for (int i = 0; i < CHANCES; i++) {
                // Generate the score randomly and store it.
                player[i] = rand.nextInt(11);
            }
        }

        // Print table of results and store winner
        int winnerScore = -1;
        int winner = 0;

        // Header
        System.out.printf("%13s |%12s", "Player", "Final Score");
        for (int i = 0; i < CHANCES; i++) {
            System.out.printf(" |%8s%d", "Chance ", i + 1);
        }
        System.out.printf("%n");

        // Players
        for (int i = 0; i < PLAYERS; i++) {
            // Get actual player final score and compare with actual winner
            int playerScore = sumScore(scores[i]);
            if (playerScore > winnerScore) {
                winnerScore = playerScore;
                winner = i;
            }

            // Print scores
            System.out.printf("%12s%d |%12s", "Player ", i + 1, playerScore);
            for (int chanceScore : scores[i]) {
                System.out.printf(" |%9d", chanceScore);
            }
            System.out.printf("%n");
        }

        // Winner
        System.out.printf("The winner of this match is Player %d with %d points!%n", winner + 1, winnerScore);
    }

    public static int sumScore(int[] playerScores) {
        // Calc the sum of the scores of the given player (as an array).
        int sum = 0;
        for (int score : playerScores) {
            sum += score;
        }
        return sum;
    }
}
