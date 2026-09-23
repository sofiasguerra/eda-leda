import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo_E_Primeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");

        int[] nums = new int[linha.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(linha[i]);
        }

        sortUltimo(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sortUltimo(int[] v){
        int i = v.length-1;
        while (i > 0 && v[i] < v[i-1]){
            swap(v, i, i-1);
            i--;
        }
    }

    public static void sortPrimeiro(int[] v){
        int i = 0;
        while (i < v.length-1 && v[i] > v[i+1]){
            swap(v, i, i+1);
            i++;
        }
    }

    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
