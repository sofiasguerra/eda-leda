import java.util.*;

public class IndiceInvertido {

    private HashMap<String, ArrayList<String>> mapa;

    public IndiceInvertido() {
        this.mapa = new HashMap<>();
    }

    public void addDocument(String docID, String content) {
        String[] keys = content.split(" ");

        for(String word : keys){
            String lowerWord = word.toLowerCase();
            ArrayList<String> listWord = mapa.get(lowerWord);
            if(listWord == null){
                listWord = new ArrayList<>();
                listWord.add(docID);
                mapa.put(lowerWord, listWord);
            } else if(!listWord.contains(docID)){   //TRATAR A DUPLICADA!!!!!
                listWord.add(docID);
            }
        }
    }

    public List<String> search(String word) {
        ArrayList lista = this.mapa.get(word.toLowerCase());
        if(lista == null) return new ArrayList<>(); //lista vazia
        return new ArrayList<>(lista);   //uma copia para nao dar acesso ao parametro interno
    }
}
