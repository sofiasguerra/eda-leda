import java.util.*;

public class FIFOEvictionStrategy {

    private FIFOCache cache;
    private HashSet<String> set;

    // deve ter uma FIFOCache como atributo
    public FIFOEvictionStrategy(int capacidade) {
        this.cache = new FIFOCache(capacidade);
        this.set = new HashSet<>();
    }

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
        if(this.set.contains(chave)) return "hit";
        if(this.getNextEviction() != null){
            this.set.remove(this.getNextEviction());
        }
        this.set.add(chave);
        this.cache.addLast(chave);
        return "miss";
    }

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    **/
    public String getNextEviction() {
        if(this.cache.isFull()) return this.cache.getFirst();
        return null;
    }    

    //retorna a quantidade de elementos no cache.
    public int size() {
        return this.cache.size();
    }

    @Override
    public String toString() {
        return this.cache.toString();
    }
}
