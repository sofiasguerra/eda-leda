public class Pilha {

    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo + 1 == this.pilha.length;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull()) throw new RuntimeException("Pilha cheia");

        this.pilha[++this.topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty()) throw new RuntimeException("Pilha vazia");

        int a = this.pilha[this.topo];
        this.topo--;
        return a;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if(isEmpty()) throw new RuntimeException("Pilha vazia");
        return this.pilha[this.topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    @Override 
    public String toString() {
        String out = "";
        Pilha aux = new Pilha(this.pilha.length);
        while(!this.isEmpty())
            aux.push(this.pop());
        while(!aux.isEmpty()){
            int k = aux.pop();
            this.push(k);
            if(aux.isEmpty()) out += k;
            else out += k + ", ";
        }
        return out;  
    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha aux = new Pilha(this.pilha.length);
        int idx = -1;
        int i = this.topo;
        while(!this.isEmpty()){
           int k = this.pop();
           aux.push(k);
           if(k == valor) idx = i;
           i--;
        }
        while(!aux.isEmpty())
            this.push(aux.pop());
    
        return idx;
    }

    // Deve retornar o índice da última ocorrência do elemento passado como parâmetro.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int lastIndexOf(int valor) {
        Pilha aux = new Pilha(this.pilha.length);
        int i = this.topo;
        int idx = -1;
        while(!this.isEmpty()){
            int k = this.pop();
            aux.push(k);
            if(k == valor) {
                idx = i;
                break;
            }
            i--;
        }
        while(!aux.isEmpty())
            this.push(aux.pop());
        return idx;
    }

    public int size() {
        return this.topo + 1;
    }

}
