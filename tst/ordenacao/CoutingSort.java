import java.util.Scanner;

class CoutingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int k = sc.nextInt();

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        count(nums, k); 
    }

    public static void count(int[] A, int k){
        int[] C = new int[k+1];
        //Contagem
        for(int i = 0; i < A.length; i++){
            C[A[i]] += 1;
            System.out.println(imprimir(C));
        }
        //Cumulativa
        for(int i = 1; i < k+1; i++){
            C[i] += C[i-1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + imprimir(C));
        //Ordenação
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
            B[C[A[i]]-1] = A[i];
            C[A[i]] -= 1;
        }
        System.out.println(imprimir(C));
        System.out.println(imprimir(B));
    }

    private static String imprimir(int[] v){
        String s = new String();
        for(int i = 0; i < v.length; i++){
            if(i > 0) s += " ";
            s += v[i];
        }
        return s;
    }
}
