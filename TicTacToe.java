//Tic Tac Toe is fun!
//Pontillas, Christian Rey T.
//ITCC 11.1 B

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 500;
    int boardHeight = 550;

    JFrame frame = new JFrame("Tic-Tac-Toe Game");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setForeground(Color.white);
        textLabel.setBackground(Color.black);

        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe!");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.black);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new JButton();
                board[i][j].setFont(new Font("Arial", Font.BOLD, 100));
                board[i][j].setFocusable(false);
                board[i][j].addActionListener(new ButtonClickListener(i, j));
                boardPanel.add(board[i][j]);
            }
        }

        frame.add(boardPanel);

        resetButton.setFont(new Font("Arial", Font.BOLD, 30));
        resetButton.setBackground(Color.black);
        resetButton.setForeground(Color.white);
        resetButton.addActionListener(new ResetButtonListener());
        textPanel.add(resetButton, BorderLayout.SOUTH);
    }

    class ButtonClickListener implements ActionListener {
        int row, col;

        ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (board[row][col].getText().equals("")) {
                board[row][col].setText(currentPlayer);
                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                textLabel.setText("Player " + currentPlayer + "'s Turn");
            }
        }
    }

    class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentPlayer = playerX;
            textLabel.setText("Tic-Tac-Toe!");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j].setText("");
                }
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.BOLD, 80));
                button.setBackground(new Color(250, 218, 221));
                button.setForeground(darkPink);
                button.addActionListener(new ButtonListener());
                board[i][j] = button;
                boardPanel.add(button);
            }
        }

        // Reset
        JButton resetButton = new JButton("Reset");
resetButton.setFont(new Font("Arial", Font.BOLD, 30));
resetButton.setBackground(new Color(0, 0, 139)); 
resetButton.setForeground(new Color(255, 255, 255)); 
resetButton.addActionListener(new ResetButtonListener());
textPanel.add(resetButton, BorderLayout.SOUTH);

        frame.add(boardPanel);
    }
    class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            resetBoard();
        }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton)e.getSource();
            if (buttonClicked.getText().equals("")) {
                buttonClicked.setText(currentPlayer);
                if (checkWin()) {
                    JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " wins!");
                    resetBoard();
                } else if (checkDraw()) {
                    JOptionPane.showMessageDialog(frame, "It's a draw!");
                    resetBoard();
                } else {
                    currentPlayer = (currentPlayer.equals(playerX)) ? playerO : playerX;
                    textLabel.setText("Current Player: " + currentPlayer);
                }
            }
        }
    }



    boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equals(currentPlayer) &&
                board[i][1].getText().equals(currentPlayer) &&
                board[i][2].getText().equals(currentPlayer)) {
                return true;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (board[0][j].getText().equals(currentPlayer) &&
                board[1][j].getText().equals(currentPlayer) &&
                board[2][j].getText().equals(currentPlayer)) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0].getText().equals(currentPlayer) &&
            board[1][1].getText().equals(currentPlayer) &&
            board[2][2].getText().equals(currentPlayer)) {
            return true;
        }
        if (board[0][2].getText().equals(currentPlayer) &&
            board[1][1].getText().equals(currentPlayer) &&
            board[2][0].getText().equals(currentPlayer)) {
            return true;
        }
        return false;
    }


    boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    void resetBoard() {
        currentPlayer = playerX;
        textLabel.setText("Tic-Tac-Toe!");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}