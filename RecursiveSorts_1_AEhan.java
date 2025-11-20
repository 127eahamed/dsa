public class RecursiveSorts_1_AEhan implements RecursiveSorts {
    public void mergeSort(int[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid, high);

        merge(arr, low, mid, high);
    }
    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int i = low, j = mid, k = 0;

        while (i < mid && j < high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j < high) {
            temp[k++] = arr[j++];
        }

        for (int n = 0; n < temp.length; n++) {
            arr[low + n] = temp[n];
        }
    }
    public void quickSort(int[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }

        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex);
        quickSort(arr, pivotIndex + 1, high);
    }
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high - 1];
        int i = low;

        for (int j = low; j < high - 1; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high - 1];
        arr[high - 1] = temp;

        return i;
    }
    public static void main(String[] args) {
        RecursiveSorts_1_AEhan r = new RecursiveSorts_1_AEhan();
        int[] arr1 = randomArray();
        System.out.println("Before merge sort:");
        printArray(arr1);
        r.mergeSort(arr1, 0, arr1.length);
        System.out.println("\nAfter merge sort:");
        printArray(arr1);
        System.out.println("\n");
        int[] arr2 = randomArray();
        System.out.println("Before quicksort:");
        printArray(arr2);
        r.mergeSort(arr2, 0, arr2.length);
        System.out.println("\nAfter quicksort:");
        printArray(arr2);
    }
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "]");
    }
    public static int[] randomArray() {
        int length = 5 + (int) (Math.random() * 6);
        int spread = 1000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (Math.random() < 0.5 ?
                -1 * (int) (Math.random() * spread) :
                (int) (Math.random() * spread)
            );
        }
        return arr;
    }
}
