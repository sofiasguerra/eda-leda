public class BSTTest {

    /*
     * Árvore usada na maioria dos testes:
     *
     *            50
     *          /    \
     *        30      70
     *       /  \    /  \
     *     20   40  60  80
     *         /  \
     *       35    45
     *
     * size = 9, altura = 3, folhas = 5 (20, 35, 45, 60, 80)
     */
    private static BST arvoreGrande() {
        BST t = new BST();
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 35, 45};
        for (int v : valores) t.add(v);
        return t;
    }

    public static void main(String[] args) {
        boolean ligado = false;
        assert ligado = true;
        if (!ligado) {
            System.out.println("Rode com assertions ligadas: java -ea BSTTest");
            return;
        }

        testArvoreVazia();
        testAdd();
        testSearch();
        testHeight();
        testContaFolhas();
        testEquals();
        testMinMax();
        testSucessor();
        testRemoveFolha();
        testRemoveRaizFolha();
        testRemoveUmFilho();
        testRemoveRaizUmFilho();
        testRemoveDoisFilhos();
        testRemoveRaizDoisFilhos();
        testRemoveInexistente();

        System.out.println("Todos os testes passaram.");
    }

    static void testArvoreVazia() {
        BST t = new BST();
        assert t.isEmpty();
        assert t.size() == 0;
        assert t.height() == -1;
        assert t.contaFolhas() == 0;
    }

    static void testAdd() {
        BST t = new BST();
        t.add(50);
        assert !t.isEmpty();
        assert t.size() == 1;
        assert t.search(50).parent == null;

        t.add(30);
        t.add(70);
        assert t.size() == 3;

        Node raiz = t.search(50);
        assert raiz.left.value == 30;
        assert raiz.right.value == 70;
        assert raiz.left.parent == raiz;
        assert raiz.right.parent == raiz;

        BST g = arvoreGrande();
        assert g.size() == 9;
        assert g.search(35).parent.value == 40;
        assert g.search(45).parent.value == 40;
        assert g.search(60).parent.value == 70;
    }

    static void testSearch() {
        BST t = arvoreGrande();
        assert t.search(50).value == 50;
        assert t.search(35).value == 35;
        assert t.search(80).value == 80;
        assert t.search(99) == null;
        assert t.search(1) == null;
        assert t.search(55) == null;
    }

    static void testHeight() {
        BST t = new BST();
        assert t.height() == -1;
        t.add(10);
        assert t.height() == 0;
        t.add(5);
        assert t.height() == 1;
        assert arvoreGrande().height() == 3;

        // árvore degenerada (só pra direita)
        BST lista = new BST();
        for (int i = 1; i <= 5; i++) lista.add(i);
        assert lista.height() == 4;
    }

    static void testContaFolhas() {
        BST t = new BST();
        assert t.contaFolhas() == 0;
        t.add(10);
        assert t.contaFolhas() == 1;
        t.add(5);
        assert t.contaFolhas() == 1; // 10 tem só um filho, a folha é o 5
        t.add(15);
        assert t.contaFolhas() == 2;
        assert arvoreGrande().contaFolhas() == 5;
    }

    static void testEquals() {
        BST a = arvoreGrande();
        BST b = arvoreGrande();
        assert a.equals(b);
        assert b.equals(a);

        // mesmos valores, ordem de inserção diferente => formato diferente
        BST c = new BST();
        int[] outraOrdem = {80, 70, 60, 50, 45, 40, 35, 30, 20};
        for (int v : outraOrdem) c.add(v);
        assert !a.equals(c);

        // mesmo formato, um valor diferente
        BST d = new BST();
        int[] umDiferente = {50, 30, 70, 20, 40, 60, 80, 35, 46};
        for (int v : umDiferente) d.add(v);
        assert !a.equals(d);

        // tamanhos diferentes
        BST e = new BST();
        e.add(50);
        assert !a.equals(e);
        assert !e.equals(a);

        // vazias
        assert new BST().equals(new BST());
        assert !new BST().equals(a);
        assert !a.equals(new BST());
    }

    static void testMinMax() {
        BST t = arvoreGrande();
        Node raiz = t.search(50);

        assert t.min(raiz).value == 20;
        assert t.max(raiz).value == 80;
        assert t.min(t.search(70)).value == 60;
        assert t.max(t.search(30)).value == 45;
        assert t.min(t.search(20)).value == 20; // folha
        assert t.min(null) == null;
        assert t.max(null) == null;
    }

    static void testSucessor() {
        BST t = arvoreGrande();

        assert t.sucessor(t.search(20)).value == 30; // sem filho direito, sobe
        assert t.sucessor(t.search(30)).value == 35; // tem filho direito: min da direita
        assert t.sucessor(t.search(35)).value == 40;
        assert t.sucessor(t.search(45)).value == 50; // sobe até o ancestral
        assert t.sucessor(t.search(50)).value == 60;
        assert t.sucessor(t.search(60)).value == 70;
        assert t.sucessor(t.search(80)) == null;     // maior elemento
        assert t.sucessor(null) == null;
    }

    static void testRemoveFolha() {
        BST t = arvoreGrande();

        t.remove(20); // filho esquerdo
        assert t.size() == 8;
        assert t.search(20) == null;
        assert t.search(30).left == null;

        t.remove(80); // filho direito
        assert t.size() == 7;
        assert t.search(80) == null;
        assert t.search(70).right == null;
        assert t.contaFolhas() == 3; // 35, 45, 60
    }

    static void testRemoveRaizFolha() {
        BST t = new BST();
        t.add(5);
        t.remove(5);
        assert t.isEmpty();
        assert t.size() == 0;
        assert t.height() == -1;
    }

    static void testRemoveUmFilho() {
        // só filho esquerdo
        BST t = new BST();
        t.add(50);
        t.add(30);
        t.add(20);
        t.remove(30);
        assert t.size() == 2;
        assert t.search(30) == null;
        assert t.search(50).left.value == 20;
        assert t.search(20).parent.value == 50;

        // só filho direito
        BST u = new BST();
        u.add(50);
        u.add(70);
        u.add(80);
        u.remove(70);
        assert u.size() == 2;
        assert u.search(70) == null;
        assert u.search(50).right.value == 80;
        assert u.search(80).parent.value == 50;
    }

    static void testRemoveRaizUmFilho() {
        // raiz só com filho direito
        BST t = new BST();
        t.add(10);
        t.add(20);
        t.remove(10);
        assert t.size() == 1;
        assert t.search(10) == null;
        assert t.search(20).parent == null;
        assert t.height() == 0;

        // raiz só com filho esquerdo
        BST u = new BST();
        u.add(10);
        u.add(5);
        u.remove(10);
        assert u.size() == 1;
        assert u.search(5).parent == null;
        assert u.height() == 0;
    }

    static void testRemoveDoisFilhos() {
        BST t = arvoreGrande();

        t.remove(30); // sucessor é o 35 (folha)
        assert t.size() == 8;
        assert t.search(30) == null;
        Node n = t.search(35);
        assert n != null;
        assert n.parent.value == 50;
        assert n.left.value == 20;
        assert n.right.value == 40;
        assert n.right.left == null; // o 35 antigo sumiu de baixo do 40

        BST u = arvoreGrande();
        u.remove(40); // sucessor é o 45
        assert u.size() == 8;
        assert u.search(40) == null;
        assert u.search(45).left.value == 35;
        assert u.search(45).right == null;
    }

    static void testRemoveRaizDoisFilhos() {
        BST t = arvoreGrande();
        t.remove(50); // sucessor é o 60
        assert t.size() == 8;
        assert t.search(50) == null;

        Node raiz = t.search(60);
        assert raiz.parent == null;
        assert raiz.left.value == 30;
        assert raiz.right.value == 70;
        assert raiz.right.left == null;
        assert t.height() == 3;
    }

    static void testRemoveInexistente() {
        BST t = arvoreGrande();
        t.remove(99);
        assert t.size() == 9;
        assert t.contaFolhas() == 5;
        assert t.equals(arvoreGrande());
    }

    // ---------- auxiliar ----------

    static boolean lancaExcecao(Runnable r) {
        try {
            r.run();
            return false;
        } catch (RuntimeException e) {
            return true;
        }
    }
}