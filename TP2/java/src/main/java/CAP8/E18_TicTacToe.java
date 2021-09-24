package CAP8;

/*
Create a class TicTacToe that will enable you to write a program to play Tic-Tac-Toe.
The class contains a private 3-by-3 two-dimensional array. Use an enum type to represent
the value in each cell of the array. The enum’s constants should be named X, O and EMPTY (for a
position that does not contain an X or an O). The constructor should initialize the board elements to
EMPTY. Allow two human players. Wherever the first player moves, place an X in the specified square,
and place an O wherever the second player moves. Each move must be to an empty square. After
each move, determine whether the game has been won and whether it’s a draw. If you feel ambitious,
modify your program so that the computer makes the moves for one of the players. Also, allow
the player to specify whether he or she wants to go first or second. If you feel exceptionally ambitious,
develop a program that will play three-dimensional Tic-Tac-Toe on a 4-by-4-by-4 board.
*/

import java.util.Arrays;
import java.util.Scanner;

public class E18_TicTacToe {
    public static void main(String[] args) {
        // Generate a input scanner
        Scanner input = new Scanner(System.in);

        // Welcome
        System.out.printf("Welcome to Tic-Tac-Toe Game!%n");
        System.out.printf("(Remember: row and columns start at 0)%n");
        System.out.printf("Starting a new game...%n");

        // Start game
        TicTacToe game = new TicTacToe();
        TicTacToe.STATES nextPlayer = TicTacToe.STATES.X; // X moves first

        // Progress game
        while (game.getGameStatus() == TicTacToe.STATUS.IN_PROGRESS) {
            // Prints actual table
            game.showBoard();

            // Prints actual player and ask for position
            boolean validPos = false;
            while (!validPos) {
                // Input
                System.out.printf("Player %s turn.%n", nextPlayer);
                int m, n;
                System.out.print("Row: ");
                m = input.nextInt();
                System.out.print("Column: ");
                n = input.nextInt();

                // Try to do the move
                try {
                    game.move(m, n, nextPlayer);
                    validPos = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.printf("That position is out of range!, try again.%n%n");
                } catch (TicTacToe.AlreadyAssignedSlotException e) {
                    System.out.printf("That slot is already occupied!, try again.%n%n");
                } catch (Exception e) {
                    e.printStackTrace(); // Unknown exception
                }
            }

            // Prepare for next player
            if (nextPlayer == TicTacToe.STATES.X) {
                nextPlayer = TicTacToe.STATES.O;
            } else {
                nextPlayer = TicTacToe.STATES.X;
            }
            System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n"); // Clear console
        }

        // Finished game
        game.showBoard();
        switch (game.getGameStatus()) {
            case X_WON -> System.out.printf("Player %s won! 🎉🎉%n", TicTacToe.STATES.X);
            case O_WON -> System.out.printf("Player %s won! 🎉🎉%n", TicTacToe.STATES.O);
            case DRAW -> System.out.printf("It's a draw! 🤝%n");
            case IN_PROGRESS -> System.out.printf("Meh... suspicious. 🤨%n");
            default -> System.out.printf("WHAT ARE YOU DOING! 🤨%n");
        }
    }
}

class TicTacToe {
    // Attributes
    public static final int BOARD_SIZE = 3;

    public enum STATUS {IN_PROGRESS, X_WON, O_WON, DRAW}

    public enum STATES {X, O, EMPTY}

    private final STATES[][] board = new STATES[BOARD_SIZE][BOARD_SIZE];
    private STATUS gameStatus;
    private int movesCount;

    // Constructor (Initialize game)
    public TicTacToe() {
        for (STATES[] row : board) {
            Arrays.fill(row, STATES.EMPTY);
            gameStatus = STATUS.IN_PROGRESS;
            movesCount = 0;
        }
    }

    // Moves
    public void move(int m, int n, STATES state) throws Exception {
        // Verify valid move
        if (m >= BOARD_SIZE || m < 0) {
            throw new ArrayIndexOutOfBoundsException("Row out of range.");
        }
        if (n >= BOARD_SIZE || n < 0) {
            throw new ArrayIndexOutOfBoundsException("Column out of range.");
        }
        if (board[m][n] != STATES.EMPTY) {
            throw new AlreadyAssignedSlotException("Slot already occupied.");
        }

        // Do the move
        board[m][n] = state;

        // Verify if is a wining move
        boolean won = false;

        // Row
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[m][i] != state) {
                break;
            }
            if (i == BOARD_SIZE - 1) {
                won = true;
            }
        }

        // Column
        if (!won) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][n] != state) {
                    break;
                }
                if (i == BOARD_SIZE - 1) {
                    won = true;
                }
            }
        }

        // Main diagonal
        if (!won) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][i] != state) {
                    break;
                }
                if (i == BOARD_SIZE - 1) {
                    won = true;
                }
            }
        }

        // Anti diagonal
        if (!won) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][BOARD_SIZE - i - 1] != state) {
                    break;
                }
                if (i == BOARD_SIZE - 1) {
                    won = true;
                }
            }
        }

        // Update game attributes
        movesCount++;
        if (won) {
            if (state == STATES.X) {
                gameStatus = STATUS.X_WON;
            } else {
                gameStatus = STATUS.O_WON;
            }
        } else if (movesCount == Math.pow(BOARD_SIZE, 2)) {
            gameStatus = STATUS.DRAW;
        }
    }

    // Prints in console the actual board slots
    public void showBoard() {
        for (STATES[] row : board) {
            for (STATES column : row) {
                System.out.printf("%s | ", (column == STATES.EMPTY) ? " " : column);
            }
            System.out.printf("\b\b%n");
        }
    }

    // Getter for game status
    public STATUS getGameStatus() {
        return gameStatus;
    }

    // Custom exception
    public static class AlreadyAssignedSlotException extends Exception {
        AlreadyAssignedSlotException(String txt) {
            super(txt);
        }
    }
}
