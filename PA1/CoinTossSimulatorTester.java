// Name: Yuntao Liang
// USC NetID: 3462638190
// CS 455 PA1
// Fall 2018

import java.util.Random;

public class CoinTossSimulatorTester {
    public static void main(String[] args) {
        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        System.out.println("After Constructor");
        System.out.println("Number of trials [exp: 0]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-trial tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-trials tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses added up correctly ? " + (0 == coinTossSimulator.getNumTrials()));
        System.out.println("");

        coinTossSimulator.run(1);
        System.out.println("After run(1)");
        System.out.println("Number of trials [exp: 1]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-trial tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-trials tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses added up correctly ? " + (1 == coinTossSimulator.getNumTrials()));
        System.out.println("");

        coinTossSimulator.run(10);
        System.out.println("After run(10)");
        System.out.println("Number of trials [exp: 11]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-trial tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-trials tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses added up correctly ? " + (11 == coinTossSimulator.getNumTrials()));
        System.out.println("");

        coinTossSimulator.run(100);
        System.out.println("After run(100)");
        System.out.println("Number of trials [exp: 111]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-trial tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-trials tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses added up correctly ? " + (111 == coinTossSimulator.getNumTrials()));
        System.out.println("");

        coinTossSimulator.reset();
        System.out.println("After reset");
        System.out.println("Number of trials [exp: 0]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-trial tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-trials tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses added up correctly ? " + (0 == coinTossSimulator.getNumTrials()));
        System.out.println("");

        coinTossSimulator.run(1000);
        System.out.println("After run(100)");
        System.out.println("Number of trials [exp: 1000]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-trial tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-trials tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses added up correctly ? " + (1000 == coinTossSimulator.getNumTrials()));
        System.out.println("");

    }
}
