package LLD.C_interview_questions.c_tictactoe.gkcs.algorithmic;

public class TicTacToe {

    private final int n;
    private final int[][] board;

    public TicTacToe(int n){
        this.n = n;
        this.board = new int[n][n];
    }

    /**
     * Makes a move on the board and returns the winner if the move is a winning move
     * @param player is either 0 or 1
     * @param row is the move's row index
     * @param col is the move's column index
     * @return winner -1 if first player, +1 if second player and 0 otherwise
     * @throws IllegalArgumentException if the move is an illegal move
     */
    public int move(int player, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException("Move out of board boundary");
        } else if (board[row][col] != 0) {
            throw new IllegalArgumentException("Square is already occupied");
        } else if (player != 0 && player != 1) {
            throw new IllegalArgumentException("Invalid player");
        } else {
            int moveValue = player == 0 ? -1 : 1;
            board[row][col] = moveValue;
            boolean rowWin = true, colWin = true, diagonalWin = true, reverseDiagonalWin = true;
            for (int i = 0; i < n; i++) {
                // row check
                if (board[row][i] != moveValue) {
                    rowWin = false;
                }
                // col check
                if (board[i][col] != moveValue) {
                    colWin = false;
                }
                // diagonal check
                if (board[i][i] != moveValue) {
                    diagonalWin = false;
                }
                // reverse diagonal check
                if (board[i][n - i - 1] != moveValue) {
                    reverseDiagonalWin = false;
                }
            }
            if (rowWin || colWin || diagonalWin || reverseDiagonalWin) {
                return player == 0 ? -1 : 1;
            }
        }
        return 0;
    }

}
