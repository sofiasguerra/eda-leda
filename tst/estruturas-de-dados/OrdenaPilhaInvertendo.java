import java.util.*;

class OrdenaPilhaInvertendo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tam = sc.nextInt();
        sc.nextLine();    
        String[] ent = sc.nextLine().split(" ");

        Pilha pilha = new Pilha(tam);
        for(String s : ent)
            pilha.push(Integer.parseInt(s));

        ordenaInvertePilha(pilha, pilha.size());
        
        System.out.println("-");
        while(!pilha.isEmpty())
            System.out.println(pilha.pop());

    }

    private static void ordenaInvertePilha(Pilha p, int n){
        for(int i = n; i >= 2; i--){
            int idx = p.getMax(i);
            p.inverte(idx+1);
            p.inverte(i);
        }
    }
}

class Pilha {

    private int topo;
    private int[] pilha;
    public final static int CAPACIDADE_DEFAULT = 10;

    public Pilha(){
        this(CAPACIDADE_DEFAULT);
    }

    public Pilha(int capacidade){
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public int size(){
        return this.topo+1;
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public boolean isFull(){
        return this.topo == this.pilha.length-1;
    }

    public int peek(){
        if(isEmpty()) throw new NoSuchElementException();
        return this.pilha[this.topo];
    }
    
    public int pop(){
        if(isEmpty()) throw new NoSuchElementException();
        return this.pilha[this.topo--];
    }

    public void push(int v){
        if(isFull()) throw new RuntimeException("Pilha cheia");
        this.pilha[++this.topo] = v;
    }

    public int getMax(int idx){
        if(idx < 0 || idx > this.topo+1) throw new IndexOutOfBoundsException();

        Pilha aux = new Pilha(this.pilha.length);
        int max = this.peek();
        int index = 0;
        for (int i = 0; i < idx; i++){
            int k = this.pop();
            if(k > max) {max = k; index = i;}
            aux.push(k);
        }
        while(!aux.isEmpty())
            this.push(aux.pop());
        return index;
    }

    public void inverte(int index){
        if(index < 0 || index > this.topo + 1) throw new IndexOutOfBoundsException();

        Pilha aux1 = new Pilha(index);
        Pilha aux2 = new Pilha(index);

        for(int i = 0; i < index; i++)
            aux1.push(pop());
        for(int i = 0; i < index; i++)
            aux2.push(aux1.pop());
        for(int i = 0; i < index; i++)
            push(aux2.pop());
    }
    
}
