
public class ESelectionSort
{
    public static void enhancedSelectionSort(int[] array) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int min = left;
            int max = right;
            for (int i = left; i <= right; i++) {
                if (array[i] < array[min]) {
                    min = i;
                } else if (array[i] > array[max]) {
                    max = i;
                }
            }
            if (min != left) {
                swap(array, left, min);
            }
            if (max != right) {
                swap(array, right, max);
            }
            left++;
            right--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}