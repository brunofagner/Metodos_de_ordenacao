package metodosComplexos;

public class GnomeSort extends Ordenador {
      public int[] sort(int[] array) {
            int pivout = 0;
            int aux;
            while (pivout < (array.length - 1)) {
                  contComp++;
                  if (array[pivout] > array[pivout + 1]) {
                        aux = array[pivout];
                        array[pivout] = array[pivout + 1];
                        array[pivout + 1] = aux;
                        contMov+=2;
                        contComp++;
                        if (pivout > 0) {
                              pivout -= 2;
                        }
                  }
                  pivout++;
            }
            return array;
      }
}
