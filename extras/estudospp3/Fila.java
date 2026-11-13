
import java.util.NoSuchElementException;

// fila circular
public class Fila {

    // TODO adicionar atributos e implementar o restante
    private String[] fila;
    private int head;
    private int tail;
    private int size;

    public Fila(int capacidade) {
        this.fila = new String[capacidade];
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.fila.length;
    }

    public void addLast(String v) {
        if(isEmpty()){
            this.head = 0;
            this.tail = 0;
        } else if(isFull()){
            this.tail = this.head;
            this.head = (this.head + 1) % this.fila.length;
        } else {
            this.tail = (this.tail + 1) % this.fila.length;
        }
        this.fila[this.tail] = v;
        if(!isFull()) this.size++;
    }

    public String removeFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        String removido = this.fila[this.head];

        if(this.head == this.tail){
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.fila.length;
        }
        this.size--;
        return removido;
    }

    // apenas retorna o primeiro da fila, não o remove.
    public String getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.fila[this.head];
    }

    public int size(){
        return this.size;
    }
}