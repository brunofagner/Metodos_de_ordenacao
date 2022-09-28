package metodosComplexos;

public class HeapSort extends Ordenador {
      public int[] sort(int[] array) {
            int tamanho = array.length;
            int i = tamanho / 2, pai, filho, t;
            while (true) {
                  contComp++;
                  if (i > 0) {
                        i--;
                        t = array[i];
                  } else {
                        tamanho--;
                        contComp++;
                        if (tamanho <= 0) {
                              return array;
                        }
                        t = array[tamanho];
                        array[tamanho] = array[0];
                  }
                  pai = i;
                  filho = ((i * 2) + 1);
                  while (filho < tamanho) {
                        contComp+=2;
                        if ((filho + 1 < tamanho) && (array[filho + 1] > array[filho])) {
                              filho++;
                        }
                        contComp++;
                        if (array[filho] > t) {
                              array[pai] = array[filho];
                              pai = filho;
                              contMov++;
                              filho = pai * 2 + 1;
                        } else {
                              break;
                        }
                  }
                  contMov++;
                  array[pai] = t;
            }
      }
}
