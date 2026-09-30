import java.util.Arrays;
import java.util.Scanner;

class ParticionamentoLomuto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        lomuto(nums);
    }

    public static void lomuto(int[] arr){
        int pivot = arr[arr.length-1];
        int i = arr.length-1;
        for(int j = arr.length-2; j >= 0; j--){
            if(pivot < arr[j]){
                swap(arr, --i, j);
                System.out.println(Arrays.toString(arr));
            }
        }
        swap(arr, i, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
