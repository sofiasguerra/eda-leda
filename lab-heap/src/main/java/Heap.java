import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap {
    
    private int[] heap;
    private int tail;
    
    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }
    
    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int i) {
        return (2 * i) + 1;
    }

    public int right(int i) {
        return 2 * (i + 1);
    }

    public int parent(int i) {
        return (int) (i-1) / 2;
    }

    public void add(int n) {
    	if(this.tail >= this.heap.length - 1) resize();

        this.tail++;
        this.heap[this.tail] = n;
        
        int i = this.tail;
        while(i > 0 && this.heap[parent(i)] < this.heap[i])
            swap(parent(i), i);
            i = parent(i);
    }

    private void buildHeap() {
        for(int i = parent(this.tail); i >= 0; i --){
            heapify(i);
        }
    }
    
    public int remove() {
       if(isEmpty()) throw new NoSuchElementException();

       int remov = this.heap[0];
       this.heap[0] = this.heap[this.tail];
       this.tail--;
       heapify(0);
       return remov;
    }
        
    private void heapify(int index) {
        if(isLeaf(index) || !isValidIndex(index)) return;

        int idxDoMaior = max_index(index, left(index), right(index));

        if(idxDoMaior != index){
            swap(index, idxDoMaior);
            heapify(idxDoMaior);
        }
    } 
    
    private int max_index(int index, int left, int right) {
       if(this.heap[index] > this.heap[left]){
            if(isValidIndex(right) && this.heap[right] > this.heap[index]) return right;
            return index;
        } else {
            if(isValidIndex(right) && this.heap[left] < this.heap[right]) return right;
            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail; 
    } 
    
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void resize() {
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++)
            novoHeap[i] = this.heap[i];
        
        this.heap = novoHeap;
    }
    
    public int size() {
        return this.tail + 1;
    }
    
    public String toString() {
        return Arrays.toString(this.heap);
    }

}