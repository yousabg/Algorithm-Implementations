public class SelectionSort implements SortingAlgorithm{
    String name = "Selection sort";
    @Override
    public int[] sorty(int[] input) {
        int unsorted = 0;
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }
        return input;
    }
    public String getName() {
        return name;
    }
}
