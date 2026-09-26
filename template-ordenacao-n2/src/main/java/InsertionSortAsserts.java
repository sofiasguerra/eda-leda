
public class InsertionSortAsserts {

    public void insereUltimoOrdenado() {
        InsertionSort sorting = new InsertionSort();
        int[] v;

        v = new int[]{1, 2, 3, 4, 5, 6, -1};
        sorting.insereUltimoOrdenado(v);
        assert java.util.Arrays.equals(new int[]{-1, 1, 2, 3, 4, 5, 6}, v);

        v = new int[]{1, 1, 1, 0};
        sorting.insereUltimoOrdenado(v);
        assert java.util.Arrays.equals(new int[]{0, 1, 1, 1}, v);

        v = new int[]{1, -1};
        sorting.insereUltimoOrdenado(v);
        assert java.util.Arrays.equals(new int[]{-1, 1}, v);

        v = new int[]{10, 20, 30, 40, 25};
        sorting.insereUltimoOrdenado(v);
        assert java.util.Arrays.equals(new int[]{10, 20, 25, 30, 40}, v);
    }

    public void inserePrimeiroOrdenado() {
        InsertionSort sorting = new InsertionSort();
        int[] v;

        v = new int[]{4, 1, 2, 3};
        sorting.inserePrimeiroOrdenado(v);
        assert java.util.Arrays.equals(v, new int[]{1, 2, 3, 4});

        v = new int[]{10, 2, 5};
        sorting.inserePrimeiroOrdenado(v);
        assert java.util.Arrays.equals(v, new int[]{2, 5, 10});

        v = new int[]{1, -1};
        sorting.inserePrimeiroOrdenado(v);
        assert java.util.Arrays.equals(v, new int[]{-1, 1});

        v = new int[]{25, 10, 20, 30, 40};
        sorting.inserePrimeiroOrdenado(v);
        assert java.util.Arrays.equals(v, new int[]{10, 20, 25, 30, 40});
    }

    public void sort() {
        InsertionSort sorting = new InsertionSort();
        int[] v;

        // já ordenado
        v = new int[]{1, 2, 3, 4, 5};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{1, 2, 3, 4, 5});

        // limite final
        v = new int[]{1, 2, 3, 4, 5, -1};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{-1, 1, 2, 3, 4, 5});

        // limite inicial
        v = new int[]{10, 1, 2, 3, 4, 5};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{1, 2, 3, 4, 5, 10});

        // limite final, meio
        v = new int[]{10, 20, 30, 40, 50, 15};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{10, 15, 20, 30, 40, 50});

        // limite inicio, meio
        v = new int[]{45, 10, 20, 30, 40, 50};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{10, 20, 30, 40, 45, 50});

        // reverso
        v = new int[]{5, 4, 3, 2, 1};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{1, 2, 3, 4, 5});

        // um elemento
        v = new int[]{5};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{5});

        v = new int[]{5, 1, 25, 2, -9, 10};
        sorting.sort(v);
        assert java.util.Arrays.equals(v, new int[]{-9, 1, 2, 5, 10, 25});
    }

    public void sortRecursivo() {
        InsertionSort sorting = new InsertionSort();
        int[] v;

        // já ordenado
        v = new int[]{1, 2, 3, 4, 5};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{1, 2, 3, 4, 5});

        // limite final
        v = new int[]{1, 2, 3, 4, 5, -1};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{-1, 1, 2, 3, 4, 5});

        // limite inicial
        v = new int[]{10, 1, 2, 3, 4, 5};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{1, 2, 3, 4, 5, 10});

        // limite final, meio
        v = new int[]{10, 20, 30, 40, 50, 15};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{10, 15, 20, 30, 40, 50});

        // limite inicio, meio
        v = new int[]{45, 10, 20, 30, 40, 50};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{10, 20, 30, 40, 45, 50});

        // reverso
        v = new int[]{5, 4, 3, 2, 1};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{1, 2, 3, 4, 5});

        // um elemento
        v = new int[]{5};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{5});

        v = new int[]{5, 1, 25, 2, -9, 10};
        sorting.sortRecursivo(v);
        assert java.util.Arrays.equals(v, new int[]{-9, 1, 2, 5, 10, 25});
    }

    public static void main(String[] args) {
        new InsertionSortAsserts().insereUltimoOrdenado();
        new InsertionSortAsserts().inserePrimeiroOrdenado();
        new InsertionSortAsserts().sort();
        new InsertionSortAsserts().sortRecursivo();
    }

}