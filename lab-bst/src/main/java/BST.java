import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        Node newNode = new Node(element);

        if(this.root == null){
            this.root = newNode;
        } else {
            Node aux = this.root;
            while (true) { 
                if(element > aux.value){
                    if(aux.right == null){
                        aux.right = newNode;
                        break;
                    } 
                    aux = aux.right;
                } else {
                    if(aux.left == null){
                        aux.left = newNode;
                        break;
                    }
                    aux = aux.left;
                }   
            }
            newNode.parent = aux;
        }
        this.size++;
    }

    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        if(isEmpty()) return null;

        Node aux = this.root;
        while(aux != null && aux.value != element){
            if(aux.value > element) aux = aux.left;
            else aux = aux.right;
        }
        return aux;
    }
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    private int height(Node current){
        if(current == null) return -1;
        return 1 + Math.max(height(current.left), height(current.right));
    }

    public boolean equals(BST outra) {
        return equals(this.root, outra.root);
    }

    private boolean equals(Node n1, Node n2){
       if(n1 == null && n2 == null) return true;

       if(n1 == null || n2 == null) return false;

       return n1.value == n2.value && equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return contaFolhas(this.root);
    }

    private int contaFolhas(Node no){
        if(no == null) return 0;
        if(no.isLeaf()) return 1;
        return contaFolhas(no.left) + contaFolhas(no.right);
    }
      
    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }

    public void remove(int v){
        if(isEmpty()) throw new RuntimeException("Vazia");

        Node remov = search(v);
        if(remov == null) return;
        
        if(remov.isLeaf()) {                  //CASO 1: É FOLHA
            if(remov == this.root) this.root = null;
            else {
                if(remov.parent.value > remov.value) remov.parent.left = null;
                else remov.parent.right = null;
            }
            this.size--;
        } else if(remov.hasOnlyLeftChild()){   //CASO 2: TEM UM FILHO
            if(remov == this.root) {
                this.root = remov.left;
                this.root.parent = null;
            } else {
                if(remov.parent.value > remov.value){
                    remov.parent.left = remov.left;
                } else {
                    remov.parent.right = remov.left;
                }
                remov.left.parent = remov.parent;
            }
            this.size--;
        } else if(remov.hasOnlyRightChild()){   //CASO 2: TEM UM FILHO
            if(remov == this.root){
                this.root = remov.right;
                this.root.parent = null;
            } else {
                if(remov.parent.value > remov.value){
                    remov.parent.left = remov.right;
                } else {
                    remov.parent.right = remov.right;
                }
                remov.right.parent = remov.parent;
            }
            this.size--;
        } else {                                //CASO 3: TEM DOIS FILHOS
            Node sucessor = sucessor(remov);
            int aux = sucessor.value;
            remove(aux);
            remov.value = aux;
        }

    }

    public Node sucessor(Node no){
        if(no == null) return null;

        if(no.right != null)
            return min(no.right);
        else {
            Node aux = no.parent;
            while(aux != null && aux.value < no.value)
                aux = aux.parent;
            return aux;
        }
    }

    public Node min(Node no){
        if(no == null) return null;

        Node aux = no;
        while(aux.left != null)
            aux = aux.left;
        return aux;
    }

    public Node max(Node no){
       if(no == null) return null;

        Node aux = no;
        while(aux.right != null)
            aux = aux.right;
        return aux;
    }
}

class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    public boolean hasOnlyLeftChild(){
        return this.left != null && this.right == null;
    }

    public boolean hasOnlyRightChild(){
        return this.left == null && this.right != null;
    }

    public boolean hasTwoChilds(){
        return this.left != null && this.right != null;
    }
    
}
