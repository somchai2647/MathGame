package org.example;

import java.io.*;

public class Leaderboard {

    public Leaderboard() {
        saveDataToFile();
    }

    public void loadDataFormFile() {
        try {
            File file = new File("leaderboard.dat");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataToFile() {
        try {
            File file = new File("leaderboard.dat");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Hello World");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Leaderboard x = new Leaderboard();
        x.loadDataFormFile();
    }
}
