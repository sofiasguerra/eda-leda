import java.util.*;

class MoveTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        moveTres(nums);
    }
    
    private static void moveTres(int[] v){
        int idx = 0;
        for(int i = 0; i < v.length-1; i++){
            if(v[i+1] < v[i]){
                idx = i+1;
                break;
            }
        }
        
        for(int i = 0; i < 3; i++){
            troca(v, idx+i);
        }
    }
    
    private static void troca(int[] v, int idx){
        int j = idx-1;
        while(j >= 0 && v[idx] < v[j]){
            int aux = v[idx];
            v[idx] = v[j];
            v[j]= aux;
            System.out.println(Arrays.toString(v));
            j--;
            idx--;
        }
    }
}
