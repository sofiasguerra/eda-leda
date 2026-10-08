import java.util.*;

class EstatisticaDeOrdem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        int ord = estatisticaDeOrdem(nums);
        System.out.println(ord);
    }

    private static int estatisticaDeOrdem(int[] v){
        int n = v[0];
        int ord = 1;
        for(int i = 0; i < v.length; i++){
            if(v[i] < n) ord++;
        }
        particiona(v, 0, v.length-1);
        return ord;
    }

    private static void particiona(int[] v, int ini, int fim){
        int pivot = v[ini];
        int i = ini;
        for(int j = ini + 1; j <= fim; j++){
            if(v[j] < pivot) swap(v, ++i, j);
        }
        swap(v, ini, i);
    }

    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
