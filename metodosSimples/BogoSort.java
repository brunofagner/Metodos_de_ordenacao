
import java.util.Random;

import metodosComplexos.Ordenador;

public class BogoSort extends Ordenador{
      Random random = new Random();

      public int[] sort(int array[]){
            while(!IsListSorted(array)){            
                        for (int i=0; i < (array.length - 1); i++) {
                              int j = random.nextInt(array.length);            
                              int temp = array[i];
                              array[i] = array[j];
                              array[j] = temp;
                              contComp += 5;
                              contMov++;
                        }
            }
            return array;
      }
      
      boolean IsListSorted(int[] numeros) {
            for (int j = 1; j < numeros.length; j++) {
               if (numeros[j] < numeros[j-1]) {
                  return false;
               }
               contComp++;
            }
            return true;
         }
}
