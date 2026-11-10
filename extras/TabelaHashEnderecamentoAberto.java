import util2.Aluno;

public class TabelaHashEnderecamentoAberto {
    
    private Aluno[] tabela;
    private int size;
    private static final int CAPACIDADE_DEFAULT_PRIMO = 7;
    private static final Aluno APAGADO = new Aluno(Integer.MIN_VALUE, "APAGADO");
    private static final double fatorDeCarga = 0.75;
    private static final int[] primos = new int[]{17, 37, 79, 163, 331, 673, 1361, 2729, 5471};
    
    public TabelaHashEnderecamentoAberto(){
        this(CAPACIDADE_DEFAULT_PRIMO);
    }

    public TabelaHashEnderecamentoAberto(int capacidade){
        this.tabela = new Aluno[capacidade];
    }

    public int hash(int chave){
        return chave % this.tabela.length;
    }

    public int hashMultiplicacao(int chave){
        double a = 0.6180339887;
        return (int) (((chave*a) % 1) * this.tabela.length);
    }

    public Aluno get(int chave){
        int hash;
        int prob = 0;
        while(prob < this.tabela.length){

            hash = (hash(chave) + prob) % this.tabela.length;
            Aluno temp = this.tabela[hash];
            
            if(temp == null) return null;
            if(!temp.equals(APAGADO) && temp.getMatricula() == chave) return temp;
            prob++;
        }
        return null;
    }

    public Aluno remove(int chave){
        int hash;
        int prob = 0;
        while(prob < this.tabela.length){
            
            hash = (hash(chave) + prob) % this.tabela.length;
            Aluno temp = this.tabela[hash];

            if(temp == null) return null;
            
            if(temp.getMatricula() == chave){
                this.tabela[hash] = APAGADO;
                this.size--;
                return temp;
            }
            prob++;
        }
        return null;
    }

    public void put(int chave, Aluno valor){
        if((double) this.size/this.tabela.length >= fatorDeCarga) resize();
    
        int hash;
        int prob = 0;
        while(prob < this.tabela.length){

            hash = (hash(chave) + prob) % this.tabela.length;
            Aluno aux = this.tabela[hash];

            if(aux == null || (aux.equals(APAGADO) && !containsKey(chave))){
                this.tabela[hash] = valor;
                this.size++;
                return;
            }
            if(aux.getMatricula() == chave){
                this.tabela[hash] = valor;
                return;
            }

            prob++;
        }
    }

    private void resize(){
        Aluno[] antiga = this.tabela;
        
        int novoTam = antiga.length * 2 + 1; // fallback se os primos acabarem
        for(int p : primos){
            if(p > antiga.length){
                novoTam = p;
                break;
            }
        }

        this.tabela = new Aluno[novoTam];
        this.size = 0;
        for(Aluno a : antiga){
            if(a != null && !a.equals(APAGADO)) this.put(a.getMatricula(), a);
        }
    }

    public boolean containsKey(int chave){
        return this.get(chave) != null;
    }
}
