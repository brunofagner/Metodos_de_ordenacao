public class BubbleSort extends Ordenador{
   
      public int[] sort(int array[]) {

          int aux;
          for (int i = 0; i < array.length; i++) {
             for (int j = i+1; j < array.length; j++) {
                this.contOp++;
                if (array[i] > array[j]) {
                   aux = array[j];
                   this.contOp++;
                   array[j] = array[i];
                   this.contOp++;
                   array[i] = aux;
                   this.contOp++;
                   this.contMov++;
                }
                this.contOp++;
             }
             this.contOp++;
          }
          
          return array;
      }
   }