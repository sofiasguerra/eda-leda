import java.util.*;

class TrocaVizinhosLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");
        int i = sc.nextInt();
        
        LinkedList lista = new LinkedList();
        for(String s : ent)
            lista.addLast(Integer.parseInt(s));

        troca(lista, i);
        String out = "";
        Node aux = lista.head;
        while(aux != null){
            out += aux.value + " ";
            aux = aux.next;
        }
        
        System.out.println(out.trim());
    }

    private static void troca(LinkedList lista, int i) {
        Node n1 = lista.getNode(i);
        Node n2 = lista.getNode(i + 1);

        Node a = n1.prev;
        Node b = n2.next;

        n2.prev = n1.prev;
        n1.next = n2.next;
        n1.prev = n2;
        n2.next = n1;

        if(a != null) a.next = n2;
        else lista.setHead(n2);
        if(b != null) b.prev = n1;
        else lista.setTail(n1);
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

   public Node getNode(int index) {
        Node aux = this.head;
        for (int i = 0; i < index; i++)
            aux = aux.next;
        return aux;
    }

    public void setHead(Node n){
        this.head = n;
    }

    public void setTail(Node n){
        this.tail = n;
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
