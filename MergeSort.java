 class MergeSort {
    void merge(int[] arr, int start, int mid, int end) {
        int len1 = mid - start + 1;
        int len2 = end - mid;

        // Temporary arrays for the two halves
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];
        
        int src = start;
        // Copy data to temporary arrays
        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[src++];
        }
        for (int j = 0;j < len2; j++) {
            rightArr[j] = arr[src++];
        }

        // Merge the temporary arrays back into the original array
        int left = 0;   // Pointer for leftArr
        int right = 0;  // Pointer for rightArr
        int dest = start; // Pointer for original destination array

        while (left < len1 && right < len2) {
            if (leftArr[left] <= rightArr[right]) {
                arr[dest] = leftArr[left];
                left++;
            } else {
                arr[dest] = rightArr[right];
                right++;
            }
            dest++;
        }
        // Copy remaining elements of leftArr, if any
        while (left < len1) {
            arr[dest] = leftArr[left];
            left++;
            dest++;
        }
        // Copy remaining elements of rightArr, if any
        while (right < len2) {
            arr[dest] = rightArr[right];
            right++;
            dest++;
        }
    }

    void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }
}