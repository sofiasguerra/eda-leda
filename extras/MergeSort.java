import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] v = new int[]{1,2,5,6,32,33,22,36,359,1,32,4,7,-2,-1,-5,23,-6};
        mergeSort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
    }

    private static void mergeSort(int[] v, int ini, int fim){
        if(ini >= fim) return;
        int meio = (ini + fim)/2;
        mergeSort(v, ini, meio);
        mergeSort(v, meio+1, fim);
        merge(v, ini, fim);
    }

    private static void merge(int[]v, int ini, int fim){
        int tamHelper = fim-ini;
        int[] helper = new int[tamHelper+1];
        for(int x = 0; x <= tamHelper; x++){
            helper[x] = v[ini + x];
        }

        int meioHelper = tamHelper/2;
        int i = 0, j = meioHelper+1, k = ini;
        while(i <= meioHelper && j <= tamHelper){
            if(helper[i] <= helper[j]) v[k++] = helper[i++];
            else v[k++] = helper[j++];
        }

        while(i <= meioHelper) v[k++] = helper[i++];
    }
}
