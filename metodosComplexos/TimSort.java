package metodosComplexos;

public class TimSort extends Ordenador {

      @Override
      public int[] sort(int[] array) {
            return timSort(array);
      }
      static int MIN_MERGE = 32;

      public int minRunLength(int n) {
            assert n >= 0;

            // Becomes 1 if any 1 bits are shifted off
            int r = 0;
            while (n >= MIN_MERGE) {
                  r |= (n & 1);
                  n >>= 1;
            }
            return n + r;
      }

      // This function sorts array from left index to
      // to right index which is of size atmost RUN
      public void insertionSort(int[] arr, int left,
                  int right) {
            for (int i = left + 1; i <= right; i++) {
                  int temp = arr[i];
                  int j = i - 1;
                  while (j >= left && arr[j] > temp) {
                        arr[j + 1] = arr[j];
                        j--;
                        contMov++;
                  }
                  arr[j + 1] = temp;
            }
      }

      // Merge function merges the sorted runs
      public void merge(int[] arr, int l,
                  int m, int r) {
            // Original array is broken in two parts
            // left and right array
            int len1 = m - l + 1, len2 = r - m;
            int[] left = new int[len1];
            int[] right = new int[len2];
            for (int x = 0; x < len1; x++) {
                  left[x] = arr[l + x];
                  contMov++;
            }
            for (int x = 0; x < len2; x++) {
                  right[x] = arr[m + 1 + x];
                  contMov++;
            }

            int i = 0;
            int j = 0;
            int k = l;

            // After comparing, we merge those two array
            // in larger sub array
            while (i < len1 && j < len2) {
                  contComp++;
                  if (left[i] <= right[j]) {
                        contMov++;
                        arr[k] = left[i];
                        i++;
                  } else {
                        contMov++;
                        arr[k] = right[j];
                        j++;
                  }
                  k++;
            }

            // Copy remaining elements
            // of left, if any
            while (i < len1) {
                  contMov++;
                  arr[k] = left[i];
                  k++;
                  i++;
            }

            // Copy remaining element
            // of right, if any
            while (j < len2) {
                  contMov++;
                  arr[k] = right[j];
                  k++;
                  j++;
            }
      }

      // Iterative Timsort function to sort the
      // array[0...n-1] (similar to merge sort)
      public int[] timSort(int[] array) {
            int minRun = minRunLength(MIN_MERGE);

            // Sort individual subarrays of size RUN
            for (int i = 0; i < array.length; i += minRun) {
                  insertionSort(array, i,
                              Math.min((i + MIN_MERGE - 1), (array.length - 1)));
            }

            // Start merging from size
            // RUN (or 32). It will
            // merge to form size 64,
            // then 128, 256 and so on
            // ....
            for (int size = minRun; size < array.length; size = 2 * size) {

                  // Pick starting point
                  // of left sub array. We
                  // are going to merge
                  // arr[left..left+size-1]
                  // and arr[left+size, left+2*size-1]
                  // After every merge, we
                  // increase left by 2*size
                  for (int left = 0; left < array.length; left += 2 * size) {

                        // Find ending point of left sub array
                        // mid+1 is starting point of right sub
                        // array
                        int mid = left + size - 1;
                        int right = Math.min((left + 2 * size - 1),
                                    (array.length - 1));

                        // Merge sub array arr[left.....mid] &
                        // arr[mid+1....right]
                        if (mid < right)
                              merge(array, left, mid, right);
                  }
            }
            return array;
      }
}
