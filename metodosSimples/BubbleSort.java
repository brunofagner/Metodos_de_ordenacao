import metodosComplexos.Ordenador;

public class BubbleSort extends Ordenador{
   
      public int[] sort(int array[]) {

          int aux;
          for (int i = 0; i < array.length; i++) {
             for (int j = i+1; j < array.length; j++) {
                this.contComp++;
                if (array[i] > array[j]) {
                   aux = array[j];
                   this.contComp++;
                   array[j] = array[i];
                   this.contComp++;
                   array[i] = aux;
                   this.contComp++;
                   this.contMov++;
                }
                this.contComp++;
             }
             this.contComp++;
          }
          
          return array;
      }
   }