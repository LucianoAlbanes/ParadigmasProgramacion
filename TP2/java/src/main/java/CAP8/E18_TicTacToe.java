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

public class E18_TicTacToe {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        try {
            game.move(2,3, TicTacToe.STATES.X);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.printf("E1%n");
        } catch (TicTacToe.AlreadyAssignedSlotException e) {
            e.printStackTrace();
            System.out.printf("E2%n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class TicTacToe {
    // Attributes
    public static final int BOARD_SIZE = 3;
    public enum STATES {X, O, EMPTY}
    private STATES[][] board = new STATES[BOARD_SIZE][BOARD_SIZE];

    // Constructor (Initialize game)
    public TicTacToe() {
        for (STATES[] row : board) {
            Arrays.fill(row, STATES.EMPTY);
        }
    }

    // Moves
    public void move(int m, int n, STATES player) throws Exception {
        // Verify valid move
        if (m >= BOARD_SIZE || m < 0) {
            throw new ArrayIndexOutOfBoundsException("Row out of range.");
        }
        if (n >= BOARD_SIZE || n < 0) {
            throw new ArrayIndexOutOfBoundsException("Column out of range.");
        }
        if (board[m][n] != STATES.EMPTY) {
            throw new AlreadyAssignedSlotException("That slot is already occupied.");
        }

        // Do the move

    }

    public void show() {
        for (STATES[] row : board) {
            for (STATES column : row) {
                System.out.printf("%s | ", column);
            }
            System.out.printf("\b\b%n");
        }
    }

    // Custom exception
    public static class AlreadyAssignedSlotException extends Exception {
        AlreadyAssignedSlotException(String txt) {
            super(txt);
        }
    }
}
