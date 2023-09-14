import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphMaker {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            //Previously did assignmenttwolog for the originl graph
            File data = new File("AssignmentTwoLog2.txt");
            Scanner scan = new Scanner(data);
            String currentAlgorithm = "";

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.startsWith("Sorting algorithm - ")) {
                    currentAlgorithm = line.substring(20);
                } else if (line.startsWith("Sorted")) {
                    String[] parts = line.split(" ");
                    int numElements = Integer.parseInt(parts[1]);
                    String timeMs = parts[4].replace("ms", "");
                    double time = Double.parseDouble(timeMs);
                    dataset.addValue(time, currentAlgorithm, Integer.toString(numElements));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            System.exit(0);
        }

        JFreeChart chart = ChartFactory.createLineChart("Sorting Performance", "Number of Elements", "Time in ms", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame frame = new ChartFrame("Sorting Algorithms Performance Chart", chart);
        frame.pack();
        frame.setVisible(true);

    }
}
