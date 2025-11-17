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
        int[] arr1 = {1,4,2,6,3,4,2,1};
        r.
    }
}
