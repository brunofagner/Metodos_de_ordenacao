package metodosComplexos;

public class ShellSort extends Ordenador{
      public int[] sort(int array[]) {
            int h = 1;
            int n = array.length;

            while (h < n) {
                  h = h * 3 + 1;
                  contComp++;
            }
            h = h / 3;
            int c, j;
            while (h > 0) {
                  for (int i = h; i < n; i++) {
                        c = array[i];
                        j = i;
                        contComp += 2;
                        while (j >= h && array[j - h] > c) {
                              array[j] = array[j - h];
                              contMov++;
                              j = j - h;
                              contComp++;
                        }
                        array[j] = c;
                        contComp++;
                  }
                  h = h / 2;
                  contComp++;
            }
            return array;
      }
}
