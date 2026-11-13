import util2.Aluno;

public class TabelaHashProbingLinear {

    private Aluno[] tabela;
    private int size;
    private static final double fatorDeCarga = 0.75;
    private static final int CAPACIDADE_DEFAULT_PRIMO = 13;
    private static final Aluno APAGADO = new Aluno(Integer.MIN_VALUE, "APAGADO");

    public TabelaHashProbingLinear(){
        this(CAPACIDADE_DEFAULT_PRIMO);
    }

    public TabelaHashProbingLinear(int cap){
        this.tabela = new Aluno[cap];
    }

    public int hash(int key){
        return key % this.tabela.length;
    }

    public void put(int k, Aluno a){
        if( (double) this.size/this.tabela.length >= fatorDeCarga) resize();

        int hash;
        int sondagem = 0;
        boolean existe = containsKey(k);
        while(sondagem < this.tabela.length){
            hash = (hash(k) + sondagem) % this.tabela.length;
            Aluno aux = this.tabela[hash];
            if(aux == null || aux == APAGADO&& !existe){
                this.tabela[hash] = a;
                this.size++;
                return;
            } else if(aux.getMatricula() == k){
                this.tabela[hash] = a;
                return;
            }
            sondagem++;
        }
    }

    public Aluno get(int k){
        int hash;
        int sondagem = 0;
        while(sondagem < this.tabela.length){
            hash = (hash(k) + sondagem) % this.tabela.length;
            Aluno aux = this.tabela[hash];
            if(aux == null) return null;
            if(aux.getMatricula() == k) return aux;
            sondagem++;
        }
        return null;
    }

    public Aluno remove(int k){
        int hash;
        int sondagem = 0;
        while(sondagem < this.tabela.length){
            hash = (hash(k) + sondagem) % this.tabela.length;
            Aluno aux = this.tabela[hash];
            if(aux == null) return null;
            if(aux.getMatricula() == k){
                this.tabela[hash] = APAGADO;
                this.size--;
                return aux;
            } 
            sondagem++;
        }
        return null;
    }

    private void resize(){
        Aluno[] antiga = this.tabela;
        this.tabela = new Aluno[antiga.length * 2];
        this.size = 0;
        
        for(Aluno a : antiga){
            if(a != null && !a.equals(APAGADO)) 
                this.put(a.getMatricula(), a);
        }
    }

    private boolean containsKey(int key){
        return this.get(key) != null;
    }
}
