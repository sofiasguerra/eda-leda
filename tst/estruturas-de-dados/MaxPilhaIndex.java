import java.util.*;

class MaxPilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int idxLimite = sc.nextInt();

        ArrayDeque<Integer> pilha = new ArrayDeque<>();
        for(String c : ent)
            pilha.push(Integer.parseInt(c));

        System.out.println(maxPilhaIdx(pilha, idxLimite));
    }

    private static int maxPilhaIdx(ArrayDeque<Integer> pilha, int idx){
        ArrayDeque<Integer> aux = new ArrayDeque<>();
        int maior = pilha.peek();
        for(int i = 0; i <= idx; i++){
            int k = pilha.pop();
            if(k > maior) maior = k;
            aux.push(k);
        }
        while(!aux.isEmpty())
            pilha.push(aux.pop());

        return maior;
    }
}
