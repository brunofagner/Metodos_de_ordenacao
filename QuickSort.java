import java.util.Random;

public class QuickSort extends Ordenador {
      @Override
      public int[] sort(int[] array) {
            return quickSort(array, 0, array.length-1);
      }
      private int[] quickSort(int[] array, int lowIndex, int highIndex) {

            if (lowIndex >= highIndex) {
                  return array;
            }
        
            int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
            int pivot = array[pivotIndex];
            contOp+=2;
            swap(array, pivotIndex, highIndex);
        
            int leftPointer = partition(array, lowIndex, highIndex, pivot);
            contOp++;
            quickSort(array, lowIndex, leftPointer - 1);
            contOp++;
            quickSort(array, leftPointer + 1, highIndex);
            contOp++;
            return array;
      }
        
          private int partition(int[] array, int lowIndex, int highIndex, int pivot) {
            int leftPointer = lowIndex;
            int rightPointer = highIndex - 1;
            
            while (leftPointer < rightPointer) {
                        
                  while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                        contOp++;
                        leftPointer++;
                  }
        
                  while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                        contOp++;
                        rightPointer--;
                  }
        
              swap(array, leftPointer, rightPointer);
            }
            
            if(array[leftPointer] > array[highIndex]) {
              swap(array, leftPointer, highIndex);
            }
            else {
              leftPointer = highIndex;
            }
            
            return leftPointer;
          }
        
          private void swap(int[] array, int index1, int index2) {
            contOp++;
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
            contOp+=2;
            contMov++;
          }
        
      
}
