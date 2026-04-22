public class HeapSort_1_AEhan {
    public static <E extends Comparable<E>> void heapSort(E[] arr) {
        int end = arr.length - 1;
        heapify(arr);
        swap(arr, 0, end);
        end--;
        int gwKiddo = (end - 2 + end % 2) / 2;
        while (end > 0) {
            reheapifyMax(0, gwKiddo, end, arr);
            swap(arr, end, 0);
            end--;
            gwKiddo = (end - 2 + end % 2) / 2;
        }
    }
    public static <E extends Comparable<E>> void heapify(E[] arr) {
        int end = arr.length - 1;
        int gwKiddo = (end - 2 + end % 2) / 2;
        for (int i = gwKiddo; i >= 0; i--) {
            reheapifyMax(i, gwKiddo, end, arr);
        }
    }
    public static <E extends Comparable<E>> void reheapifyMax(int n, int gwKiddo, int endIndex, E[] arr) {
        int maxIndex = n;
        if (arr[2*n + 1].compareTo(arr[n]) > 0) {
            maxIndex = 2*n + 1;
        }
        if (2*n + 2 <= endIndex && arr[2*n + 2].compareTo(arr[maxIndex]) > 0) {
            maxIndex = 2*n + 2;
        }
        if (arr[n].compareTo(arr[maxIndex]) != 0) {
            swap(arr, n, maxIndex);
            if (maxIndex <= gwKiddo) {
                reheapifyMax(maxIndex, gwKiddo, endIndex, arr);
            }
        }
    }
    public static <E extends Comparable<E>> void swap(E[] arr, int index1, int index2) {
        E temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
