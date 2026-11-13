import java.util.*;
import util2.Aluno;

public class TabelaHashEncadeamentoFechado {

    private ArrayList<Aluno>[] tabela;  
    private int size;
    private static final double fatorDeCarga = 0.75;   
    private static final int CAPACIDADE_DEFAULT_PRIMO = 43;

    public TabelaHashEncadeamentoFechado(){
        this(CAPACIDADE_DEFAULT_PRIMO);
    }

    public TabelaHashEncadeamentoFechado(int capacidade){
        this.tabela = new ArrayList[capacidade];
    }

    public int hash(int chave){
        return chave % this.tabela.length;
    }

    public int hashMultiplicacao(int chave){
        double a = 0.6180339887;
        return (int) (((chave * a) % 1) * this.tabela.length);
    }

    public Aluno get(int chave){
        int hash = hash(chave);
        ArrayList<Aluno> alunosTabela = this.tabela[hash];

        if(alunosTabela == null || alunosTabela.isEmpty()) return null;

        for(Aluno a : alunosTabela){
            if(a.getMatricula() == chave)
                return a;
        }
        return null;
    }

    public void put(int chave, Aluno valor){
        if((double) this.size/ this.tabela.length >= fatorDeCarga) resize();
        
        int hash = hash(chave);
        ArrayList<Aluno> alunosTabela = this.tabela[hash];

        if(alunosTabela == null){
            this.tabela[hash] = new ArrayList<>();
            this.tabela[hash].add(valor);
            this.size++;
        } else {

            for(int i = 0; i < alunosTabela.size(); i++){
                Aluno aux = alunosTabela.get(i);
                if(aux.getMatricula() == chave) {
                    alunosTabela.set(i, valor);
                    return;
                }
            }
            
            alunosTabela.add(valor);
            this.size++;
        }
    }

    public boolean containsKey(int chave){
        return this.get(chave) != null;
    }

    public boolean containsValue(Aluno a){
        return a.equals(this.get(a.getMatricula()));
    }

    public Aluno remove(int chave){
        int hash = hash(chave);
        ArrayList<Aluno> alunosTabela = this.tabela[hash];

        if(alunosTabela == null || !this.containsKey(chave)) return null;

        for(int i = 0; i < alunosTabela.size(); i++){
            Aluno a = alunosTabela.get(i);
            if(a.getMatricula() == chave){
                remove(i);
                return a;
            }
        }
        return null;
    }

    private void resize(){
        ArrayList<Aluno>[] antiga = this.tabela;
        this.tabela = new ArrayList[antiga.length*2];
        this.size = 0;
        
        for(int i = 0; i < antiga.length; i++){
            if(antiga[i] != null)
                for(Aluno aluno : antiga[i]){
                    int chave = aluno.getMatricula();
                    this.put(chave, aluno);
            }
        }
    }
}
