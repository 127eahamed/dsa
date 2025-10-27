public class Search_1_AEhan {
    /**
     * Problem 1: Binary Search
     */
    public static int binarySearch(int[] arr, int value) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        while (lowIndex <= highIndex) {
            int halfIndex = (lowIndex + highIndex) / 2;
            if (arr[halfIndex] == value) {
                return halfIndex; /* return index if found */
            } else if (arr[halfIndex] < value) {
                lowIndex = halfIndex + 1;
            } else if (arr[halfIndex] > value) {
                highIndex = halfIndex - 1;
            }
        }
        return -1; /* return -1 if not found */
    }
    /**
     * Problem 2: Linear Search
     */
    public static int linearSearch(int[] arr, int value) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == value) {
                return index; /* return index if found */
            }
        }
        return -1; /* return -1 if not found */
    }
}
