import java.util.*;

public class RadixSortComDoisDigitos {
    public static void main(String[] args) {
        int[] a = new int[]{5435, 1234, 7655, 3082, 9081, 9080, 5435};
        radix(a);
        System.out.println(Arrays.toString(a));
    }

    private static void radix(int[] v){
        int dig = ("" + v[0]).length();
        for (int i = 2; i <= dig; i += 2){
            counting(v, i);
        } 
    }

    private static void counting(int[] a, int d){
        int[] c = new int[100];
        int div = (int) Math.pow(10, d-2);
        int dig;

        //Frequencia
        for(int i = 0; i < a.length; i++){
            dig = (a[i]/div) % 100;
            c[dig]++;
        }

        //Cumulativa
        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        //Ordenação
        int[] b = new int[a.length];
        for(int i = b.length-1; i >= 0; i--){
            dig = (a[i]/div) % 100;
            b[c[dig]-1] = a[i];
            c[dig]--;
        }

        //Cópia   
        for(int i = 0; i < b.length; i++){
            a[i] = b[i];
        }
    }
}
