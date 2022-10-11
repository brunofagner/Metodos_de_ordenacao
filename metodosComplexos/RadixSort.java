package metodosComplexos;

public class RadixSort extends Ordenador {

      // Using counting sort to sort the elements in the basis of significant places
      void countingSort(int array[], int place) {
            int[] output = new int[array.length + 1];
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                  if (array[i] > max)
                        max = array[i];
                        contMov++;
            }
            int[] count = new int[max + 1];

            for (int i = 0; i < max; ++i)
                  count[i] = 0;

            // Calculate count of elements
            for (int i = 0; i < array.length; i++)
                  count[(array[i] / place) % 10]++;

            // Calculate cumulative count
            for (int i = 1; i < 10; i++)
                  count[i] += count[i - 1];

            // Place the elements in sorted order
            for (int i = array.length - 1; i >= 0; i--) {
                  contMov++;
                  output[count[(array[i] / place) % 10] - 1] = array[i];
                  count[(array[i] / place) % 10]--;
            }

            for (int i = 0; i < array.length; i++)
                  array[i] = output[i];
      }

      // Function to get the largest element from an array
      int getMax(int array[], int n) {
            int max = array[0];
            for (int i = 1; i < n; i++)
                  if (array[i] > max)
                        max = array[i];
            return max;
      }

      // Main function to implement radix sort
      public int[] sort(int array[]) {
            int menor = array[0];
            for (int i : array) if (i < menor) menor = i;
            for (int i = 0; i < array.length; i++) array[i] += (menor * -1);
            // Get maximum element
            int max = getMax(array, array.length);

            // Apply counting sort to sort elements based on place value.
            for (int place = 1; max / place > 0; place *= 10)
                  countingSort(array, place);

            for (int i = 0; i < array.length; i++) array[i] += menor;
            return array;
      }

}