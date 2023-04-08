package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame {

    private JPanel MainMenuPanel;
    private JButton btnPlay, btnScore, btnExit;

    public MainMenu() {
        super("Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainMenuPanel);
        this.setSize(500, 500);
        this.setVisible(true);

//        Leaderboard.loadDataFormFile();
//        System.out.println(Leaderboard.getScore());

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game();
                dispose();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Leaderboard table = new Leaderboard();
                table.scoreTable();
                System.out.println("Min" + table.getMin());
            }
        });

    }


    public static void main(String[] args) {
        new MainMenu();
    }
}
