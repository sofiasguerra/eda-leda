import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 4, 1, 3, 33, 66, 956, 120, 01, -3, 0};
        int[] b = new int[]{2, 5, 4, 1, 3, 33, 66, 956, 120, 01, -3, 0};
        quickSortL(a, 0, a.length-1);
        quickSortH(b, 0, b.length-1);
        System.out.println("Lomuto: " + Arrays.toString(a));
        System.out.println("Hoare: " + Arrays.toString(b));
    }

    private static void quickSortH(int[] v, int ini, int fim){
        if (ini >= fim) return;
        int idxPivot = hoare(v, ini, fim);
        quickSortH(v, ini, idxPivot - 1);
        quickSortH(v, idxPivot + 1, fim);
    }

    private static void quickSortL(int[] v, int ini, int fim) {
        if (ini >= fim) return;
        int idxPivot = lomuto(v, ini, fim);
        quickSortL(v, ini, idxPivot - 1);
        quickSortL(v, idxPivot + 1, fim);
    }

    private static int lomuto(int[] v, int ini, int fim){
        int idxPivot = ramdomPivot(v, ini, fim);
        swap(v, ini, idxPivot);

        int pivot = v[ini];
        int i = ini;
        for(int j = ini + 1; j <= fim; j++){
            if(v[j] <= pivot) swap(v, ++i, j);
        }

        swap(v, ini, i);
        return i;
    }

    private static int hoare(int[] v, int ini, int fim){
        int idxPivot = medianaDeTres(v, ini, fim);
        swap(v, ini, idxPivot);

        int pivot = v[ini];
        int i = ini;
        int j = fim;
        
        while(i <= j){

            while(i <= j && v[i] <= pivot) i++;

            while(j >= i && v[j] > pivot) j--;

            if(i < j) swap(v, i, j);
        }

        swap(v, ini, j);
        return j;
    }

    private static int medianaDeTres(int[] v, int ini, int fim){
        int p = v[ini];
        int m = v[(ini+fim)/2];
        int u = v[fim];

        if((m <= p && p <= u) || (u <= p && p <= m)) return ini;
        else if((p <= m && m <= u) || (u <= m && m <= p)) return (ini+fim)/2;
        return fim;
    }

    private static int ramdomPivot(int[] v, int ini, int fim){
        Random rd = new Random();
        int idxPivot = ini + rd.nextInt(fim - ini + 1);
        return idxPivot;
    }
    
    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
