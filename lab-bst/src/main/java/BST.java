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
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        return search(this.root, element);
    }

    private Node search(Node current, int v){
        if(current == null) return null;
        if(current.value == v) return current;
        if(current.value > v) return search(current.left, v);
        return search(current.right, v);
    }
    
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    private int height(Node current){
        if(current == null) return -1;
        return 1 + Max(height(current.left), height(current.right));
    }

    public boolean equals(BST outra) {
        return equals(this.root, outra.root);
    }

    private boolean equals(Node n1, Node n2){
        if(n1 == null && n2 == null) return true;

        if(n1 == null || n2 == null) return false;

        return n1.value == n2.value && equals(n1.right, n2.right) && equals(n1.left, n2.left);
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return contaFolhas(this.root);
    }

    private int contaFolhas(Node current){
        if(current == null) return 0;
        if(current.left == null && current.right == null) return 1;
        return contaFolhas(current.left) + contaFolhas(current.right);
    }   

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }

    public void remove(int v){
        Node toRemove = search(v);
        if(toRemove == null) return;

        if(toRemove.isLeaf()){   // caso 1
            if(toRemove == this.root) this.root = null;
            if(toRemove.value < toRemove.parent.value){
                toRemove.parent.left = null;
            } else {
                toRemove.parent.right = null;
            }
        } else if(toRemove.hasOnlyLeftChild()){
            
        }

    }

    public Node sucessor(Node n){
        if(n == null) return null;

        if(n.right != null) return min(n.right);
        else {
            Node aux = n.parent;

            while(aux != null && aux.value < n.value)
                aux = aux.parent;
        
            return aux;
        }
    }

    public Node min(){
        if(isEmpty()) return null;
        return min(this.root);
    }

    private Node min(Node current){
        if(current.left == null) return current;
        return min(current.left);
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
