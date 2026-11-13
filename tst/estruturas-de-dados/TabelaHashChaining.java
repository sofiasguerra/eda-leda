import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacidade = sc.nextInt();

        TabelaHashChaining tabela = new TabelaHashChaining(capacidade);

        while (true) {
            String ent = sc.next();
            switch (ent) {
                case "put": {
                    int key = sc.nextInt();
                    String value = sc.next();
                    tabela.put(key, value);
                    System.out.println(Arrays.toString(tabela.tabela));
                    break;
                }
                case "remove": {
                    int k = sc.nextInt();
                    tabela.remove(k);
                    System.out.println(Arrays.toString(tabela.tabela));
                    break;
                }
                case "keys": {
                    ArrayList<Integer> ks = new ArrayList<>(tabela.keys); // cópia, pra não bagunçar o original
                    Collections.sort(ks);
                    System.out.println(ks);
                    break;
                }
                case "values": {
                    ArrayList<String> vs = new ArrayList<>(tabela.values);
                    Collections.sort(vs);
                    System.out.println(vs);
                    break;
                }
                case "end":
                    return;
            }
        }
    }
}

class TabelaHashChaining {

    protected ArrayList<Pair>[] tabela;
    protected ArrayList<Integer> keys;
    protected ArrayList<String> values;

    @SuppressWarnings("unchecked")
    public TabelaHashChaining(int capacidade) {
        this.tabela = (ArrayList<Pair>[]) new ArrayList[capacidade];
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        for (int i = 0; i < capacidade; i++)
            tabela[i] = new ArrayList<>();
    }

    public int hash(int key) {
        return key % this.tabela.length;
    }

    public void put(int k, String v) {
        ArrayList<Pair> bucket = tabela[hash(k)];

        for (Pair p : bucket) {
            if (p.key == k) {
                values.remove(p.value); // tira UMA ocorrência do valor antigo
                values.add(v);
                p.setValue(v);
                return;
            }
        }

        bucket.add(new Pair(k, v));
        keys.add(k);
        values.add(v);
    }

    public void remove(int k) {
        ArrayList<Pair> bucket = tabela[hash(k)];

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == k) {
                values.remove(bucket.get(i).value);
                keys.remove(Integer.valueOf(k)); // Integer.valueOf: remove pelo valor, não pelo índice
                bucket.remove(i);
                return;
            }
        }
    }
}

class Pair {

    int key;
    String value;

    public Pair(int k, String v) {
        this.key = k;
        this.value = v;
    }

    public void setValue(String n) {
        this.value = n;
    }

    @Override
    public String toString() {
        return "<" + key + ", " + value + ">";
    }
}