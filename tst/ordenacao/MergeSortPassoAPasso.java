import java.util.*;

class MergeSortPassoAPasso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        mergeSort(nums, 0, nums.length-1);
        
    }

    private static void mergeSort(int[] v, int left, int rigth){
        imprimeTrecho(v, left, rigth);
        if (left >= rigth) return;
        int middle = (left + rigth)/2;
        mergeSort(v, left, middle);
        mergeSort(v, middle+1, rigth);
        merge(v, left, rigth);
        imprimeTrecho(v, left, rigth);
    }

    private static void merge(int[] v, int ini, int fim){
        int tamHelper = fim-ini;
        int[] helper = new int[tamHelper+1];
        for(int x = 0; x <= tamHelper; x++){
            helper[x] = v[ini+x];
        }

        int meioHelper = tamHelper/2;
        int i = 0;
        int j = meioHelper + 1;
        int k = ini;
        while (i <= meioHelper && j <= tamHelper){
            if(helper[i] <= helper[j]) v[k++] = helper[i++];
            else v[k++] = helper[j++];
        }

        while(i <= meioHelper){
            v[k++] = helper[i++];
        }
    }
    
    private static void imprimeTrecho(int[] v, int ini, int fim){
        System.out.println(Arrays.toString(Arrays.copyOfRange(v, ini, fim + 1)));
    }
}
