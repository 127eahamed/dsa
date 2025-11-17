public interface RecursiveSorts {
    /**
     * Sorts the arrayby splitting in half and rebuilding on the range [low, high)
     *
     * @param arr an array to be sorted
     * @param low the index at which the range starts
     * @param high the first index after the range ends
     */
    public void mergeSort(int[] arr, int low, int high);

    /**
     *
     * Sorts the array using the Lomuto or Hoare Partitions on the range [low, high)
     *
     * @param arr an array to be sorted
     * @param low the index at which the range starts
     * @param high the first index after the range ends
     */
    public void quickSort(int[] arr, int low, int high);
}