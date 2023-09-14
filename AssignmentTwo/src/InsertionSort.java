public class InsertionSort implements SortingAlgorithm{
    String name = "Insertion sort";
    @Override
    public int[] sorty(int[] input) {
        for (int p = 1; p < input.length; ++p) {
            int temp = input[p];
            int j;
            for (j = p; j > 0 && temp < input[j-1]; j--) {
                input[j] = input[j-1];
            }
            input[j] = temp;
        }
        return input;
    }
    public String getName() {
        return name;
    }
}
