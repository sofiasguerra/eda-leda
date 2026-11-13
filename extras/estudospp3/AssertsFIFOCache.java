public class AssertsFIFOCache {

    public static void main(String[] args) {
        testaCacheVazio();
        testaMissEHit();
        testaEviccaoFifo();
        testaSemEviccaoQuandoNaoCheio();
        testaCapacidadeUm();
        testaEviccaoMultipla();
        testaReinsercaoAposEviccao();
        testaOrdemAposMultiplasEviccoes();
    }

    // Estado inicial: cache vazio, sem próximo para despejo
    static void testaCacheVazio() {
        System.out.print("testaCacheVazio... ");
        FIFOCache c = new FIFOCache(3);
        assert c.getNextEviction() == null;
        assert c.size() == 0;
        System.out.println("OK");
    }

    // Miss adiciona, hit não duplica e size se mantém
    static void testaMissEHit() {
        System.out.print("testaMissEHit... ");
        FIFOCache c = new FIFOCache(3);
        assert "miss".equals(c.get("a"));
        assert c.size() == 1;
        assert "hit".equals(c.get("a"));
        assert c.size() == 1;
        assert "miss".equals(c.get("b"));
        assert c.size() == 2;
        assert "hit".equals(c.get("b"));
        assert c.size() == 2;
        System.out.println("OK");
    }

    // Ordem FIFO de despejo: o primeiro a entrar é o primeiro a sair
    static void testaEviccaoFifo() {
        System.out.print("testaEviccaoFifo... ");
        FIFOCache c = new FIFOCache(3);
        c.get("a");
        c.get("b");
        c.get("c");
        assert c.size() == 3;
        assert c.getNextEviction().equals("a");
        assert "miss".equals(c.get("d"));
        assert c.size() == 3;
        assert c.getNextEviction().equals("b");
        assert "miss".equals(c.get("e"));
        assert c.size() == 3;
        assert c.getNextEviction().equals("c");
        System.out.println("OK");
    }

    static void testaSemEviccaoQuandoNaoCheio() {
    System.out.print("testaSemEviccaoQuandoNaoCheio... ");
    FIFOCache c = new FIFOCache(3);
    c.get("a"); c.get("b");
    assert c.getNextEviction() == null;
    assert "hit".equals(c.get("a")); // a continua no cache e no set
    System.out.println("OK");
}

    // Cache com capacidade 1: toda nova chave despeja a anterior
    static void testaCapacidadeUm() {
        System.out.print("testaCapacidadeUm... ");
        FIFOCache c = new FIFOCache(1);
        assert c.getNextEviction() == null;
        assert "miss".equals(c.get("a"));
        assert c.size() == 1;
        assert c.getNextEviction().equals("a");
        assert "hit".equals(c.get("a"));
        assert c.size() == 1;
        assert "miss".equals(c.get("b"));
        assert c.size() == 1;
        assert c.getNextEviction().equals("b");
        assert "hit".equals(c.get("b"));
        assert "miss".equals(c.get("a"));
        assert c.size() == 1;
        assert c.getNextEviction().equals("a");
        System.out.println("OK");
    }

    // Cache maior: várias evicções consecutivas mantêm a ordem FIFO
    static void testaEviccaoMultipla() {
        System.out.print("testaEviccaoMultipla... ");
        FIFOCache c = new FIFOCache(5);
        c.get("a"); c.get("b"); c.get("c"); c.get("d"); c.get("e");
        assert c.size() == 5;
        assert c.getNextEviction().equals("a");

        // despeja a, b, c, d
        c.get("f"); assert c.getNextEviction().equals("b");
        c.get("g"); assert c.getNextEviction().equals("c");
        c.get("h"); assert c.getNextEviction().equals("d");
        c.get("i"); assert c.getNextEviction().equals("e");
        assert c.size() == 5;

        // todos os originais saíram; a fila agora é [e, f, g, h, i]
        assert "hit".equals(c.get("f")); // f ainda está no cache
        assert c.getNextEviction().equals("e");
        System.out.println("OK");
    }

    // Reinserir chave que já foi despejada funciona como miss normal
    static void testaReinsercaoAposEviccao() {
        System.out.print("testaReinsercaoAposEviccao... ");
        FIFOCache c = new FIFOCache(3);
        c.get("a"); c.get("b"); c.get("c");
        c.get("d"); // despeja a
        assert "miss".equals(c.get("a")); // a foi despejado, readiciona (despeja b)
        assert c.getNextEviction().equals("c");
        assert "miss".equals(c.get("b")); // b foi despejado, readiciona (despeja c)
        assert c.getNextEviction().equals("d");
        System.out.println("OK");
    }

    // Ordem FIFO após várias evicções: dois ciclos completos
    static void testaOrdemAposMultiplasEviccoes() {
        System.out.print("testaOrdemAposMultiplasEviccoes... ");
        FIFOCache c = new FIFOCache(3);
        c.get("a"); c.get("b"); c.get("c");

        // primeiro ciclo: a, b, c saem na ordem
        c.get("d"); assert c.getNextEviction().equals("b");
        c.get("e"); assert c.getNextEviction().equals("c");
        c.get("f"); assert c.getNextEviction().equals("d");
        assert c.size() == 3;

        // segundo ciclo: d, e, f saem na ordem
        c.get("g"); assert c.getNextEviction().equals("e");
        c.get("h"); assert c.getNextEviction().equals("f");
        c.get("i"); assert c.getNextEviction().equals("g");
        assert c.size() == 3;

        // verifica que i, h, g ainda estão no cache (hit)
        assert "hit".equals(c.get("i"));
        assert "hit".equals(c.get("h"));
        assert "hit".equals(c.get("g"));
        System.out.println("OK");
    }

}