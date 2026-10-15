import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

public class Pilha {

    private int topo;
    private int[] stack;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.stack = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == this.stack.length-1;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull()) throw new RuntimeException("StackIsFull");
        this.stack[++this.topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty()) throw new NoSuchElementException("StackIsEmpty");
        return this.stack[this.topo--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    // peek
    public int top() {
        if(isEmpty()) throw new NoSuchElementException("StackIsEmpty"); 
        return this.stack[this.topo];
    }

    public int size() {
        return this.topo+1;
    }

    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        Pilha aux = new Pilha(this.size());
        String out = "";
        while(!this.isEmpty()){
            aux.push(this.pop());
        }
        while(!aux.isEmpty()){
            int k = aux.pop();
            this.push(k);
            if(aux.isEmpty()) out += k;
            else out += k + ", ";
        }

        return out;

    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha aux = new Pilha(this.size());
        int idx = -1;
        while(!this.isEmpty()){
            aux.push(this.pop());
        }
        while(!aux.isEmpty()){
            int k = aux.pop();
            this.push(k);
            if(k == valor) idx = this.size()-1;
        }

        return idx;
    }

    public int lastIndexOf(int valor){
        Pilha aux = new Pilha(this.size());
        int idx = -1;

        while(!this.isEmpty()){
            int indice = this.size()-1;
            int k = this.pop();
            if(k == valor) idx = indice;
            aux.push(k);
            break;
        }
        while(!aux.isEmpty()){
            this.push(aux.pop());
        }

        return idx;
    }

}
