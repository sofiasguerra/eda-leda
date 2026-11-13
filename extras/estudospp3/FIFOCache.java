import java.util.*;

public class FIFOCache {

    // TODO adicionar atributos, construtor etc
    private Fila cache;
    private HashSet<String> set;

    public FIFOCache(int capacidade){
        this.cache = new Fila(capacidade);
        this.set = new HashSet<>();
    }

   public String get(String chave) {
       if(this.set.contains(chave)) return "hit";
    
       String obj = this.getNextEviction();
       if(obj != null) this.set.remove(obj);
    
        this.cache.addLast(chave);
        this.set.add(chave);
        return "miss";
    }

    public String getNextEviction() {
        if(this.cache.isFull()) return this.cache.getFirst();
        return null;
    }

    public int size() {
        return this.cache.size();
    }

}