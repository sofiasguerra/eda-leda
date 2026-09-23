import java.util.Scanner;

class EncontraPrimeiroNegativo {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");

        int[] nums = new int[linha.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(linha[i]);
        }
        
        Integer resultado = EncontraNeg(nums, 0);
        System.out.println(resultado == null ? "-" : resultado.toString());
    }

    public static Integer EncontraNeg(int[] nums, int i){
        if(i > nums.length-1){
            return null;
        }
        if(nums[i] < 0){
            return nums[i];
        }
        return EncontraNeg(nums, i+1);
    }
}
