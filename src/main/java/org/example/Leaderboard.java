package org.example;

import java.io.*;
import java.util.Arrays;
import javax.swing.*;

public class Leaderboard {

    private final int TOP_PLAYER = 10;
    private Player[] players = new Player[TOP_PLAYER];

    private int min = 0;
    private int max = 0;

    public Leaderboard() {
        loadScore();
    }

    //method random min to max
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public void saveScore(Player player) {
        try {
            FileWriter fw = new FileWriter("leaderboard.dat", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            //check name duplicate
            for (int i = 0; i < TOP_PLAYER; i++) {
                if (players[i] != null) {
                    if (players[i].getName().equals(player.getName())) {
                        players[i].setScore(player.getScore());
                        player = players[i];
                        break;
                    }
                }
            }


            pw.println(player.getName() + "," + player.getScore());
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadScore() {
        try {
            FileReader fr = new FileReader("leaderboard.dat");
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == TOP_PLAYER - 1) {
                    break;
                }
                if (line.equals("")) {
                    continue;
                }
                String[] tokens = line.split(",");
                this.players[i] = new Player(tokens[0], Integer.parseInt(tokens[1]));
                //min max
                if (i == 0) {
                    min = Integer.parseInt(tokens[1]);
                    max = Integer.parseInt(tokens[1]);
                } else {
                    if (min > Integer.parseInt(tokens[1])) {
                        min = Integer.parseInt(tokens[1]);
                    }
                    if (max < Integer.parseInt(tokens[1])) {
                        max = Integer.parseInt(tokens[1]);
                    }
                }
                i++;
            }
            br.close();
            System.out.println(min);
            System.out.println(max);
            System.out.println("Load data from file successfully!");

        } catch (
                IOException ioe) {
            System.out.println("Error");
        }

    }

    public void scoreTable() {
        String[] columnNames = {"Name", "Score"};
        Object[][] data = new Object[TOP_PLAYER][2];

        // Populate the data array after sorting the players array
        for (int i = 0; i < TOP_PLAYER; i++) {
            if (players[i] != null) {
                data[i][0] = players[i].getName();
                data[i][1] = players[i].getScore();
            }
        }

        // Create the table using a 2D array of objects
        JTable table = new JTable(data, columnNames);

        // Display the table in a JFrame
        JFrame frame = new JFrame("Score Table");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
