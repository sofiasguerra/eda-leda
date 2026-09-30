import java.util.*;

class RadixTresDigitos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int d = sc.nextInt();

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        radix(nums, d);
    }

    private static void radix(int[] v, int d){
        for(int nDig = 3; nDig <= d; nDig += 3){
            count(v, nDig);
        }
    }

    private static void count(int[] a, int d){
        //Contagem
        int[] c = new int[999];
        int fator = (int) Math.pow(10, d-3);
        int dig;
        for(int i = 0; i < a.length; i++){
            dig = (a[i]/fator) % 1000;
            c[dig-1]++;
        }

        //Cumulativo
        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        //Ordenação
        int[] b = new int[a.length];
        for(int i = b.length-1; i >= 0; i--){
            dig = (a[i]/fator) % 1000;
            b[c[dig-1]-1] = a[i];
            c[dig-1]--;
        }

        //Cópia
        for(int i = 0; i < b.length; i++) a[i] = b[i];

        System.out.println(Arrays.toString(a));
    }
}
