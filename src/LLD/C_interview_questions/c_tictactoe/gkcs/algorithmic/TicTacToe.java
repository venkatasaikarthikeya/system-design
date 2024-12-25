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

            // ROW CHECK
            boolean win = true;
            for (int i = 0; i < n; i++) {
                if (board[row][i] != moveValue) {
                    win = false;
                    break;
                }
            }

            // COLUMN CHECK
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][col] != moveValue) {
                    win = false;
                    break;
                }
            }

            // DIAGONAL CHECK
            if (row == col) {
                win = true;
                for (int i = 0; i < n; i++) {
                    if (board[i][i] != moveValue) {
                        win = false;
                        break;
                    }
                }
            }

            // REVERSE DIAGONAL CHECK
            if (row == n - col - 1) {
                win = true;
                for (int i = 0; i < n; i++) {
                    if (board[i][n - i - 1] != moveValue) {
                        win = false;
                        break;
                    }
                }
            }

            if (win) {
                return player == 0 ? -1 : 1;
            }
        }
        return 0;
    }

}
