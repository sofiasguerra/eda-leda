import java.util.List;

public class AssertsIndiceInvertido {

    public static void main(String[] args) {
        testaIndexacao();
        testaConteudo();
        testaPalavraInexistente();
        testaCaseInsensitive();
        testaDocumentoDuplicado();
        testaOrdemDeInsercao();
    }

    static void testaIndexacao() {
        System.out.print("testaIndexacao... ");
        IndiceInvertido index = new IndiceInvertido();

        index.addDocument("doc1", "Estruturas de dados e algoritmos");
        index.addDocument("doc2", "Algoritmos e complexidade");
        index.addDocument("doc3", "Estruturas de software");

        assert index.search("estruturas").size() == 2
            : "Palavra 'estruturas' deveria aparecer em 2 documentos";
        assert index.search("algoritmos").size() == 2
            : "Palavra 'algoritmos' deveria aparecer em 2 documentos";
        System.out.println("OK");
    }

    static void testaConteudo() {
        System.out.print("testaConteudo... ");
        IndiceInvertido index = new IndiceInvertido();

        index.addDocument("doc1", "Estruturas de dados e algoritmos");
        index.addDocument("doc2", "Algoritmos e complexidade");
        index.addDocument("doc3", "Estruturas de software");

        assert index.search("estruturas").contains("doc1")
            : "doc1 deveria conter 'estruturas'";
        assert index.search("estruturas").contains("doc3")
            : "doc3 deveria conter 'estruturas'";
        System.out.println("OK");
    }

    static void testaPalavraInexistente() {
        System.out.print("testaPalavraInexistente... ");
        IndiceInvertido index = new IndiceInvertido();

        index.addDocument("doc1", "Estruturas de dados e algoritmos");

        assert index.search("hash") != null
            : "Busca deve retornar lista vazia, não null";
        assert index.search("hash").isEmpty()
            : "Lista deve estar vazia para palavra inexistente";
        System.out.println("OK");
    }

    static void testaCaseInsensitive() {
        System.out.print("testaCaseInsensitive... ");
        IndiceInvertido index = new IndiceInvertido();

        index.addDocument("doc1", "Estruturas de dados e algoritmos");
        index.addDocument("doc2", "Algoritmos e complexidade");
        index.addDocument("doc3", "Estruturas de software");

        assert index.search("ALGORITMOS").size() == 2
            : "Busca deve ser case-insensitive";
        System.out.println("OK");
    }

    static void testaDocumentoDuplicado() {
        System.out.print("testaDocumentoDuplicado... ");
        IndiceInvertido index = new IndiceInvertido();

        index.addDocument("doc1", "Estruturas de dados e algoritmos");
        index.addDocument("doc2", "Algoritmos e complexidade");
        index.addDocument("doc3", "Estruturas de software");
        index.addDocument("doc1", "Estruturas avançadas");

        assert index.search("estruturas").size() == 2
            : "Documento não pode ser duplicado na lista";
        System.out.println("OK");
    }

    static void testaOrdemDeInsercao() {
        System.out.print("testaOrdemDeInsercao... ");
        IndiceInvertido index = new IndiceInvertido();

        index.addDocument("doc1", "Estruturas de dados e algoritmos");
        index.addDocument("doc2", "Algoritmos e complexidade");
        index.addDocument("doc3", "Estruturas de software");

        List<String> docs = index.search("estruturas");
        assert docs.get(0).equals("doc1")
            : "Ordem de inserção deve ser preservada";
        assert docs.get(1).equals("doc3")
            : "Ordem de inserção deve ser preservada";
        System.out.println("OK");
    }

}