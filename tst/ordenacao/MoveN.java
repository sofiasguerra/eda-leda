import java.util.*;

class MoveN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }
        move(nums);
    }
    
    private static void move(int[] v){
        int idxQuebra = v.length;
        
        for(int i = 0; i < v.length-1; i++){
            if(v[i] > v[i+1]){
                idxQuebra = i+1;
                break;
            }
        }
        
        int limite = 0;
        for(int j = idxQuebra; j < v.length; j++){
            int i = j;
            while(i > limite && v[i] < v[i-1]){
                int aux = v[i];
                v[i] = v[i-1];
                v[i-1] = aux;
                System.out.println(Arrays.toString(v));
                i--;
            }
            limite = i + 1;
        }
    }
}
