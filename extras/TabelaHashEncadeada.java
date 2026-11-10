import java.util.ArrayList;
import java.util.Iterator;

import util2.Aluno;

/**
 * Esta classe representa a implementação de uma Tabela Hash que usa endereçamento fechado (encadeamento)
 * para resolver colisões.
 * 
 * A implementação abaixo apenas lida com objetos do tipo aluno. Essa foi uma decisão para fins didáticos. 
 * Naturalmente, por ser uma estrutura de propósito geral, uma tabela hash deve ser capaz de manipular objetos
 * de qualquer tipo.
 *
 * Esta é uma versão simplificada para fins didáticos. Não lidamos com resize e rehash aqui. Isso é assunto de um exercício específico.
 *  
 * @author João Arthur
 * @see <a href="http://joaoarthurbm.github.io/eda">http://joaoarthurbm.github.io/eda</a>
 * Computação @ UFCG
 */
public class TabelaHashEncadeada {

    private ArrayList<Aluno> tabela;
    private final int CAPACIDADE_DEFAULT = 23;

    /**
     * Cria uma nova tabela com a capacidade default 23.
     */
    @SuppressWarnings("unchecked")
    public TabelaHashEncadeada() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }
    
    /**
     * Cria uma nova tabela com a capacidade passada como parâmetro.
     * @param capacidade O número de posições da tabela.
     */
    @SuppressWarnings("unchecked")
    public TabelaHashEncadeada(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }
    
    /**
     * Calcula o hash de uma determinada chave. A função de hash é simples
     * e usa o método da divisão.
     * @param chave A chave para a qual se deseja calcular o hash.
     * @return O hash calculado tendo como base a chave e o tamanho da tabela.
     */
    private int hash(Integer chave) {
        //return chave % this.tabela.length;
        double a = 0.63274838;
        return (int) (((chave * a) % 1) * this.tabela.length);
    }
    
    /**
     * Adiciona o par chave, valor na tabela.
     * @param chave a matrícula do aluno a ser adicionado.
     * @param valor o objeto Aluno a ser adicionado na tabela.
     */
    public void put(Integer chave, Aluno valor) {
        int hash = hash(chave);
        ArrayList<Aluno> alunosTabela = this.tabela[hash];

        if(alunosTabela == null){
            alunosTabela = new ArrayList<>();
            alunosTabela.add(valor);
            this.tabela[hash] = alunosTabela;
        }
        else {
            for(int i = 0; i < alunosTabela.size(); i++){
                if(alunosTabela.get(i).getMatricula() == chave){
                    alunosTabela.set(i, valor);
                    return;
                }
            }
            alunosTabela.add(valor);
        }
    }

    /**
     * Recupera o aluno cuja chave é igual a passada como parâmetro.
     * @param chave a matrícula do aluno.
     * @return o aluno com a matrícula passada como parâmetro. null caso
     * nenhum aluno presente na tabela tenha a matrícula igual a passada como
     * parâmetro.
     */
    public Aluno get(Integer chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunosTabela = this.tabela[hash];

        if(alunosTabela == null) return null;
        
        for(Aluno a : alunosTabela){
            if(a.getMatricula() == chave) return a;
        }

        return null;
    }  

    public boolean containsKey(Integer chave) {
        return this.get(chave) != null; 
    }

    public boolean containsValue(Aluno aluno) {
        return aluno.equals(this.get(aluno.getMatricula()));
    }

    /**
     * Remove o aluno cuja matrícula é igual a chave passada como parâmetro.
     * @param chave A matrícula do aluno a ser removido.
     * @return O aluno a ser removido. null caso não haja aluno com a matrícula
     * passada como parâmetro. 
     */
    public Aluno remove(int chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        for(int i = 0; i < alunos.length; i++){
            if(alunos.get(i).getMatricula() == chave) {
                Aluno a = alunos.get(i);
                alunos.remove(i);
                return a;
            }
        }
        return null; 
    }  
}
