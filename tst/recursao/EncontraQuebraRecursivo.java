import java.util.Scanner;

class EncontraQuebraRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ")
;

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        System.out.println(EncontraQuebra(nums, 0));
    }   

    public static int EncontraQuebra(int[] nums, int i){
        if(i > nums.length-2){
            return -1;
        }
        if(nums[i+1] < nums[i]){
            return i+1;
        }
        return EncontraQuebra(nums, i+1);
    }
}
