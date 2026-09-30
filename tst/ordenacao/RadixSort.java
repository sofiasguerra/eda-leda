import java.util.Arrays;
import java.util.Scanner;

class RadixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int d = sc.nextInt();

        int[] nums = new int[ent.length];
            for(int i = 0; i < ent.length; i++){
                nums[i] = Integer.parseInt(ent[i]);
            }
        
        radix(nums, d);
    }

    private static void radix(int[] v, int d){
        for(int nDig = 1; nDig <= d; nDig++){
            countSortPorDigito(v, nDig);
        }
    }

    private static void countSortPorDigito(int[] v, int d){
        //Contagem
        int[] C = new int[10];
        int digito;
        int exp = (int) Math.pow(10, d-1);
        for(int i = 0; i < v.length; i++){
            digito = (v[i]/exp) % 10;
            C[digito]++;
        }
        //Cumulativa
        for(int i = 1; i < C.length; i++){
            C[i] += C[i-1];
        }
        //Ordenação
        int[] B = new int[v.length];
        for(int i = v.length-1; i >= 0; i--){
            digito = (v[i]/exp) % 10;
            B[C[digito]-1] = v[i];
            C[digito]--;
        }
        //Cópia
        for(int i = 0; i < v.length; i++){
            v[i] = B[i];
        }
        System.out.println(Arrays.toString(B));
    }
}
