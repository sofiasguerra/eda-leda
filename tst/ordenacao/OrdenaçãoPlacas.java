import java.util.*;

class OrdenaçãoPlacas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(",");

        radixSort(ent);
        System.out.println(String.join(", ", ent));
    }

    private static void radixSort(String[] v){
        for(int i = 1; i <= 4; i++){
            counting(v, i);
        }
    }

    private static void counting(String[] a, int d){
        int[] c = new int[10];
        int dig;

        for(int i = 0; i < a.length; i++){
            dig = (int) a[i].charAt(a[i].length() - d) - '0';
            c[dig]++;
        }

        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        String[] b = new String[a.length];
        for (int i = b.length-1; i >= 0; i--){
            dig = (int) a[i].charAt(a[i].length() - d) - '0';
            b[c[dig]-1] = a[i];
            c[dig]--;
        }

        for(int i = 0; i < b.length; i++){
            a[i] = b[i];
        }
    }
}
