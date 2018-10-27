// Name: Yuntao Liang
// USC NetID: 3462638190
// CS 455 PA1
// Fall 2018

import javax.swing.*;
import java.awt.*;

/**
 *  CoinSimComponent class
 *
 *  take the result of CoinTossSimulator
 *  instantiate three bar and draw them
 *  according to the percentile of each result
 *  to total numbers of tosses
 */
public class CoinSimComponent extends JComponent {
    //The width between each bar
    private static final int BAR_WIDTH = 30;
    //The width between margin and graph in vertical
    private static final int VERTICAL_WIDTH = 40;
    //The width between bar and right margin
    private static final int HORIZONTAL_WIDTH = 160;

    private static final Color TWO_HEADS_Color = Color.RED;
    private static final Color TWO_TRIALS_Color = Color.BLUE;
    private static final Color HEAD_TRIALS_Color = Color.GREEN;
    private static final String TWO_HEADS_LABEL = "Two Heads";
    private static final String HEADS_TRIALS_LABEL = "A Head and a Tail";
    private static final String TWO_TRIALS_LABEL = "Two Tails";

    //simulate the toss trials
    CoinTossSimulator coinTossSimulator;

    /**
     *
     * @param numTrials this parameter was input by user
     *                  and taken from main method
     */
    public CoinSimComponent(int numTrials) {
        coinTossSimulator = new CoinTossSimulator();
        coinTossSimulator.run(numTrials);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        int frameHeight = getHeight();
        int frameWidth = getWidth();
        int TwoHeadsNum = coinTossSimulator.getTwoHeads();
        int HeadTailNum = coinTossSimulator.getHeadTails();
        int TwoTailsNum = coinTossSimulator.getTwoTails();
        int totalTrials = coinTossSimulator.getNumTrials();

        //get the result of coin trials
        int[] trials = new int[]{ TwoHeadsNum, HeadTailNum, TwoTailsNum };

        int widthBetweenBars = (frameWidth - HORIZONTAL_WIDTH - 3 * BAR_WIDTH) / 3;
        int bottom = frameHeight - VERTICAL_WIDTH;
        double scale = ((double)frameHeight - (double)2 * VERTICAL_WIDTH) / (double)totalTrials;
        int barWidth = BAR_WIDTH;
        Color[] color = new Color[]{ TWO_HEADS_Color, HEAD_TRIALS_Color, TWO_TRIALS_Color };
        String[] str = new String[]{ TWO_HEADS_LABEL, HEADS_TRIALS_LABEL, TWO_TRIALS_LABEL };
        //draw three bars
        for (int i = 0; i < trials.length; i ++) {

            //calculate the parameters that will pass to Bar
            int barLeft = (i + 1) * widthBetweenBars + i * barWidth;
            int barHeight = trials[i];
            double percent = (double)Math.round(((double)trials[i] / (double)totalTrials) * 1000) / 10;
            String curLabel = str[i] + ":" + trials[i] + "(" + percent + "%)";
            Bar bar = new Bar(bottom, barLeft, barWidth, barHeight, scale, color[i], curLabel);
            bar.draw(g2);
        }
    }
}
