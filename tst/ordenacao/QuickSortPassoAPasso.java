import java.util.*;

class QuickSortPassoAPasso{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        quick(nums, 0, nums.length-1);
    }

    private static void quick(int[] v, int ini, int fim){
        if(ini >= fim)  return;
        int idxPivot = particionamento(v, ini, fim);
        imprime(v);
        quick(v, ini, idxPivot-1);
        quick(v, idxPivot+1, fim);
    }
    
    private static int particionamento(int[] v, int ini, int fim){
        int pivot = v[ini];
        int i = ini;
        for(int j  = ini + 1; j <= fim; j++){
            if(v[j] <= pivot){
                swap(v, ++i, j);
            }
        }
        swap(v, ini, i);
        return i;
    }
    
    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    private static void imprime(int[] v){
        String out = "";
        for(int i = 0; i < v.length; i++){
            out += v[i] + " ";
        }
        System.out.println(out.trim());
    }
}