import java.util.*;

public class LinkedList2 {

    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList2() {
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

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();

        if(index == 0) addFirst(valor);
        else if(index == this.size) addLast(valor);
        else {
            Node newNode = new Node(valor);
            Node aux = this.head;
            for(int i = 0; i < index - 1; i++)
                aux = aux.next;

            newNode.prev = aux;
            newNode.next = aux.next;
            aux.next.prev = newNode;
            aux.next = newNode;
            this.size++;
        }
    }

    public int getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.head.value;
    }

    public int getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        Node aux = this.head;
        for(int i = 0; i < index; i++)
            aux = aux.next;
        return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        int v = this.head.value;

        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else {
            this.head.next.prev = null;
            this.head = this.head.next;
        }
        this.size--;
        return v;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        int v = this.tail.value;

        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else {
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        }
        this.size--;
        return v;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        if(index == 0) return removeFirst();
        else if(index == this.size-1) return removeLast();
        Node aux = this.head;
        for(int i = 0; i < index; i++)
            aux = aux.next;

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        this.size--;
        return aux.value;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        Node aux = this.head;
        for (int i = 0; i < this.size; i++){
            if(aux.value == value){
                remove(i);
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        int i = 0;
        Node aux = this.head;
        while(aux != null){
            if(aux.value == value) return i;
            else {
                aux = aux.next;
                i++;
            }
        }
        return -1;
    }

    public boolean contain(int v) {
        return indexOf(v) != -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int idx = this.size-1;
        Node aux = this.tail;
        while(aux != null){
            if(aux.value == valor) return idx;
            else{
                idx--;
                aux = aux.prev;
            }
        }
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    @Override 
    public String toString() {
        String out = "";
        Node aux = this.head;
        while(aux != null){
            if(aux.next == null) out += aux.value;
            else out += aux.value + ", ";
            aux = aux.next;
        }
        return out;
    }
    
    public int size() {
        return this.size;
    }

    // move o elemento que está na posição index para a cabeça da lista.
    // a busca pelo elemento é O(n), mas a movimentação em si deve ser O(1),
    // ou seja, feita só manipulando referências.
    public void moveToHead(int index) {
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        if(index == 0) return; // caso o el ja seja o head
        Node aux = this.head;
        for(int i = 0; i < index; i++)
            aux = aux.next;
        if(aux == this.tail){   // caso o el seja o último
            aux.prev.next = null;
            this.tail = aux.prev;
        } else{
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
        }
        aux.prev = null;
        aux.next = this.head;
        this.head.prev = aux;
        this.head = aux;
    }

    // dado que a lista já está em ordem crescente, insere v no lugar certo
    // para que a lista continue ordenada depois da inserção. se já houver
    // elementos iguais a v na lista, insira v depois deles.
    public void insereOrdenado(int v) {
        int i = 0;
        Node aux = this.head;
        while(aux != null && v >= aux.value){
            aux = aux.next;
            i++;
        }
        add(i, v);
    }

    // troca n1 e n2 de posição na lista. não é permitido trocar os valores
    // guardados nos nós, só manipular as referências (prev/next). esse
    // algoritmo deve ser O(1), já que os nós a trocar são recebidos como
    // parâmetro (ou seja, não é permitido percorrer a lista para achá-los).
    public void swap(Node n1, Node n2) {
        // se sao iguais
        if(n1 == n2) return;

        // se sao ajdacentes
        if(n1.next == n2 || n2.next == n1){
            if(n2.next == n1) {Node aux = n2; n2 = n1; n1 = aux;}
            
            Node x = n1.prev;
            Node y = n2.next;

            n2.prev = n1.prev;
            n1.next = n2.next;
            n1.prev = n2;
            n2.next = n1;

            if (x != null) x.next = n2;
            else this.head = n2;
            if (y != null) y.prev = n1;
            else this.tail = n1;
            
        } else {
            Node a = n1.next;
            Node b = n1.prev;
            Node c = n2.next;
            Node d = n2.prev;
            
            n1.next = c;
            n1.prev = d;
            n2.next = a;
            n2.prev = b;   

            if (a != null) a.prev = n2;
            else this.tail = n2;
            if (b != null) b.next = n2;
            else this.head = n2;
            if (c != null) c.prev = n1;
            else this.tail = n1;
            if (d != null) d.next = n1;
            else this.head = n1;
        }
    }

    // inverte a lista: tail passa a ser head, o elemento anterior ao tail
    // passa a ser o segundo da lista e assim por diante, até chegar em
    // head, que passa a ser o último elemento (tail). não é permitido usar
    // nenhuma estrutura auxiliar.
    public void inverte() {
        Node aux = this.head;
        // como a lista é duplamente encadeada, basta inverter os apontadores, oq era next agr é prev e vice versa
        while (aux != null){ 
            Node prov = aux.next;
            aux.next = aux.prev;
            aux.prev = prov;
            aux = prov;
        }
        // troca a referencia para o head e o tail
        Node t = this.tail;
        this.tail = this.head;
        this.head = t;  
    }

    // retorna uma string representando a lista no sentido inverso, do tail
    // para o head, usando os ponteiros prev (e não next). serve para provar
    // que a implementação é de fato duplamente encadeada.
    public String toStringReverso() {
        String out = "";
        Node aux = this.tail;
        for(int i = 0; i < this.size; i++){
            if(aux.prev == null) out += aux.value;
            else out += aux.value + ", ";
            aux = aux.prev;
        }
        return out;
    }

    // remove todas as ocorrências de valor na lista (diferente de
    // removeByValue, que remove só a primeira ocorrência). retorna quantas
    // remoções foram feitas.
    public int removeAll(int valor) {
        int qt = 0;
        while(contain(valor)){
            removeByValue(valor);
            qt++;
        }
        return qt;
    }

    public int removeAll2(int valor) {
        int qt = 0;
        Node aux = this.head;
        for(int i = 0; i < this.size; i++){
            if(aux.value == valor) remove(i); qt++;
            aux = aux.next;
        }
        return qt;
    }

    // retorna um array com os elementos da lista, na mesma ordem em que
    // aparecem (do head para o tail).
    public int[] toArray() {
        int[] out = new int[this.size];
        Node aux = this.head;
        for(int i = 0; i < this.size; i++){
            out[i] = aux.value;
            aux = aux.next;
        }
        return out;
    }

    // retorna o valor do elemento do meio da lista, usando dois ponteiros
    // (um avança uma posição por vez, o outro avança duas) em uma única
    // passada pela lista. se a lista tiver tamanho par, retorne o segundo
    // dos dois elementos centrais.
    public int meio() {
        if(isEmpty()) return -1;
        Node p1 = this.head;
        Node p2 = this.head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1.value;
    }

    // retorna true se a lista for um palíndromo, isto é, se lê-la do head
    // para o tail dá a mesma sequência de valores que lê-la do tail para o
    // head. aproveite o fato de a lista ser duplamente encadeada para
    // resolver isso em O(n) tempo e O(1) sem espaço extra, sem array ou pilha auxiliar.
    public boolean isPalindromo() {
        Node ph = this.head;
        Node pt = this.tail;
        while(pt != ph){
            if(pt.value != ph.value) return false;
            pt = pt.prev;
            ph = ph.next;
        }
        return true;
    }

    // retorna o nó na posição index. existe só para permitir que os testes
    // de swap peguem referências reais de nós da lista (fora da classe não
    // há outro jeito de obter um Node).
    public Node getNode(int index) {
        Node aux = this.head;
        for (int i = 0; i < index; i++)
            aux = aux.next;
        return aux;
    }

    // remove a última ocorrência do elemento cujo valor foi passado como
    // parâmetro (diferente de removeByValue, que remove a primeira).
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeLastOccurrence(int valor) {
        Node aux = this.tail;
        int idx = this.size-1;
        while(aux != null){
            if(aux.value == valor){
                remove(idx);
                return true;
            }
            idx--;
            aux = aux.prev;
        }
        return false;
    }

    // remove da lista, em efeito colateral (sem criar uma lista nova), todo
    // elemento cujo value seja menor ou igual ao valor. ao final, a lista só
    // deve ter elementos estritamente maiores que valor.
    public void filter(int valor) {
        Node aux = this.tail;
        int i = this.size-1;
        while(aux != null){
            if(aux.value <= valor) remove(i);
            i--;
            aux = aux.prev; 
        }
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

