import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame jFrame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] button = new JButton[9]; //avem nevoie de 9 butoane
    boolean player1_turn;

    TicTacToe() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 800);
        jFrame.getContentPane().setBackground(new Color(50, 50, 50)); //Color.RED de ex
        jFrame.setLayout(new BorderLayout()); //nu folosim No Layout manager ci BoarderLayout
        jFrame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(255, 255, 100));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        title_panel.add(textField);
        jFrame.add(title_panel, BorderLayout.NORTH);
        jFrame.add(button_panel);

        title_panel.add(textField);
        jFrame.add(title_panel, BorderLayout.NORTH);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (player1_turn) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(125));
                        button[i].setText("X");
                        player1_turn = false;
                        textField.setText("O's Turn");
                        check();
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(125, 25, 25));
                        button[i].setText("O");
                        player1_turn = true;
                        textField.setText("X's Turn");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X Begins");
        } else {
            player1_turn = false;
            textField.setText("O Begins");
        }

    }

    public void check() {
        //X win cond
        if (
                (button[0].getText() == "X") &&
                (button[1].getText() == "X") &&
                (button[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
            xWins(0, 2, 1);
            xWins(1, 0, 2);
            xWins(1, 2, 0);
            xWins(2, 1, 0);
            xWins(2, 0, 1);
        }
        if (
                (button[3].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
            xWins(3, 5, 4);
            xWins(4, 3, 5);
            xWins(4, 5, 3);
            xWins(5, 4, 3);
            xWins(5, 3, 4);
        }
        if (
                (button[6].getText() == "X") &&
                (button[7].getText() == "X") &&
                (button[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
            xWins(6, 8, 7);
            xWins(7, 6, 8);
            xWins(7, 8, 6);
            xWins(8, 6, 7);
            xWins(8, 7, 6);
        }
        if (
                (button[0].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
            xWins(0, 8, 4);
            xWins(4, 8, 0);
            xWins(4, 0, 8);
            xWins(8, 4, 0);
            xWins(8, 0, 4);
        }
        if (
                (button[2].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
            xWins(2, 6, 4);
            xWins(4, 2, 6);
            xWins(4, 6, 2);
            xWins(6, 4, 2);
            xWins(6, 2, 4);
        }
        if (
                (button[0].getText() == "X") &&
                (button[3].getText() == "X") &&
                (button[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
            xWins(0, 6, 3);
            xWins(3, 0, 6);
            xWins(3, 6, 0);
            xWins(6, 3, 0);
            xWins(6, 0, 3);
        }
        if (
                (button[1].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
            xWins(1, 7, 4);
            xWins(4, 7, 1);
            xWins(4, 1, 7);
            xWins(7, 1, 4);
            xWins(7, 4, 1);
        }
        if (
                (button[2].getText() == "X") &&
                (button[5].getText() == "X") &&
                (button[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
            xWins(2, 8, 5);
            xWins(5, 2, 8);
            xWins(5, 8, 2);
            xWins(8, 2, 5);
            xWins(8, 5, 2);
        }
        if (
                (button[3].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
            xWins(3, 5, 4);
            xWins(4, 3, 5);
            xWins(4, 5, 3);
            xWins(5, 4, 3);
            xWins(5, 3, 4);
        }
        if (
                (button[6].getText() == "X") &&
                (button[7].getText() == "X") &&
                (button[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
            xWins(6, 8, 7);
            xWins(7, 8, 6);
            xWins(7, 6, 8);
            xWins(8, 6, 7);
            xWins(8, 7, 6);
        }
        //O win cond

        if (
                (button[0].getText() == "O") &&
                (button[1].getText() == "O") &&
                (button[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
            oWins(0, 2, 1);
            oWins(1, 0, 2);
            oWins(1, 2, 0);
            oWins(2, 1, 0);
            oWins(2, 0, 1);
        }
        if (
                (button[3].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
            oWins(3, 5, 4);
            oWins(4, 3, 5);
            oWins(4, 5, 3);
            oWins(5, 4, 3);
            oWins(5, 3, 4);
        }
        if (
                (button[6].getText() == "O") &&
                (button[7].getText() == "O") &&
                (button[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
            oWins(6, 8, 7);
            oWins(7, 6, 8);
            oWins(7, 8, 6);
            oWins(8, 6, 7);
            oWins(8, 7, 6);
        }
        if (
                (button[0].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
            oWins(0, 8, 4);
            oWins(4, 8, 0);
            oWins(4, 0, 8);
            oWins(8, 4, 0);
            oWins(8, 0, 4);
        }
        if (
                (button[2].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
            oWins(2, 6, 4);
            oWins(4, 2, 6);
            oWins(4, 6, 2);
            oWins(6, 4, 2);
            oWins(6, 2, 4);
        }
        if (
                (button[0].getText() == "O") &&
                (button[3].getText() == "O") &&
                (button[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
            oWins(0, 6, 3);
            oWins(3, 0, 6);
            oWins(3, 6, 0);
            oWins(6, 3, 0);
            oWins(6, 0, 3);
        }
        if (
                (button[1].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
            oWins(1, 7, 4);
            oWins(4, 7, 1);
            oWins(4, 1, 7);
            oWins(7, 1, 4);
            oWins(7, 4, 1);
        }
        if (
                (button[2].getText() == "O") &&
                (button[5].getText() == "O") &&
                (button[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
            oWins(2, 8, 5);
            oWins(5, 2, 8);
            oWins(5, 8, 2);
            oWins(8, 2, 5);
            oWins(8, 5, 2);
        }
        if (
                (button[3].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
            oWins(3, 5, 4);
            oWins(4, 3, 5);
            oWins(4, 5, 3);
            oWins(5, 4, 3);
            oWins(5, 3, 4);
        }
        if (
                (button[6].getText() == "O") &&
                (button[7].getText() == "O") &&
                (button[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
            oWins(6, 8, 7);
            oWins(7, 8, 6);
            oWins(7, 6, 8);
            oWins(8, 6, 7);
            oWins(8, 7, 6);
        }
    }

    public void xWins(int a, int b, int c) {

        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for(int i = 0; i<9; i++){
            button[i].setEnabled(false);
        }
        textField.setText("Victory for X");
    }

    public void oWins(int a, int b, int c) {

        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for(int i = 0; i<9; i++){
            button[i].setEnabled(false);
        }
        textField.setText("Victory for O");
    }
}
