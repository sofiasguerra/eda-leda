import java.util.Arrays;

public class HeapAsserts {

    public void testLeft() {
        Heap heap = new Heap(15);

        heap.add(100);
        heap.add(90);
        heap.add(85);
        heap.add(30);
        heap.add(45);
        heap.add(60);
        heap.add(70);
        heap.add(20);

        assert heap.left(0) == 1;
        assert heap.left(2) == 5;
        assert heap.left(1) == 3;
    }

    public void testRight() {
        Heap heap = new Heap(15);

        heap.add(100);
        heap.add(90);
        heap.add(85);
        heap.add(30);
        heap.add(45);
        heap.add(60);
        heap.add(70);
        heap.add(20);
        heap.add(113);

        assert heap.right(0) == 2;
        assert heap.right(2) == 6;
        assert heap.right(1) == 4;
    }

    public void testParent() {
        Heap heap = new Heap(15);

        heap.add(100);
        heap.add(90);
        heap.add(85);
        heap.add(30);
        heap.add(45);
        heap.add(60);
        heap.add(70);
        heap.add(20);

        assert heap.parent(5) == 2;
        assert heap.parent(3) == 1;
        assert heap.parent(4) == 1;
    }

    public void testRemove() {
        int[] expected = new int[]{82, 65, 62, 45, 56, 52, 43, 30, 33, 38, 0, 0, 0, 0, 0};

        Heap heap = new Heap(15);

        for (int i = 0; i <= 9; i++) {
            heap.add(expected[i]);
        }

        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 82;
        expected = new int[]{65, 56, 62, 45, 38, 52, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 65;
        expected = new int[]{62, 56, 52, 45, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 62;
        expected = new int[]{56, 45, 52, 30, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 56;
        expected = new int[]{52, 45, 43, 30, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 52;
        expected = new int[]{45, 38, 43, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 45;
        expected = new int[]{43, 38, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 43;
        expected = new int[]{38, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 38;
        expected = new int[]{33, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 33;
        expected = new int[]{30, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 30;
        expected = new int[]{30, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));
    }

    public static void main(String[] args) {
        HeapAsserts tests = new HeapAsserts();

        tests.testLeft();
        tests.testRight();
        tests.testParent();
        tests.testRemove();

        System.out.println("\n TODOS OS TESTES DE HEAP PASSARAM!");
    }
    
}
