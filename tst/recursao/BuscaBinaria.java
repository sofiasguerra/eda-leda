import java.util.Scanner;

class BuscaBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int n = sc.nextInt();

        int[] seq = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            seq[i] = Integer.parseInt(ent[i]);
        }
        System.out.println(BuscaBinaria(seq, n));
    }

    public static int BuscaBinaria(int[] seq, int key){
        int ini = 0;
        int fim = seq.length-1;
        while(fim >= ini){
            int meio = (ini + fim)/2;

            if(seq[meio] == key){
                return meio;
            }
            System.out.println(meio);
            if(seq[meio] > key){
                fim = meio-1;
            } else {
                ini = meio+1;
            }
        }
        return -1;
    }
}
