import java.util.*;

public class RadixSortNegativos {
      public static void main(String[] args) {
        int[] v = new int[]{-12, 52, 456, -101, -23, 45, 44, 98, 100, -1, 1, 99, 101};
        radixSortNeg(v);
        System.out.println(Arrays.toString(v));
      }

      public static void radixSortNeg(int[] v){
        int[][] negPosi = separaNegsPosi(v);
        int[] posi = negPosi[0];
        int[] neg = negPosi[1];

        radixSort(posi);
        radixSort(neg);

        inverteArr(neg);

        int iN = 0, iP = 0;
        for(int i = 0; i < v.length; i++){
            if(i < neg.length) v[i] = neg[iN++];
            else v[i] = posi[iP++];
        }

      }

      private static void inverteArr(int[] v){
        int i = 0, j = v.length-1;
        while( i < j){
            int aux = v[i];
            v[i] = v[j];
            v[j] = aux;
            i++;
            j--;
        }
      }

      private static void radixSort(int[] v){
        int dig = ("" + maiorNum(v)).length();

        for(int i = 1; i <= dig; i++){
            counting(v, i);
        }
      }

      private static void counting(int[] a, int d){
        int[] c = new int[10];
        int div = (int) Math.pow(10, d-1);
        int dig;
        
        for(int i = 0; i < a.length; i++){
            dig = Math.abs((a[i]/div) % 10);
            c[dig]++;
        }

        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }
        
        int[] b = new int[a.length];
        for(int i = a.length-1; i >= 0; i--){
            dig = Math.abs((a[i]/div) % 10);
            b[c[dig]-1] = a[i];
            c[dig]--;
        }

        for(int i = 0; i < a.length; i++){
            a[i] = b[i];
        }
      }

      private static int maiorNum(int[] v){
        int maior = 0;
        for(int i = 0; i < v.length; i++){
            if(Math.abs(v[i]) > maior) maior = Math.abs(v[i]);
        }
        return maior;
      }

      private static int[][] separaNegsPosi(int[] v){
        int tam = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i] < 0) tam++;
        }

        int[] arrPosi = new int[v.length-tam];
        int[] arrNeg = new int[tam];
        int iN = 0, iP = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i] >= 0) arrPosi[iP++] = v[i];
            else arrNeg[iN++] = v[i];
        }

        int[][] ret = new int[][]{arrPosi, arrNeg};
        return ret;
      }
}
