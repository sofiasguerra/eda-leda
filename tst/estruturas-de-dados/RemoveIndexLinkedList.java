import java.util.*;

class RemoveIndexLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int i = sc.nextInt();

        LinkedList l = new LinkedList();
        for(String s : ent)
            l.addLast(Integer.parseInt(s));
    
        l.remove(i);
        System.out.println(l.toString());
    
    }
}

class LinkedList {

    public Node head;
    private Node tail;
    private int size;
    
    public LinkedList() {
        // nem preciso de construtor pq o default de java me dá o que eu quero
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(int valor) {
        Node newNode = new Node(valor);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public int removeFirst(){
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        
        int v = this.head.value;
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else{
            this.head.next.prev = null;
            this.head = this.head.next;
        }
        this.size--;
        return v;
    }

    public int removeLast(){
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        
        int v = this.tail.value;
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else{
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        }
        this.size--;
        return v;
    }

    public int remove(int idx){
        if(idx < 0 || idx >= this.size) throw new IndexOutOfBoundsException();
        if(idx == 0) return removeFirst();
        if(idx == this.size-1) return removeLast();
        else{
            Node aux = this.head;
            for(int i = 0; i < idx; i++)
                aux = aux.next;

            aux.next.prev = aux.prev;
            aux.prev.next = aux.next;
            this.size--;
            return aux.value;
        }
    }

    @Override
    public String toString(){
        String out = "";
        Node aux = this.head;
        for(int i = 0; i < this.size; i++){
            out += aux.value + " ";
            aux = aux.next;
        }
        return out.trim();
    }
}

class Node{

    int value;
    Node next;
    Node prev;

    public Node(int v){
        this.value = v;
    }
}
