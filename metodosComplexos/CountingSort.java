package metodosComplexos;

public class CountingSort extends Ordenador{
      public int[] sort(int array[]) {
            array = positive(array);

            int[] output = new int[array.length + 1];

            // Find the largest element of the array
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                  if (array[i] > max) max = array[i];      
            }
            
            int[] count = new int[max + 1];

            // Initialize count array with all zeros.
            for (int i = 0; i < max; ++i) {
                  count[i] = 0;
            }

            // Store the count of each element
            for (int i = 0; i < array.length; i++) {
                  count[array[i]]++;
            }

            // Store the cummulative count of each array
            for (int i = 1; i <= max; i++) {
                  count[i] += count[i - 1];
            }

            // Find the index of each element of the original array in count array, and
            // place the elements in output array
            for (int i = array.length - 1; i >= 0; i--) {
                  contMov++;
                  output[count[array[i]] - 1] = array[i];
                  count[array[i]]--;
            }

            // Copy the sorted elements into original array
            for (int i = 0; i < array.length; i++) {
                  array[i] = output[i];
                  contMov++;
            }
            array = negative(array);
            return array;
      }

      public int[] positive(int[] array){
            int menor = array[0];
            for (int i : array) if (i < menor) menor = i;
            for (int i = 0; i < array.length; i++) array[i]+=(menor*-1);
            return array;
      }
      public int[] negative(int[] array){
            int menor = array[0];
            for (int i : array) if (i < menor) menor = i;
            for (int i = 0; i < array.length; i++) array[i]+=menor;
            return array;
      }
}