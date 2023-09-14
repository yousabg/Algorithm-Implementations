public class MergeSort implements SortingAlgorithm{
    String name = "Merge sort";
    @Override
    public int[] sorty(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        int midpoint = input.length / 2;
        int[] left = new int[midpoint];
        int[] right = new int[input.length - midpoint];
        for (int i = 0; i < midpoint; i++) {
            left[i] = input[i];
        }
        for (int i = midpoint; i < input.length; i++) {
            right[i - midpoint] = input[i];
        }
        left = sorty(left);
        right = sorty(right);
        return merge(left, right);
    }
    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            merged[k] = right[j];
            j++;
            k++;
        }
        return merged;
    }
    public String getName() {
        return name;
    }
}
