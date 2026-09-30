import java.util.Arrays;
import java.util.Scanner;

class RadixDoisDigitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int d = sc.nextInt();

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        radixDoisDigitos(nums, d);
    }

    private static void radixDoisDigitos(int[] v, int d){
        for(int nDig = 2; nDig <= d; nDig += 2){
            count(v, nDig);
        }
    }

    private static void count(int[] A, int fator){
        //Contagem
        int[] C = new int[99];
        int exp = (int) Math.pow(10, fator-2);
        int digitos;
        for(int i = 0; i < A.length; i++){
            digitos = (A[i]/exp) % 100;
            C[digitos-1]++;
        }

        //Cumilativo
        for(int i = 1; i < C.length; i++){
            C[i] += C[i-1];
        }

        //Ordenação
        int[] B = new int[A.length];
        for(int i = B.length-1; i >= 0; i--){
            digitos = (A[i]/exp) % 100;
            B[C[digitos-1]-1] = A[i];
            C[digitos-1]--;
        }

        //Cópia
        for(int i = 0; i < B.length; i++){
            A[i] = B[i];
        }

        System.out.println(Arrays.toString(A));
    }

}
