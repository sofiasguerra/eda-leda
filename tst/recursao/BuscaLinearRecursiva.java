import java.util.Scanner;

class BuscaLinearRecursiva {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");
        int n = sc.nextInt();

        int[] numeros = new int[linha.length];
        for(int i = 0; i < numeros.length; i++){
            numeros[i] = Integer.parseInt(linha[i]);
        }

        System.out.println(BuscaRecursiva(numeros, n, 0));
     }

     public static int BuscaRecursiva(int[] seq, int key, int i){
        if (i >= seq.length) return -1;
        if (seq[i] == key) return i;
        return BuscaRecursiva(seq, key, i+1);
     }
}
