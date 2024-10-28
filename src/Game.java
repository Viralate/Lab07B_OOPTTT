import javax.swing.*;

public class Game {
    private TTTBoard board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private TTTGUI gui;

    public Game() {
        board = new TTTBoard();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
        gui = new TTTGUI(this);
    }

    public void startGame() {
        gui.show();
    }

    public void playTurn(int row, int col) {
        if (board.markTile(row, col, currentPlayer.getSymbol())) {
            gui.updateDisplay();
            if (board.checkWin()) {
                JOptionPane.showMessageDialog(null, currentPlayer.getName() + " wins!");
                board.resetBoard();
                gui.updateDisplay();
            } else if (board.isFull()) {
                JOptionPane.showMessageDialog(null, "It's a draw!");
                board.resetBoard();
                gui.updateDisplay();
            }
            switchTurn();
        }
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public TTTBoard getBoard() {
        return board;
    }

    // Add the main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.startGame();
        });
    }
}
