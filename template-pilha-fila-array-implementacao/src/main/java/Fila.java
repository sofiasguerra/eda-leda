public class Fila {

    private int[] fila;
    private int tail;
    private int head;
    private int capacidade;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
        return this.size() == capacidade;
    }

    public int size() {
        if(this.isEmpty()) return 0;
        return (this.tail - this.head + this.capacidade) % this.capacidade + 1;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if(this.isFull()){
            throw new RuntimeException("a fila está cheia.");
        } else {
            if(this.isEmpty()){ 
                this.head = 0;
                this.tail = 0;
            } else {
                this.tail = (this.tail + 1) % this.capacidade;
            }
            this.fila[this.tail] = valor;
        }
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(this.isEmpty()){
            throw new RuntimeException("a fila está vazia");
        } else {
            int v = this.fila[this.head];
            if (this.head == this.tail){
                this.head = -1;
                this.tail = -1;
            } else{
                this.head = (this.head + 1) % this.capacidade;
            }
            return v;
        }
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if(this.isEmpty()) throw new RuntimeException("a fila está vazia");
        else return this.fila[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if(this.isEmpty()) throw new RuntimeException("a fila está vazia");
        else return this.fila[this.tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        Fila aux = new Fila(this.capacidade);
        String out = "";
        while(!this.isEmpty()){
            int k = this.removeFirst();
            aux.addLast(k);
            if(this.isEmpty()) out += k;
            else out += k + ", ";
        }
        while(!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }
        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        Fila aux = new Fila(this.capacidade);
        int idx = -1;

        while(!this.isEmpty()){
            int i = aux.size();
            int k = this.removeFirst();
            aux.addLast(k);
            if(k == valor && idx == -1){
                idx = i;
            }
        }
        while(!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }
        return idx;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Fila aux = new Fila(this.capacidade);
        int idx = -1;

        while(!this.isEmpty()){
            int i = aux.size();
            int k = this.removeFirst();
            aux.addLast(k);
            if(k == valor) idx = i;
        }

        while(!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }

        return idx;
    }
    

}
