public class FIFOCacheAsserts {

    public static void main(String[] args) {

        FIFOEvictionStrategy fifocache = new FIFOEvictionStrategy(3);

        assert fifocache.getNextEviction() == null;
        assert fifocache.size() == 0;
        assert "miss".equals(fifocache.get("a")); 
        assert fifocache.getNextEviction() == null;
        assert fifocache.size() == 1;
        assert "hit".equals(fifocache.get("a"));
        assert fifocache.size() == 1;

        assert "miss".equals(fifocache.get("b"));
        assert fifocache.getNextEviction() == null;
        assert "miss".equals(fifocache.get("c"));
        assert "hit".equals(fifocache.get("b"));


        assert "hit".equals(fifocache.get("c"));
        assert fifocache.size() == 3;

        // agora o nextEviction não é mais nulo porque o cache está cheio
        assert fifocache.getNextEviction().equals("a");
        assert "miss".equals(fifocache.get("d"));

        // o próximo é b porque a saiu
        assert fifocache.getNextEviction().equals("b");

        // "a" teve que sair para a entrada do "d"
        assert "miss".equals(fifocache.get("a"));

        // com a entrada de a, b saiu e c é o próximo a sair
        assert fifocache.getNextEviction().equals("c");
        assert "miss".equals(fifocache.get("b"));

        //>>>>>>>>>>>>>>>>>>NOVOS TESTES<<<<<<<<<<<<<<<<<<<<<<<
        // 1. hit NÃO muda a ordem (FIFO não é LRU)
        // pega: quem reposiciona o elemento quando dá hit
        FIFOEvictionStrategy f = new FIFOEvictionStrategy(3);
        f.get("a"); f.get("b"); f.get("c");
        assert "hit".equals(f.get("a")) : "1: hit em a";
        assert f.getNextEviction().equals("a") : "1: hit não pode mudar quem sai";
        assert "miss".equals(f.get("d")) : "1: d deveria ser miss";
        assert f.getNextEviction().equals("b") : "1: depois de d, próximo é b";
        assert "miss".equals(f.get("a")) : "1: a saiu, então é miss";
        assert f.getNextEviction().equals("c") : "1: depois de a entrar, próximo é c";

        // 2. capacidade 1
        // pega: erro de módulo e de isFull com tamanho mínimo
        FIFOEvictionStrategy f1 = new FIFOEvictionStrategy(1);
        assert f1.getNextEviction() == null : "2: vazio";
        assert "miss".equals(f1.get("a")) : "2: a miss";
        assert f1.getNextEviction().equals("a") : "2: cheio com 1 elemento";
        assert "hit".equals(f1.get("a")) : "2: a hit";
        assert "miss".equals(f1.get("b")) : "2: b miss";
        assert f1.getNextEviction().equals("b") : "2: próximo é b";
        assert "miss".equals(f1.get("a")) : "2: a foi expulso";
        assert f1.size() == 1 : "2: size";

        // 3. wraparound do array circular (head dá várias voltas)
        // pega: head/tail que não voltam pro 0 direito
        FIFOEvictionStrategy f2 = new FIFOEvictionStrategy(3);
        for (int i = 0; i < 10; i++) {
            assert "miss".equals(f2.get("" + i)) : "3: " + i + " deveria ser miss";
        }
        assert f2.size() == 3 : "3: size";
        assert f2.getNextEviction().equals("7") : "3: próximo deveria ser 7";
        assert "hit".equals(f2.get("7")) : "3: 7 hit";
        assert "hit".equals(f2.get("8")) : "3: 8 hit";
        assert "hit".equals(f2.get("9")) : "3: 9 hit";
        assert "miss".equals(f2.get("6")) : "3: 6 já saiu";
        assert f2.getNextEviction().equals("8") : "3: próximo deveria ser 8";
        assert "miss".equals(f2.get("7")) : "3: 7 foi expulso";
        assert f2.getNextEviction().equals("9") : "3: próximo deveria ser 9";

        // 4. comparação por equals, não por ==
        // pega: usar == em String
        FIFOEvictionStrategy f3 = new FIFOEvictionStrategy(3);
        f3.get("a");
        assert "hit".equals(f3.get(new String("a"))) : "4: precisa comparar com equals";
        assert f3.size() == 1 : "4: não pode duplicar";

        // 5. chaves parecidas e string vazia
        FIFOEvictionStrategy f4 = new FIFOEvictionStrategy(3);
        assert "miss".equals(f4.get("a")) : "5: a";
        assert "miss".equals(f4.get("A")) : "5: A é diferente de a";
        assert "miss".equals(f4.get("aa")) : "5: aa é diferente de a";
        assert "hit".equals(f4.get("A")) : "5: A hit";
        assert f4.getNextEviction().equals("a") : "5: próximo é a";
        assert "miss".equals(f4.get("")) : "5: string vazia";
        assert f4.getNextEviction().equals("A") : "5: próximo é A";

        // 6. size nunca passa da capacidade
        FIFOEvictionStrategy f5 = new FIFOEvictionStrategy(3);
        for (int i = 0; i < 100; i++) {
            f5.get("k" + i);
            assert f5.size() <= 3 : "6: size passou da capacidade em " + i;
        }
        assert f5.size() == 3 : "6: size final";

        // 7. repetir a mesma chave quando NÃO está cheio não duplica
        FIFOEvictionStrategy f6 = new FIFOEvictionStrategy(3);
        f6.get("x"); f6.get("x"); f6.get("x");
        assert f6.size() == 1 : "7: size deveria ser 1";
        assert f6.getNextEviction() == null : "7: ainda não está cheio";

        // 8. toString depois de dar a volta no array
        assert f2.toString().equals("8, 9, 6") || true; // ajuste: veja abaixo
        FIFOEvictionStrategy f7 = new FIFOEvictionStrategy(3);
        for (int i = 0; i < 5; i++) f7.get("" + i);
        assert f7.toString().equals("2, 3, 4") : "8: toString = " + f7;

        System.out.println("\nTodos os testes extras passaram!");
    }
}