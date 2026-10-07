import java.util.*;

class TopN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int n = sc.nextInt();

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        int[] resul = top(nums, n);
        String saida = "";
        for(int i = 0; i < resul.length; i++){
            saida += resul[i] + " ";
        }
        System.out.println(saida.trim());
    }

    private static int[] top(int[] v, int n){
        int[] resul = new int[n];
        int limite = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            int maior = v[0];
            for(int j = 0; j < v.length; j++){
                if(v[j] > maior && v[j] < limite){
                    maior = v[j];
                }
            }
            limite = maior;
            resul[i] = maior;
        }
        return resul;
    }
}

