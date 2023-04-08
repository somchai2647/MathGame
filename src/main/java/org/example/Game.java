package org.example;

import javax.swing.*;

import com.github.ayaanqui.expressionresolver.Resolver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class Game extends JFrame {
    private JPanel GamePanel;
    private JButton answer1, answer2, answer3, answer4;
    private JLabel questionText;
    private JButton btnExit;
    private JLabel scoreLabel;
    private static String textResult = "";

    private int score = 0;

    DecimalFormat df = new DecimalFormat();

    public Game() {
        super("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(GamePanel);
        this.setSize(500, 500);
        this.setVisible(true);
        df.setMaximumFractionDigits(2);
        generateQuestion();

        scoreLabel.setText("คะแนนสะสม: " + String.valueOf(score));
        System.out.println(textResult);

        answer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(answer1.getText() + " " + textResult + " ");
                if (answer1.getText().equals(String.valueOf(textResult))) {
                    System.out.println("true");
                    score += 1;
                    updateScore();
                } else {
                    System.out.println("false");
                }
                generateQuestion();
            }
        });
        answer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(answer2.getText() + " " + textResult + " ");
                if (answer2.getText().equals(String.valueOf(textResult))) {
                    System.out.println("true");
                    score += 1;
                    updateScore();
                } else {
                    System.out.println("false");
                }
                generateQuestion();
            }
        });
        answer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(answer3.getText() + " " + textResult + " ");

                if (answer3.getText().equals(String.valueOf(textResult))) {
                    System.out.println("true");
                    score += 1;
                    updateScore();
                } else {
                    System.out.println("false");
                }
                generateQuestion();
            }
        });
        answer4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(answer4.getText() + " " + textResult + " ");
                if (answer4.getText().equals(String.valueOf(textResult))) {
                    System.out.println("true");
                    score += 1;
                    updateScore();
                } else {
                    System.out.println("false");
                }
                generateQuestion();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu();
                dispose();
            }
        });
    }

    private void generateQuestion() {
        MathExpressionGenerator quest = new MathExpressionGenerator();
        String x = quest.generateExpression(3);
        Resolver calculator = new Resolver();
        double result = calculator.setExpression(x).solveExpression().result;
        textResult = String.valueOf(result);
        questionText.setText(x);
        //random 1 to 4
        int random = (int) random(1, 4, false);
        System.out.println(textResult);
        switch (random) {
            case 1 -> {
                answer1.setText(String.valueOf(result));
                answer2.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer3.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer4.setText(String.valueOf(df.format(random(-100, 999, true))));
            }
            case 2 -> {
                answer2.setText(String.valueOf(result));
                answer1.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer3.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer4.setText(String.valueOf(df.format(random(-100, 999, true))));
            }
            case 3 -> {
                answer3.setText(String.valueOf(result));
                answer2.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer1.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer4.setText(String.valueOf(df.format(random(-100, 999, true))));
            }
            case 4 -> {
                answer4.setText(String.valueOf(result));
                answer2.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer3.setText(String.valueOf(df.format(random(-100, 999, true))));
                answer1.setText(String.valueOf(df.format(random(-100, 999, true))));
            }
        }
    }

    //method random min to max value
    public static float random(int min, int max, boolean f) {
        if (f) {
            return (float) (Math.random() * (max - min + 1) + min);
        } else {
            return (int) (Math.random() * (max - min) + min);
        }
    }

    private void updateScore() {
        scoreLabel.setText("คะแนนสะสม: " + String.valueOf(score));

        if(score == 10){
            JOptionPane.showMessageDialog(null, "คุณได้คะแนนสะสม 10 คะแนน");
        }
    }
}
