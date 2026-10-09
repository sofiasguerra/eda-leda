import java.util.*;

class ParticionaLomuto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        lomuto(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void lomuto(int[] v){
        int pivot = v[0];
        int i = 0;
        for(int j = 1; j < v.length; j++){
            if(v[j] < pivot) {
                swap(v, j, ++i);
                System.out.println(Arrays.toString(v));
            }
        }
        swap(v, i, 0);
        System.out.println(Arrays.toString(v));
    }

    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
