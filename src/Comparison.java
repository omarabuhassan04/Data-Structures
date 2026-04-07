import java.util.Arrays;

public class Comparison {

    public static void main(String[] args) {
        // Define the array sizes directly
        int[] sizes1 = {100000}; // Example sizes
        int[] sizes2 = {1000000}; // Example sizes

        String[] types = {"sorted", "random", "reversely sorted"};

        // Process for sizes1
        for (int size : sizes1) {
            for (String type : types) {
                int[] array = Array.arraymaker(size, type);

                long mergeSortTime = Timer.measureTime(() -> MergeSort.mergeSort(Arrays.copyOf(array, array.length)));
                long enhancedSelectionSortTime = Timer.measureTime(() -> ESelectionSort.enhancedSelectionSort(Arrays.copyOf(array, array.length)));

                System.out.println("Size: " + size + ", Type: " + type);
                System.out.println("Merge Sort Time: " + mergeSortTime / 1_000_000.0 + " ms");
                System.out.println("Enhanced Selection Sort Time: " + enhancedSelectionSortTime / 1_000_000.0 + " ms");
                System.out.println();
            }
        }

        // Process for sizes2
        for (int size : sizes2) {
            for (String type : types) {
                int[] array = Array.arraymaker(size, type);

                long mergeSortTime = Timer.measureTime(() -> MergeSort.mergeSort(Arrays.copyOf(array, array.length)));
                long enhancedSelectionSortTime = Timer.measureTime(() -> ESelectionSort.enhancedSelectionSort(Arrays.copyOf(array, array.length)));

                System.out.println("Size: " + size + ", Type: " + type);
                System.out.println("Merge Sort Time: " + mergeSortTime / 1_000_000.0 + " ms");
                System.out.println("Enhanced Selection Sort Time: " + enhancedSelectionSortTime / 1_000_000.0 + " ms");
                System.out.println();
            }
        }
    }
}
