// Name: Yuntao Liang
// USC NetID: 3462638190
// CS 455 PA1
// Fall 2018

import javax.swing.*;
import java.util.Scanner;

public class CoinSimViewer {
    /**
     * java CoinSimViewer to fun this file
     * type the number of trials you want from console
     * the number of trials you type should larger than 0
     * check the histogram from GUI
     * @param args
     */
    public static void main(String[] args) {
        int inputFromUser = 0;
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.print("Enter number of trials: ");
            inputFromUser = reader.nextInt();
            if (inputFromUser > 0) break;
            System.out.println("Error: number entered must be greater than 0: ");
        }
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CoinSimComponent coinSimComponent = new CoinSimComponent(inputFromUser);
        frame.add(coinSimComponent);

        frame.setVisible(true);
    }
}
