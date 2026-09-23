import java.util.Scanner;

public class MarianaEOsLivros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(",");

        InsertionSort(ent);
    }

    public static void InsertionSort(String[] linha){
        System.out.println(formata(linha));
        for(int i = 1; i < linha.length; i++){
            int j = i;
            
            while(j > 0 && compara(linha[j].compareTo(linha[j-1]))){
                swap(linha, j, j-1);
                j--;
            }
            System.out.println(formata(linha));
        }
    }

    private static void swap(String[] v, int i, int j){
        String aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    private static boolean compara(int valor){
        if(valor < 0) return true;
        return false;
    }

    private static String formata(String[] l){
        String out = "";
        for (int i = 0; i < l.length; i++) {
            if(i+1 > l.length-1){
                out += l[i];
            } else{
                out += l[i] + ", ";
            }
        }
        return out;
    }
}
