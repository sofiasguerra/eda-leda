import java.util.*;

class CoutingSortNegativos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int maior = sc.nextInt();
        int menor = sc.nextInt();

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        countingSortNegativos(nums, maior, menor);
    }

    private static int[] countingSortNegativos(int[]A, int maior, int menor){
        int min = Math.abs(menor);
        int[] C = new int[maior+min+1];
        
        //Contagem
        for(int i = 0; i < A.length; i++){
            C[A[i] + min] += 1;
            System.out.println(Arrays.toString(C));
        }

        //Cumulativa
        for(int i = 1; i < C.length; i++){
            C[i] += C[i-1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(C));

        //Ordenação
        int[] B = new int[A.length];
        for(int i = A.length-1; i >= 0; i--){
            B[C[A[i] + min]-1] = A[i];
            C[A[i] + min] -= 1;
        }
        System.out.println(Arrays.toString(C));
        System.out.println(Arrays.toString(B));
        return B;
    }
}
