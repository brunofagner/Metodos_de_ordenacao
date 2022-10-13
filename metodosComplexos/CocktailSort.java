package metodosComplexos;

public class CocktailSort extends Ordenador {
      @Override
      public int[] sort(int[] array) {
            boolean swapped = true;
            int start = 0;
            int end = array.length;

            while (swapped == true) {
                  swapped = false;

                  for (int i = start; i < end - 1; ++i) {
                        contComp++;
                        if (array[i] > array[i + 1]) {
                              int temp = array[i];
                              array[i] = array[i + 1];
                              array[i + 1] = temp;
                              contMov++;
                              swapped = true;
                        }
                  }

                  if (swapped == false)
                        break;

                  swapped = false;

                  end = end - 1;

                  for (int i = end - 1; i >= start; i--) {
                        contComp++;
                        if (array[i] > array[i + 1]) {
                              contMov++;
                              int temp = array[i];
                              array[i] = array[i + 1];
                              array[i + 1] = temp;
                              swapped = true;
                        }
                  }

                  start = start + 1;
            }
            return array;
      }
}
