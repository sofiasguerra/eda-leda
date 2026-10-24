
public class ArrayList {

    private int[] lista;
    private int tamanho;
   
    public ArrayList(int capacidadeInicial) {
        this.lista = new int[capacidadeInicial];
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }
    
    private void shiftPraDireita(int posi){
        for(int i = this.tamanho; i > posi; i--)
            this.lista[i] = this.lista[i-1];
    }
    
    public void addFirst(int valor) {
        assegureCapacidade(this.tamanho+1);
        if(isEmpty()) this.lista[0] = valor;
        else {
            shiftPraDireita(0);
            this.lista[0] = valor;
        }
        this.tamanho++;
    }

    public void addLast(int valor) {
        assegureCapacidade(tamanho+1);
        this.lista[tamanho++] = valor;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if(index < 0 || index > this.tamanho) throw new IndexOutOfBoundsException();
        if(index == 0) addFirst(valor);
        else if(index == this.tamanho) addLast(valor);
        else{
            assegureCapacidade(this.tamanho+1);
            shiftPraDireita(index);
            this.lista[index] = valor;
            this.tamanho++;
        }
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
       int[] nLista = new int[novaCapacidade];
       for(int i = 0; i < this.tamanho; i++)
            nLista[i] = this.lista[i];
       this.lista = nLista;
    }

    public void assegureCapacidade(int capacidadePretendida) {
       if(capacidadePretendida > this.lista.length){
            resize(Math.max(capacidadePretendida, this.tamanho*2));
       }
    }

    public int getFirst() {
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        return this.lista[0];
    }

    public int getLast() {
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        return this.lista[this.tamanho-1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index > this.tamanho-1) throw new IndexOutOfBoundsException();
        return this.lista[index];
    }

    private void shiftPraEsquerda(int idx){
        for(int i = idx; i < this.tamanho-1; i++)
            this.lista[i] = this.lista[i+1];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        else{
            int v = this.lista[0];
            shiftPraEsquerda(0);
            this.tamanho--;
            return v;
        }
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        if(isEmpty()) throw new RuntimeException("Lista vazia");
        else{
            this.tamanho--;
        }
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if(index < 0 || index > this.tamanho-1) throw new IndexOutOfBoundsException();
        else{
            shiftPraEsquerda(index);
            this.tamanho--;
        }
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        for(int i = 0; i < this.tamanho; i++)
            if(this.lista[i] == value) {
                remove(i);
                break;
            }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for(int i = 0; i < this.tamanho; i++){
            if(this.lista[i] == value) return i;
        }
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int idx = -1;
        for(int i = 0; i < this.tamanho; i++){
            if(this.lista[i] == valor) idx = i;
        }
        return idx;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        String out = "";
        for(int i = 0; i < this.tamanho; i++){
            if((i + 1) > this.tamanho-1) out += this.lista[i];
            else out += this.lista[i] + ", ";
        }
        return out;
    }
    
    public int size() {
        return this.tamanho;
    }
}
