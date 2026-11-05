import util.Aluno;
public class AssertsTabelaHashEncadeada {

    public void testPut() {
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(5);

        Aluno aluno1 = new Aluno(1, "Ana");
        Aluno aluno2 = new Aluno(2, "Maria");

        assert !tabela.containsKey(1);
        assert tabela.get(1) == null;

        tabela.put(1, aluno1);

        assert tabela.containsKey(1);
        assert tabela.get(1) == aluno1;

        tabela.put(2, aluno2);

        assert tabela.containsKey(2);
        assert tabela.get(2) == aluno2;

        // Atualização de um aluno com a mesma chave
        Aluno aluno3 = new Aluno(1, "João");
        tabela.put(1, aluno3);

        assert tabela.get(1) == aluno3;
        assert tabela.get(1) != aluno1;

        // Colisão: 1 e 6 possuem o mesmo hash
        Aluno aluno4 = new Aluno(6, "Pedro");
        tabela.put(6, aluno4);

        assert tabela.get(1) == aluno3;
        assert tabela.get(6) == aluno4;
    }

    public void testGet() {
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(5);

        Aluno aluno1 = new Aluno(1, "Ana");
        Aluno aluno2 = new Aluno(6, "Maria");
        Aluno aluno3 = new Aluno(2, "João");

        assert tabela.get(1) == null;

        tabela.put(1, aluno1);
        tabela.put(6, aluno2);
        tabela.put(2, aluno3);

        assert tabela.get(1) == aluno1;
        assert tabela.get(6) == aluno2;
        assert tabela.get(2) == aluno3;

        // Chave inexistente em uma posição ocupada
        assert tabela.get(11) == null;

        // Chave inexistente em uma posição vazia
        assert tabela.get(3) == null;
    }

    public void testContainsKey() {
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(5);

        Aluno aluno1 = new Aluno(1, "Ana");
        Aluno aluno2 = new Aluno(6, "Maria");

        assert !tabela.containsKey(1);

        tabela.put(1, aluno1);

        assert tabela.containsKey(1);
        assert !tabela.containsKey(2);

        tabela.put(6, aluno2);

        assert tabela.containsKey(1);
        assert tabela.containsKey(6);
        assert !tabela.containsKey(11);
    }

    public void testContainsValue() {
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(5);

        Aluno aluno1 = new Aluno(1, "Ana");
        Aluno aluno2 = new Aluno(6, "Maria");
        Aluno aluno3 = new Aluno(1, "João");

        assert !tabela.containsValue(aluno1);

        tabela.put(1, aluno1);
        tabela.put(6, aluno2);

        assert tabela.containsValue(aluno1);
        assert tabela.containsValue(aluno2);
        assert !tabela.containsValue(aluno3);

        // Atualizando o valor da chave 1
        tabela.put(1, aluno3);

        assert !tabela.containsValue(aluno1);
        assert tabela.containsValue(aluno3);
        assert tabela.containsValue(aluno2);
    }

    public void testRemove() {
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(5);

        Aluno aluno1 = new Aluno(1, "Ana");
        Aluno aluno2 = new Aluno(6, "Maria");
        Aluno aluno3 = new Aluno(2, "João");

        // Remoção de chave inexistente
        assert tabela.remove(1) == null;

        tabela.put(1, aluno1);
        tabela.put(6, aluno2);
        tabela.put(2, aluno3);

        // Remoção de um aluno existente
        assert tabela.remove(1) == aluno1;

        assert tabela.get(1) == null;
        assert !tabela.containsKey(1);

        // Os outros alunos devem continuar na tabela
        assert tabela.get(6) == aluno2;
        assert tabela.get(2) == aluno3;

        // Remoção de elemento que está na mesma lista de colisão
        assert tabela.remove(6) == aluno2;

        assert tabela.get(6) == null;
        assert tabela.get(2) == aluno3;

        // Remoção do último elemento
        assert tabela.remove(2) == aluno3;
        assert tabela.get(2) == null;

        // Tentativa de remover novamente
        assert tabela.remove(2) == null;
    }

    public static void main(String[] args) {
        AssertsTabelaHashEncadeada testes = new AssertsTabelaHashEncadeada();

        testes.testPut();
        testes.testGet();
        testes.testContainsKey();
        testes.testContainsValue();
        testes.testRemove();

        System.out.println("\nTodos os testes de AssertsTabelaHashEncadeada passaram!!!");
    }
}