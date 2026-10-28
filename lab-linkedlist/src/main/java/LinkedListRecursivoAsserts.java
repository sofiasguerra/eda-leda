public class LinkedListRecursivoAsserts {

    public void testIsEmpty() {
        LinkedListRecursivo ll = new LinkedListRecursivo();
        assert ll.isEmpty();

        ll.addLast(1);
        assert !ll.isEmpty();
    }

    public void testSize() {
        LinkedListRecursivo ll = new LinkedListRecursivo();
        assert ll.size() == 0;

        ll.addLast(1);
        assert ll.size() == 1;

        ll.addLast(2);
        ll.addLast(3);
        assert ll.size() == 3;
    }

    public void testSum() {
        LinkedListRecursivo ll = new LinkedListRecursivo();
        assert ll.sum() == 0;

        ll.addLast(5);
        assert ll.sum() == 5;

        ll.addLast(10);
        ll.addLast(-3);
        assert ll.sum() == 12;
    }

    public void testContains() {
        LinkedListRecursivo ll = new LinkedListRecursivo();
        assert !ll.contains(1);

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        assert ll.contains(1);
        assert ll.contains(2);
        assert ll.contains(3);
        assert !ll.contains(4);
    }

    public void testIndexOf() {
        LinkedListRecursivo ll = new LinkedListRecursivo();
        assert ll.indexOf(10) == -1;

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(10);

        assert ll.indexOf(10) == 0;
        assert ll.indexOf(20) == 1;
        assert ll.indexOf(99) == -1;
    }

    public void testMax() {
        LinkedListRecursivo ll = new LinkedListRecursivo();

        try {
            ll.max();
            assert false;
        } catch (Exception e) {}

        ll.addLast(7);
        assert ll.max() == 7;

        ll.addLast(3);
        ll.addLast(15);
        ll.addLast(9);
        assert ll.max() == 15;

        ll = new LinkedListRecursivo();
        ll.addLast(-5);
        ll.addLast(-2);
        ll.addLast(-9);
        assert ll.max() == -2;
    }

    public void testMin() {
        LinkedListRecursivo ll = new LinkedListRecursivo();

        try {
            ll.min();
            assert false;
        } catch (Exception e) {}

        ll.addLast(7);
        assert ll.min() == 7;

        ll.addLast(3);
        ll.addLast(15);
        ll.addLast(1);
        assert ll.min() == 1;

        ll = new LinkedListRecursivo();
        ll.addLast(-5);
        ll.addLast(-2);
        ll.addLast(-9);
        assert ll.min() == -9;
    }

    public void testToString() {
        LinkedListRecursivo ll = new LinkedListRecursivo();
        assert ll.toString().equals("");

        ll.addLast(1);
        assert ll.toString().equals("1");

        ll.addLast(2);
        ll.addLast(3);
        assert ll.toString().equals("1, 2, 3");
    }

    public void testCount() {
        LinkedListRecursivo ll = new LinkedListRecursivo();
        assert ll.count(1) == 0;

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(1);

        assert ll.count(1) == 3;
        assert ll.count(2) == 1;
        assert ll.count(9) == 0;
    }

    public void testGet() {
        LinkedListRecursivo ll = new LinkedListRecursivo();

        try {
            ll.get(0);
            assert false;
        } catch (IndexOutOfBoundsException e) {}

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);

        assert ll.get(0).value == 10;
        assert ll.get(1).value == 20;
        assert ll.get(2).value == 30;

        try {
            ll.get(-1);
            assert false;
        } catch (IndexOutOfBoundsException e) {}

        try {
            ll.get(3);
            assert false;
        } catch (IndexOutOfBoundsException e) {}
    }

    public static void main(String[] args) {
        LinkedListRecursivoAsserts tests = new LinkedListRecursivoAsserts();

        tests.testIsEmpty();
        tests.testSize();
        tests.testSum();
        tests.testContains();
        tests.testIndexOf();
        tests.testMax();
        tests.testMin();
        tests.testToString();
        tests.testCount();
        tests.testGet();

        System.out.println("\nTodos os testes passaram!!!");
    }

}