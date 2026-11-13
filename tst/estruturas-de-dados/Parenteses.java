import java.util.*;

class Parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ent = sc.nextLine();

        System.out.println(valida(ent));
        
    }
    
    private static String valida(String ent){
        ArrayDeque<Character> pilha = new ArrayDeque<>();
        
        for(char c : ent.toCharArray()){
            if(c == '(') pilha.push(c);
            else if(c == ')') {
                if(pilha.isEmpty()) return "N";
                pilha.pop();
            }
        }
        if(pilha.isEmpty()) return "S";
        return "N";
    }
}
