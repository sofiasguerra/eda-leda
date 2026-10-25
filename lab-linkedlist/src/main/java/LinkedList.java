import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
    }
   
    public boolean isEmpty() {
        return size == 0;
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
        if(isEmpty()) addFirst(valor);
        else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            this.size++;
        }
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();
        if(index == 0) addFirst(valor);
        else if(index == this.size) addLast(valor);
        else {
            Node newNode = new Node(valor);
            Node aux = this.head;
            for(int i = 0; i < index-1; i++)
                aux = aux.next;

            newNode.next = aux.next;
            aux.next.prev = newNode;
            aux.next = newNode;
            newNode.prev = aux;
            this.size++;
        }
    }

    public int getFirst() {
        return this.head.value;
    }

    public int getLast() {
        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index > this.size-1) throw new IndexOutOfBoundsException();
        if(index == 0) return getFirst();
        if(index == this.size-1) return getLast();
        Node aux = this.head;
        for(int i = 0; i < index; i++)
            aux = aux.next;
        return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        int v = this.head.value;
        if(this.head.next == null){ // verifica se so tem um elemento
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
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        int v = this.tail.value;
        if(this.head.next ==  null){ // verifica se so tem um elemento
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
        if(index < 0 || index > this.size-1) throw new IndexOutOfBoundsException();
        if(index == 0) return removeFirst();
        else if(index == this.size-1) return removeLast();
        else{
            Node aux = this.head;
            for(int i = 0; i < index; i++)
                aux = aux.next;
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            this.size--;
            return aux.value;
        }   
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        Node aux = this.head;
        for(int i = 0; i < size(); i++)
            if(aux.value == value) {
                remove(i);
                return true;
            }
            else aux = aux.next;
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = this.head;
        for(int i = 0; i < size(); i++){
            if(aux.value == value) return i;
            aux = aux.next;
        }
        return -1;
    }

    public boolean contain(int v) {
        return indexOf(v) != -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = this.tail;
        for(int i = size()-1; i >= 0; i--){
            if(aux.value == valor) return i;
            aux = aux.prev;
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
        if(index < 0 || index > size()-1) throw new IndexOutOfBoundsException();
        if(index == 0) return; // se for o primeiro
        else if(index == size()-1){ // se for o último
            Node aux = this.tail;
            aux.prev.next = null;
            this.tail = aux.prev;
            aux.next = this.head;
            this.head.prev = aux;
            this.head = aux;
        } else {
            Node aux = this.head;
            for(int i = 0; i < index; i++)
                aux = aux.next;
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            this.head.prev = aux;
            aux.next = this.head;
            aux.prev = null;
            this.head = aux;
        }
    }

    // dado que a lista já está em ordem crescente, insere v no lugar certo
    // para que a lista continue ordenada depois da inserção. se já houver
    // elementos iguais a v na lista, insira v depois deles.
    public void insereOrdenado(int v) {
        Node aux = this.head;
        int idx = 0;
        while(aux != null && v >= aux.value){
            aux = aux.next;
            idx++;
        }
        add(idx, v);
        
    }

    // troca n1 e n2 de posição na lista. não é permitido trocar os valores
    // guardados nos nós, só manipular as referências (prev/next). esse
    // algoritmo deve ser O(1), já que os nós a trocar são recebidos como
    // parâmetro (ou seja, não é permitido percorrer a lista para achá-los).
    public void swap(Node n1, Node n2) {
        if(n1 == n2) return;

        // se n1 e n2 não são vizinhos
        if(n1.next != n2 && n2.next != n1){
            // se n1 nao for o ultimo
            if(n1.next != null) n1.next.prev = n2;
            // se n1 nao for o primeiro
            if(n1.prev != null) n1.prev.next = n2;
            // se n2 nao for o ultimo
            if(n2.next != null) n2.next.prev = n1;
            // se n2 nao for o ultimo
            if(n2.prev != null) n2.prev.next = n1;
            // linkando as referencias dos nós
            Node auxN1Next = n1.next;
            Node auxN1Prev = n1.prev;
            n1.next = n2.next;
            n2.next = auxN1Next;
            n1.prev = n2.prev;
            n2.prev = auxN1Prev;
        } else{
            // garante que n1 vem antes de n2
            if(n2.next == n1) {
                Node aux = n1; 
                n1 = n2; 
                n2 = aux;}

            n1.next = n2.next;
            if(n1.prev != null) n1.prev.next = n2;
            if(n2.next != null) n2.next.prev = n1;
            n2.prev = n1.prev;
            n1.prev = n2;
            n2.next = n1;
        }

        // atualiza head e tail
        if(this.head == n1) this.head = n2;
        else if (this.head == n2) this.head = n1;
        if(this.tail == n1) this.tail = n2;
        else if(this.tail == n2) this.tail = n1;
    }

    // inverte a lista: tail passa a ser head, o elemento anterior ao tail
    // passa a ser o segundo da lista e assim por diante, até chegar em
    // head, que passa a ser o último elemento (tail). não é permitido usar
    // nenhuma estrutura auxiliar.
    public void inverte() {
        Node aux = this.head;
        while(aux != null){
            Node t = aux.next;
            aux.next = aux.prev;
            aux.prev = t;
            aux = t;
        }
        Node auxT = this.head;
        this.head = this.tail;
        this.tail = auxT;
    }

    // retorna uma string representando a lista no sentido inverso, do tail
    // para o head, usando os ponteiros prev (e não next). serve para provar
    // que a implementação é de fato duplamente encadeada.
    public String toStringReverso() {
        String out = "";
        Node aux = this.tail;
        for(int i = 0; i < size(); i++){
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
        return -1;
    }

    // retorna um array com os elementos da lista, na mesma ordem em que
    // aparecem (do head para o tail).
    public int[] toArray() {
        return null;
    }

    // retorna o valor do elemento do meio da lista, usando dois ponteiros
    // (um avança uma posição por vez, o outro avança duas) em uma única
    // passada pela lista. se a lista tiver tamanho par, retorne o segundo
    // dos dois elementos centrais.
    public int meio() {
        return -1;
    }

    // retorna true se a lista for um palíndromo, isto é, se lê-la do head
    // para o tail dá a mesma sequência de valores que lê-la do tail para o
    // head. aproveite o fato de a lista ser duplamente encadeada para
    // resolver isso em O(n) tempo e O(1) espaço extra, sem array ou pilha
    // auxiliar.
    public boolean isPalindromo() {
        return false;
    }

    // retorna o nó na posição index. existe só para permitir que os testes
    // de swap peguem referências reais de nós da lista (fora da classe não
    // há outro jeito de obter um Node).
    public Node getNode(int index) {
        if(index < 0 || index > size()-1) throw new IndexOutOfBoundsException();
       Node aux = this.head;
       for(int i = 0; i < index; i++){
            aux = aux.next;
       }
       return aux;
    }

    // remove a última ocorrência do elemento cujo valor foi passado como
    // parâmetro (diferente de removeByValue, que remove a primeira).
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeLastOccurrence(int valor) {
        return false;
    }

    // remove da lista, em efeito colateral (sem criar uma lista nova), todo
    // elemento cujo valor seja menor ou igual a valor. ao final, a lista só
    // deve ter elementos estritamente maiores que valor.
    public void filter(int valor) {
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}