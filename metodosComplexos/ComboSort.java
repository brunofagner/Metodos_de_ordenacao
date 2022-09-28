package metodosComplexos;

public class ComboSort extends Ordenador{

      boolean swapped = true;
      public int[] sort(int array[]){
         int gap = array.length;
         boolean swapped = true;
         while (gap > 1 || swapped) {
            if (gap > 1){
                 gap = (int) (gap / 1.247330950103979);
            }
            int i = 0;
            swapped = false;
            while (i + gap < array.length) {
                  contComp++;
               if (array[i] > array[i + gap]) {
                  int aux = array[i];
                  array[i] = array[i + gap];
                  array[i + gap] = aux;
                  contComp += 4;
                  contMov++;
                  swapped = true;

               }
               i++;
            }
         }
         return array;
      }
}
