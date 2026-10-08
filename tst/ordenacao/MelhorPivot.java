import java.util.*;

class MelhorPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        
        int[] nums = new int[ent.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }
       
        String[] idx = sc.nextLine().split(" ");
        int i = Integer.parseInt(idx[0]);
        int j = Integer.parseInt(idx[1]);

        System.out.println(testaPivot(nums, i, j));
    }

    private static int testaPivot(int[] v, int i, int j){
        int menoresI = 0;
        int maioresI = 0;

        int menoresJ = 0;
        int maioresJ = 0;

        for(int k = 0; k < v.length; k++){
             if(k != i){
                if(v[k] > v[i]) maioresI++;
                else menoresI++;
              }

            if(k != j){
                if(v[k] > v[j]) maioresJ++;
                else menoresJ++;
             }
        }

        int piorJ = Math.max(maioresJ, menoresJ);
        int piorI = Math.max(menoresI, maioresI);

        if(piorJ < piorI) return j;
        return i;
    }
}
