import metodosComplexos.Ordenador;

class InsertionSort extends Ordenador{
      public int[] sort(int array[]) {
         int tamanho = array.length;
         for (int i = 1; i < tamanho; ++i) {
            int chave = array[i];
            int j = i - 1;
            contComp++;
            while (j >= 0 && array[j] > chave) {
               contMov++;
               contComp++;
               array[j + 1] = array[j];
               contComp++;
               j = j - 1;
            }
            array[j + 1] = chave;
            contComp++;
         }
         return array;
      }
   }