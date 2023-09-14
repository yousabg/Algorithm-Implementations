import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Performance {
    public static void main(String[] args) throws IOException {
        SortingAlgorithm[] algorithms = {new InsertionSort(), new MergeSort(), new QuickSort(), new SelectionSort(), new ShellSort(), new BubbleSort()};
        try {
            //The first one was "AssignmentTwoLog.txt"
            File theFile = new File("AssignmentTwoLog2.txt");
            theFile.createNewFile();
        } catch (IOException e){
            System.out.println("Error");
            System.exit(3);
        }
        FileWriter writer = new FileWriter("AssignmentTwoLog2.txt");

        for (int i = 0; i < algorithms.length; i++) {
            writer.write("Sorting algorithm - " + algorithms[i].getName());
            System.out.println(algorithms[i].getName() + " started.");
            Tester tester = new Tester(algorithms[i]);
            writer.write("\n" + tester.test(20, 100));
            writer.write("\n" + tester.test(20, 500));
            writer.write("\n" + tester.test(20, 1000));
            writer.write("\n" + tester.test(20, 2000));
            writer.write("\n" + tester.test(20, 5000));
            writer.write("\n" + tester.test(20, 10000));
            writer.write("\n" + tester.test(20, 20000));
            writer.write("\n" + tester.test(20, 75000));
            writer.write("\n" + tester.test(20, 150000));
            writer.write("\n");
            writer.write("\n");
            System.out.println(algorithms[i].getName() + " done.");
        }
        writer.close();
    }
}
