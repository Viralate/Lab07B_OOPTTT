public class TTTBoard {
    private char[][] board;
    private static final int SIZE = 3;

    public TTTBoard() {
        board = new char[SIZE][SIZE];
        resetBoard();
    }

    public boolean markTile(int row, int col, char symbol) {
        if (board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        // Check rows, columns, and diagonals for a win condition
        for (int i = 0; i < SIZE; i++) {
            if (checkRow(i) || checkColumn(i)) return true;
        }
        return checkDiagonals();
    }

    private boolean checkRow(int row) {
        return board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != '-';
    }

    private boolean checkColumn(int col) {
        return board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != '-';
    }

    private boolean checkDiagonals() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-');
    }

    public boolean isFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '-') return false;
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char getTile(int row, int col) {
        return board[row][col];
    }
}
