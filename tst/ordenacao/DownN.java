import java.util.*;

class DownN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int n = sc.nextInt();

        int[] nums = new int[ent.length];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        int[] resul = downN(nums, n);
        String out = "";
        for(int i = 0; i < resul.length; i++){
            out += resul[i] + " ";
        }

        System.out.println(out.trim());
    }

    private static int[] downN(int[] v, int n){
        int[] resul = new int[n];

        for(int i = 0; i < n; i++){
            int idxMenor = i;
            for(int j = i + 1; j < v.length; j++)
                if(v[j] < v[idxMenor])
                    idxMenor = j;
                
            int aux = v[i];
            v[i] = v[idxMenor];
            v[idxMenor] = aux;
            resul[i] = v[i];
        }

        return resul;
    }
}
