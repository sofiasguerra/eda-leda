import java.util.NoSuchElementException;

public class Fila {

    private int[] fila;
    private int head;
    private int tail;
    private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.size == this.fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if(isFull()) throw new RuntimeException("Fila cheia");
        if(isEmpty()){
            this.head = 0;
            this.tail = 0;
        }
        else {
            this.tail = (this.tail+1) % this.fila.length;
        }
        this.fila[this.tail] = valor;
        this.size++;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new RuntimeException("Fila vazia");
        int v = this.head;
        if(this.head == this.tail){
            this.head = -1;
            this.tail = -1;
        }
        else {
            this.head = (this.head+1) % this.fila.length;
        }
        this.size--;
        return v;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.fila[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.fila[this.tail];
    }

    // deve retornar uma string representando a fila. 
    @Override 
    public String toString() {
        String out = "";
        int i = 0;
        while(i < this.size){
            int idx = (this.head+i) % this.fila.length;
            if(i+1 == this.size) out += this.fila[idx];
            else out += this.fila[idx] + ", ";
            i++;
        }
        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        for(int i = 0; i < this.size; i++){
            int posi = (this.head+i) % this.fila.length;
            if(this.fila[posi] == valor) return i;
        }
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int idx = -1;
        for(int i = 0; i < this.size; i++){
            int posi = (this.head+i) % this.fila.length;
            if(this.fila[posi] == valor) idx = i;
        }
        return idx;
    }
    
    public int size() {
        return this.size;
    }
}
