import java.util.*;

class TeoremaMestre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int a = Integer.parseInt(ent[0]);
        int b = Integer.parseInt(ent[1]);
        int ord = Integer.parseInt(ent[2]);

        String resul = teoremaMestre(a, b, ord);
        System.out.println(resul);
    }

    private static String teoremaMestre(int a, int b, int ord){
        int log = (int) (Math.log(a) / Math.log(b));
        if(log == ord) return "T(n) = theta(n**" + ord + " * log n)";
        else if(log > ord) return "T(n) = theta(n**" + ord + ")";
        return "T(n) = theta(n**" + ord + ")";
    }
}
