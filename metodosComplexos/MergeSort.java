package metodosComplexos;

public class MergeSort extends Ordenador {
      int[] array;

      @Override
      public int[] sort(int[] array) {
            this.array = array;
            mergeSort(array);
            return this.array;
      }

      private void mergeSort(int[] array) {

            if (array.length < 2) {
                  return;
            }

            int midIndex = array.length / 2;
            int[] leftHalf = new int[midIndex];
            int[] rightHalf = new int[array.length - midIndex];

            for (int i = 0; i < midIndex; i++) {
                  leftHalf[i] = array[i];
                  contMov++;
            }
            for (int i = midIndex; i < array.length; i++) {
                  rightHalf[i - midIndex] = array[i];
                  contMov++;
            }

            mergeSort(leftHalf);
            mergeSort(rightHalf);

            merge(array, leftHalf, rightHalf);
      }

      private void merge(int[] array, int[] leftHalf, int[] rightHalf) {
            int leftSize = leftHalf.length;
            int rightSize = rightHalf.length;

            int i = 0, j = 0, k = 0;

            while (i < leftSize && j < rightSize) {
                  contOp++;
                  if (leftHalf[i] <= rightHalf[j]) {
                        array[k] = leftHalf[i];
                        contMov++;
                        i++;
                  } else {
                        array[k] = rightHalf[j];
                        contMov++;
                        j++;
                  }
                  k++;
            }

            while (i < leftSize) {
                  contMov++;
                  array[k] = leftHalf[i];
                  i++;
                  k++;
            }

            while (j < rightSize) {
                  contMov++;
                  array[k] = rightHalf[j];
                  j++;
                  k++;
            }

      }

}