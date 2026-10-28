import java.util.*;

public class LinkedListRecursivo {

    private Node head;
    private Node tail;
    //private int size;

    public LinkedListRecursivo(){
    }

    public void addLast(int v){
        Node newNode = new Node(v);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        return size(this.head);
    }

    private int size(Node current){
        if(current == null) return 0;
        return 1 + size(current.next);
    }

    public int sum(){
        return sum(this.head);
    }

    private int sum(Node current){
        if(current == null) return 0;
        return current.value + sum(current.next);
    }

    public boolean contains(int v){
        return contains(this.head, v);
    }

    private boolean contains(Node current, int v){
        if(current == null) return false;
        if(current.value == v) return true;
        return contains(current.next, v);
    }

    public int indexOf(int v){
        return indexOf(this.head, v, 0);
    }

    private int indexOf(Node current, int v, int idx){
        if(current == null) return -1;
        if(current.value == v) return idx;
        return indexOf(current.next, v, idx+1);
    }

    public int max(){
        if(isEmpty()) throw new NoSuchElementException();
        return max(this.head, this.head.value);
    }

    private int max(Node current, int v){
        if(current == null) return v;
        if(current.value > v) v = current.value;
        return max(current.next, v);
    }

    public int min(){
        if(isEmpty()) throw new NoSuchElementException();
        return min(this.head, this.head.value);
    }

    private int min(Node current, int v){
        if(current == null) return v;
        if(current.value < v) v = current.value;
        return min(current.next, v);
    }

    @Override 
    public String toString(){
        if(isEmpty()) return "";
        return toString(this.head);
    }

    private String toString(Node current){
        if(current.next == null) return ""+ current.value;
        return current.value + ", " + toString(current.next);
    }

    public int count(int v){
        return count(this.head, v);
    }

    private int count(Node current, int v){
        if(current == null) return 0;
        if(current.value == v) return 1 + count(current.next, v);
        return count(current.next, v);
    }

    public Node get(int index){
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return get(this.head, index);
    }

    private Node get(Node current, int index){
        if(current == null) return null;
        if(index == 0) return current;
        return get(current.next, index-1);
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
