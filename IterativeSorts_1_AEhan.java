public class IterativeSorts_1_AEhan {
    /**
     * Assignment #1: Implement Selection Sort Algorithm
     */
    public static void selectionSort(int[] arr) {
        int minIndex = 0;
        for (int sortingSpot = 0; sortingSpot < arr.length; sortingSpot++) {
            minIndex = sortingSpot;
            for (int current = sortingSpot; current < arr.length; current++) {
                if (arr[current] < arr[minIndex]) {
                    minIndex = current;
                }
            }
            int min = arr[minIndex];
            arr[minIndex] = arr[sortingSpot];
            arr[sortingSpot] = min;
        }
    }
    /**
     * Assignment #2: Implement Insertion Sort Algorithm
     */
    public static void insertionSort(int[] arr) {
        for (int current = 1; current < arr.length; current++) {
            int temp = current;
            while (temp - 1 >= 0 && arr[temp] < arr[temp - 1]) {
                int swapTemp = arr[temp];
                arr[temp] = arr[temp - 1];
                arr[temp - 1] = swapTemp;
                temp--;
            }
        }
    }
}
