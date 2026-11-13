import java.util.*;

public class IndiceInvertido2 {

    private ArrayList<String>[] tabela;
    private int size;
    private static final int TAM_DEFAULT = 41; //nao me importarei com resize/ rehash;

    public IndiceInvertido2() {
        this(TAM_DEFAULT);
    }

    @SuppressWarnings("unchecked")
    public IndiceInvertido2(int capacidade){
        this.tabela = new ArrayList[capacidade];
    }

    public int hash(String chave){
        int h = chave.hashCode();
        return Math.floorMod(h, this.tabela.length);
    }

    public void addDocument(String docID, String content) {
        String[] k = content.toLowerCase().split(" ");
        for(String s : k){
            this.put(s, docID.toLowerCase());
        }
    }

    private void put(String chave, String valor){
        int hash = hash(chave);
        ArrayList<String> listTabela = this.tabela[hash];

        if(listTabela == null){
            this.tabela[hash] = new ArrayList<>();
            this.tabela[hash].add(valor);
        } else if(!listTabela.contains(valor)){
            listTabela.add(valor);
        }
        this.size++;
    }

    public List<String> search(String word) {
        int hash = hash(word.toLowerCase());
        ArrayList<String> listaTabela = this.tabela[hash];

        if(listaTabela == null) return new ArrayList<>();
        return listaTabela;
    }

}