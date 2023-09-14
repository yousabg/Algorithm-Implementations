import java.util.Random;

public class Tester {
    SortingAlgorithm sa;
    public Tester(SortingAlgorithm sa) {
        this.sa = sa;
    }
    double singleTest(int size) {
//        Random random = new Random(); Old code
//        int[] arr = new int[size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = random.nextInt();
//        }
        int[] arr = generateKSorted(size);
        long start = System.nanoTime();
        sa.sorty(arr);
        long end = System.nanoTime();
        return (double) ((end-start)/1000000);
    }

    String test(int iterations, int size) {
        double totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            double time = singleTest(size);
            totalTime += time;
        }
        double average = totalTime/iterations;
        return "Sorted " + size + " elements in " + average + "ms (avg)";
    }

    int[] generateKSorted(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        if (size < 10) {
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt();
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (i < 10) {
                    arr[i] = random.nextInt();
                } else {
                    int rando = random.nextInt() + arr[i-10];
                    arr[i] = rando;
                }
            }
        }
        return arr;
    }
}
