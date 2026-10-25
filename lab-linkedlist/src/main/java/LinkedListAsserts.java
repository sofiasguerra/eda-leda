public class LinkedListAsserts {
    
    public void testIsEmpty() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();

        ll.addFirst(1);
        assert !ll.isEmpty();

        ll.addFirst(2);
        assert !ll.isEmpty();

        ll.addFirst(3);
        ll.removeFirst();
        assert !ll.isEmpty();

        ll.removeFirst();
        assert !ll.isEmpty();

        ll.removeFirst();
        assert ll.isEmpty();
    }

    public void testLastIndexOf() {
        LinkedList ll = new LinkedList();

        assert ll.lastIndexOf(1) == -1;

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        assert ll.lastIndexOf(3) == 2;
        assert ll.lastIndexOf(2) == 1;
        assert ll.lastIndexOf(1) == 0;

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(1);

        assert ll.lastIndexOf(1) == 2;

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(3);

        assert ll.lastIndexOf(3) == 4;
    }

    public void testToString() {
        LinkedList list = new LinkedList();

        assert list.toString().equals("");

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        assert list.toString().equals("1, 2, 3, 4, 5");

        list.removeFirst();
        list.removeFirst();

        assert list.toString().equals("3, 4, 5");

        list.addLast(10);
        list.addLast(11);

        assert list.toString().equals("3, 4, 5, 10, 11");
    }

    public void testListGet() {
        LinkedList list = new LinkedList();

        try {
            list.get(0);
            assert false;
        } catch (Exception e) {}

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        assert list.get(0) == 10;
        assert list.get(1) == 20;

        list.removeFirst();
        list.addLast(60);

        assert list.get(4) == 60;

        try {
            list.get(-1);
            assert false;
        } catch (Exception e) {}

        try {
            list.get(5);
            assert false;
        } catch (Exception e) {}
    }


    public void testListGetFirst() {
        LinkedList ll = new LinkedList();

        try {
            ll.getFirst();
            assert false;
        } catch (Exception e) {}

        ll.addLast(10);
        assert ll.getFirst() == 10;

        ll.addLast(20);
        assert ll.getFirst() == 10;

        ll.addFirst(30);
        assert ll.getFirst() == 30;
    }

    public void testListGetLast() {
        LinkedList ll = new LinkedList();

        try {
            ll.getLast();
            assert false;
        } catch (Exception e) {}

        ll.addLast(10);
        assert ll.getLast() == 10;

        ll.addLast(20);
        assert ll.getLast() == 20;

        ll.addFirst(30);
        assert ll.getLast() == 20;
    }

    public void testListIndexOf() {
        LinkedList ll = new LinkedList();

        assert ll.indexOf(10) == -1;

        ll.addLast(10);
        assert ll.indexOf(10) == 0;

        ll.addLast(20);
        assert ll.indexOf(20) == 1;
        assert ll.indexOf(10) == 0;

        ll.addLast(10);
        ll.addLast(10);

        assert ll.indexOf(10) == 0;
    }

    public void testListRemoveFirst() {
        LinkedList ll = new LinkedList();

        try {
            ll.removeFirst();
            assert false;
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        assert ll.getFirst() == 1;
        assert ll.removeFirst() == 1;

        assert ll.getFirst() == 2;
        assert ll.removeFirst() == 2;

        assert ll.getFirst() == 3;
        assert ll.removeFirst() == 3;

        assert ll.getFirst() == 4;
        assert ll.removeFirst() == 4;

        assert ll.isEmpty();
    }

    public void testListRemoveLast() {
        LinkedList ll = new LinkedList();

        try {
            ll.removeLast();
            assert false;
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        assert ll.getLast() == 4;
        ll.removeLast();

        assert ll.getLast() == 3;
        ll.removeLast();

        assert ll.getLast() == 2;
        ll.removeLast();

        assert ll.getLast() == 1;
        ll.removeLast();

        assert ll.isEmpty();
    }

    public void testListRemove() {
        LinkedList ll = new LinkedList();

        try {
            ll.remove(-1);
            assert false;
        } catch (Exception e) {}

        try {
            ll.remove(6);
            assert false;
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);

        assert ll.indexOf(2) == 1;

        ll.remove(1);
        assert ll.indexOf(2) == 3;
        assert ll.indexOf(1) == 0;

        ll.remove(0);
        assert ll.indexOf(1) == -1;
        assert ll.indexOf(3) == 0;

        ll.remove(0);
        assert ll.indexOf(3) == -1;
        assert ll.indexOf(4) == 0;

        ll.remove(0);
        assert ll.indexOf(4) == -1;
        assert ll.indexOf(2) == 0;

        ll.remove(0);
        assert ll.indexOf(2) == -1;

        assert ll.isEmpty();
    }

    public void testListRemoveByValue() {
        LinkedList ll = new LinkedList();

        assert !ll.removeByValue(5);

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);

        assert ll.removeByValue(1);
        assert !ll.removeByValue(1);

        assert ll.getFirst() == 2;
        assert ll.indexOf(2) == 0;

        ll.removeByValue(2);
        assert ll.indexOf(2) == 2;

        ll.removeByValue(3);
        ll.removeByValue(4);

        assert ll.getFirst() == 2;

        ll.removeByValue(2);
        assert ll.isEmpty();
    }

    public void testLLAddLast() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();
        assert ll.size() == 0;

        ll.addLast(12);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 12;
        assert ll.size() == 1;

        ll.addLast(20);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 20;
        assert ll.size() == 2;

        ll.addLast(30);
        ll.addLast(40);

        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 40;
        assert ll.size() == 4;

        ll.addLast(50);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 50;
        assert ll.size() == 5;

        ll.addLast(60);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 60;
        assert ll.size() == 6;
    }

    public void testListAddFirst() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();
        assert ll.size() == 0;

        ll.addFirst(50);
        assert !ll.isEmpty();
        assert ll.getFirst() == 50;
        assert ll.size() == 1;

        ll.addFirst(40);
        ll.addFirst(30);

        assert !ll.isEmpty();
        assert ll.getFirst() == 30;
        assert ll.size() == 3;

        ll.addFirst(20);
        assert !ll.isEmpty();
        assert ll.getFirst() == 20;
        assert ll.size() == 4;

        ll.addFirst(10);
        assert !ll.isEmpty();
        assert ll.getFirst() == 10;
        assert ll.size() == 5;

        ll.addFirst(5);
        assert !ll.isEmpty();
        assert ll.getFirst() == 5;
        assert ll.size() == 6;
    }

    public void testLinkedListAdd() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();
        assert ll.size() == 0;

        try {
            ll.add(-1, 12);
            assert false;
        } catch (Exception e) {}

        try {
            ll.add(7, 12);
            assert false;
        } catch (Exception e) {}

        ll.add(0, 12);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.size() == 1;

        ll.add(1, 20);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 20;
        assert ll.size() == 2;

        ll.add(2, 30);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 30;
        assert ll.size() == 3;

        ll.add(2, 25);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.get(2) == 25;
        assert ll.getLast() == 30;
        assert ll.size() == 4;

        ll.add(0, 5);
        assert !ll.isEmpty();
        assert ll.getFirst() == 5;
        assert ll.getLast() == 30;
        assert ll.size() == 5;

        ll.add(2, 15);
        assert !ll.isEmpty();
        assert ll.getFirst() == 5;
        assert ll.getLast() == 30;
        assert ll.size() == 6;
    }

    public void testMoveToHead() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.moveToHead(2);
        assert ll.toString().equals("3, 1, 2, 4, 5");

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.moveToHead(0);
        assert ll.toString().equals("1, 2, 3, 4, 5");

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.moveToHead(4);
        assert ll.toString().equals("5, 1, 2, 3, 4");
        assert ll.getLast() == 4;

        ll = new LinkedList();
        ll.addLast(7);
        ll.moveToHead(0);
        assert ll.toString().equals("7");

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.moveToHead(1);
        assert ll.toString().equals("2, 1");
    }

    public void testInsereOrdenado() {
        LinkedList ll = new LinkedList();
        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(6);
        ll.insereOrdenado(5);
        assert ll.toString().equals("2, 4, 5, 6");

        ll = new LinkedList();
        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(6);

        ll.insereOrdenado(1);
        assert ll.toString().equals("1, 2, 4, 6");

        ll = new LinkedList();
        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(6);

        ll.insereOrdenado(10);
        assert ll.toString().equals("2, 4, 6, 10");

        ll = new LinkedList();
        ll.insereOrdenado(5);
        assert ll.toString().equals("5");

        ll = new LinkedList();
        ll.addLast(5);
        ll.insereOrdenado(3);
        assert ll.toString().equals("3, 5");

        ll = new LinkedList();
        ll.addLast(5);
        ll.insereOrdenado(7);
        assert ll.toString().equals("5, 7");

        // com repetidos: v deve ser inserido depois dos elementos iguais a ele
        ll = new LinkedList();
        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(4);
        ll.addLast(6);

        ll.insereOrdenado(4);
        assert ll.toString().equals("2, 4, 4, 4, 6");
    }

    public void testSwap() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        Node n1 = ll.getNode(1);
        Node n2 = ll.getNode(3);
        ll.swap(n1, n2);

        assert ll.toString().equals("1, 4, 3, 2, 5");
        // confirma que foram as referências que se moveram, não os valores
        assert ll.getNode(1) == n2;
        assert ll.getNode(3) == n1;

        // nós adjacentes
        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        n1 = ll.getNode(1);
        n2 = ll.getNode(2);
        ll.swap(n1, n2);
        assert ll.toString().equals("1, 3, 2, 4, 5");
        assert ll.getNode(1) == n2;
        assert ll.getNode(2) == n1;

        // head e tail
        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        n1 = ll.getNode(0);
        n2 = ll.getNode(4);
        ll.swap(n1, n2);

        assert ll.toString().equals("5, 2, 3, 4, 1");
        assert ll.getFirst() == 5;
        assert ll.getLast() == 1;
        assert ll.getNode(0) == n2;
        assert ll.getNode(4) == n1;

        // lista de dois elementos
        ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);

        n1 = ll.getNode(0);
        n2 = ll.getNode(1);
        ll.swap(n1, n2);

        assert ll.toString().equals("20, 10");
    }

    public void testInverte() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.inverte();
        assert ll.toString().equals("5, 4, 3, 2, 1");
        assert ll.getFirst() == 5;
        assert ll.getLast() == 1;

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.inverte();
        assert ll.toString().equals("2, 1");

        ll = new LinkedList();
        ll.addLast(1);
        ll.inverte();
        assert ll.toString().equals("1");

        ll = new LinkedList();
        ll.inverte();
        assert ll.isEmpty();
        assert ll.toString().equals("");
    }

    public void testToStringReverso() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        assert ll.toStringReverso().equals("5, 4, 3, 2, 1");

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        assert ll.toStringReverso().equals("2, 1");

        ll = new LinkedList();
        ll.addLast(1);
        assert ll.toStringReverso().equals("1");

        ll = new LinkedList();
        assert ll.toStringReverso().equals("");
    }

    public void testRemoveAll() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(2);

        assert ll.removeAll(2) == 3;
        assert ll.toString().equals("1, 3, 4");

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        assert ll.removeAll(5) == 0;
        assert ll.toString().equals("1, 2, 3");

        ll = new LinkedList();
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(2);

        assert ll.removeAll(2) == 3;
        assert ll.isEmpty();

        ll = new LinkedList();
        ll.addLast(1);

        assert ll.removeAll(1) == 1;
        assert ll.isEmpty();
    }

    public void testToArray() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        assert java.util.Arrays.equals(ll.toArray(), new int[]{1, 2, 3, 4, 5});

        ll = new LinkedList();
        assert java.util.Arrays.equals(ll.toArray(), new int[]{});

        ll = new LinkedList();
        ll.addLast(7);
        assert java.util.Arrays.equals(ll.toArray(), new int[]{7});
    }

    public void testMeio() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        assert ll.meio() == 3;

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        assert ll.meio() == 3;

        ll = new LinkedList();
        ll.addLast(9);
        assert ll.meio() == 9;

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        assert ll.meio() == 2;
    }

    public void testIsPalindromo() {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        assert ll.isPalindromo();

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        assert !ll.isPalindromo();

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(1);
        assert ll.isPalindromo();

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        assert !ll.isPalindromo();

        ll = new LinkedList();
        ll.addLast(1);
        assert ll.isPalindromo();

        ll = new LinkedList();
        assert ll.isPalindromo();

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(2);
        assert !ll.isPalindromo();
    }

    public void testRemoveLastOccurrence() {
        LinkedList ll = new LinkedList();

        assert !ll.removeLastOccurrence(5);

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(4);

        assert ll.removeLastOccurrence(2);
        assert ll.toString().equals("1, 2, 3, 4");

        assert ll.removeLastOccurrence(2);
        assert ll.toString().equals("1, 3, 4");

        assert !ll.removeLastOccurrence(2);
        assert ll.toString().equals("1, 3, 4");

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);

        assert ll.removeLastOccurrence(1);
        assert ll.toString().equals("1, 2");
        assert ll.getLast() == 2;

        ll = new LinkedList();
        ll.addLast(7);
        assert ll.removeLastOccurrence(7);
        assert ll.isEmpty();
    }

    public void testFilter() {
        LinkedList ll = new LinkedList();
        ll.addLast(5);
        ll.addLast(1);
        ll.addLast(8);
        ll.addLast(3);
        ll.addLast(9);
        ll.addLast(2);

        ll.filter(4);
        assert ll.toString().equals("5, 8, 9");
        assert ll.size() == 3;

        // valores iguais ao parâmetro também são removidos (só sobra o que é
        // estritamente maior)
        ll = new LinkedList();
        ll.addLast(4);
        ll.addLast(4);
        ll.addLast(5);

        ll.filter(4);
        assert ll.toString().equals("5");

        // nada é maior que o parâmetro: lista fica vazia
        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        ll.filter(10);
        assert ll.isEmpty();

        // tudo já é maior: lista não muda
        ll = new LinkedList();
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);

        ll.filter(1);
        assert ll.toString().equals("5, 6, 7");

        ll = new LinkedList();
        ll.filter(3);
        assert ll.isEmpty();
    }

    public static void main(String[] args) {
        LinkedListAsserts tests = new LinkedListAsserts();

        tests.testIsEmpty();
        tests.testLastIndexOf();
        tests.testToString();
        tests.testListGet();
        tests.testListGetFirst();
        tests.testListGetLast();
        tests.testListIndexOf();
        tests.testListRemoveFirst();
        tests.testListRemoveLast();
        tests.testListRemove();
        tests.testListRemoveByValue();
        tests.testLLAddLast();
        tests.testListAddFirst();
        tests.testLinkedListAdd();
        tests.testMoveToHead();
        tests.testInsereOrdenado();
        tests.testSwap();
        tests.testInverte();
        tests.testToStringReverso();
        tests.testRemoveAll();
        tests.testToArray();
        tests.testMeio();
        tests.testIsPalindromo();
        tests.testRemoveLastOccurrence();
        tests.testFilter();
    }

}
