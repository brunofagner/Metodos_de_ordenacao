import metodosComplexos.Ordenador;

public class SelectionSort extends Ordenador{
      public int[] sort(int array[]) {
          int n = array.length;

          for (int i = 0; i < n - 1; i++) {
              contComp++;
              int min = i;
   
              for (int j = i + 1; j < n; j++) {
                  if (array[j] < array[min]) {
                      min = j;
                      contComp++;
                  }
                  contComp++;
              }
   
              int temp = array[min];
              contComp++;
              array[min] = array[i];
              contComp++;
              array[i] = temp;
              contComp++;
              contMov++;
          }
          return array;
      }
   }