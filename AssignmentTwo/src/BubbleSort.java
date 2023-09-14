public class BubbleSort implements SortingAlgorithm {
    String name = "Bubble sort";
    @Override
    public int[] sorty(int[] input) {
        int n = input.length;
        int temp;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (input[j+1] < input[j]) {
                    temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

    public String getName() {
        return name;
    }
}
