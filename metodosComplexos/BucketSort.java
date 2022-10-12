package metodosComplexos;
import java.util.LinkedList;
public class BucketSort extends Ordenador {

      @Override
      public int[] sort(int[] array) {
            int menor = array[0];
            for (int i : array) if(menor > i) menor = i;
            for (int i = 0; i < array.length; i++) {
                  array[i] -= menor;
            }
            int maiorValor = array[0];
            for (int i : array) if (i > maiorValor) maiorValor = i;

            int numBaldes = maiorValor / 5;

            LinkedList[] B = new LinkedList[numBaldes];

            for (int i = 0; i < numBaldes; i++) {
                  B[i] = new LinkedList<Integer>();
            }

            // Coloca os valores no balde respectivo:
            for (int i = 0; i < array.length; i++) {
                  int j = numBaldes - 1;
                  while (true) {
                        if (j < 0) {
                              break;
                        }
                        contComp++;
                        if (array[i] >= (j * 5)) {
                              B[j].add(array[i]);
                              break;
                        }
                        j--;
                  }
            }

            // Ordena e atualiza o array:
            ComboSort ordenador = new ComboSort();
            int indice = 0;
            for (int i = 0; i < numBaldes; i++) {

                  int[] aux = new int[B[i].size()];

                  // Coloca cada balde num array:
                  for (int j = 0; j < aux.length; j++) {
                        contMov++;
                        aux[j] = (Integer) B[i].get(j);
                  }
                  ordenador.sort(aux); // algoritmo escolhido para ordenação.
                  // Devolve os valores ao array de entrada:
                  for (int j = 0; j < aux.length; j++, indice++) {
                        array[indice] = aux[j];
                        contMov++;
                  }

            }
            for (int i = 0; i < array.length; i++) {
                  array[i] += menor;
            }
            return array;
      }

}
