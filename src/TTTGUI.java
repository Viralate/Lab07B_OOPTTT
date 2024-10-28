import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTGUI {
    private JFrame frame;
    private TTTTileButton[][] buttons;
    private Game game;

    public TTTGUI(Game game) {
        this.game = game;
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));
        buttons = new TTTTileButton[3][3];
        initialize();
    }

    public void initialize() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                TTTTileButton button = new TTTTileButton(row, col);
                button.setFont(new Font("Arial", Font.PLAIN, 60));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.playTurn(button.getRow(), button.getCol());
                        updateDisplay();
                    }
                });
                buttons[row][col] = button;
                frame.add(button);
            }
        }
    }

    public void updateDisplay() {
        TTTBoard board = game.getBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText(String.valueOf(board.getTile(row, col)));
            }
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}
