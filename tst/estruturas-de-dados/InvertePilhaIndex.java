import java.util.*;

class InvertePilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tam = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        int index = sc.nextInt();
        ArrayDeque<Integer> pilha = new ArrayDeque<>(tam);

        for (String value : line)
            pilha.push(Integer.parseInt(value));

        System.out.println("-");
        invertePilha(pilha, index);
        for(int i : pilha)
            System.out.println(i);
    }

    private static void invertePilha(ArrayDeque<Integer> pilha, int i){
        ArrayDeque<Integer> aux = new ArrayDeque<>();
        for(int j = 0; j <= i; j++)
            aux.addLast(pilha.pop());
        while(!aux.isEmpty())
            pilha.push(aux.removeFirst());
    }
}
