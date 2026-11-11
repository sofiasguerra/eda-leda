import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class FIFOCache {

    private String[] cache;
    private int size;
    private int head;
    private int tail;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
        this.cache = new String[capacidade];
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.cache.length;
    }

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
        if(isEmpty()){
            this.head = 0;
            this.tail = 0;
        } else if (isFull()){
            this.tail = this.head;
            this.head = (this.head + 1) % this.cache.length;
        } else {
            this.tail = (this.tail +1 ) % this.cache.length;
        }
        this.cache[this.tail] = chave;
        if(!isFull()) this.size++;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        if(isEmpty()) throw new RuntimeException("Cache vazio");
        String removido = this.cache[this.head];

        if(this.head == this.tail){
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.cache.length;
        }
        this.size--;
        return removido;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public String getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.cache[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.cache[this.tail];
    }

    // deve retornar uma string representando a fila. 
    @Override 
    public String toString() {
        StringJoiner out = new StringJoiner(", ");
        int count = 0;
        int i = this.head;
        while(count < this.size){
            out.add(this.cache[i]);
            i = (i + 1) % this.cache.length;
            count++;
        }
        return out.toString();
    }
    
    public int size() {
        return this.size;
    }
}
