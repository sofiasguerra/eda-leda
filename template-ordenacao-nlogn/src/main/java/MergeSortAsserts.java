import java.util.Arrays;

public class MergeSortAsserts {

    public static void main(String[] args) {
        MergeSortAsserts m = new MergeSortAsserts();

    }

    public void testMergeOrdenadosCrescente(){
        MergeSort merg = new MergeSort();
        int[] a;
        int[] b;
        int[] resulEsperado;

        a = new int[]{20, 32, 33, 45, 99};
        b = new int[]{1, 23, 24, 32, 36, 48, 98, 100};
        resulEsperado = new int[]{1, 20, 23, 24, 32, 32, 33, 36, 45, 48, 98, 99, 100};
        assert merg.mergeOrdenadosCrescente(a, b) == resulEsperado;

        a = new int[]{1};
        b = new int[]{2};
        assert merg.mergeOrdenadosCrescente(a, b) == new int[]{1, 2};
    }

    public void testMergeOrdenadosDecrescente(){
        MergeSort merg = new MergeSort();
        int[] a;
        int[] b;

        a = new int[]{9, 6, 4, 2, -2, -5, -10};
        b = new int[]{5, 3, 1, 0, -1, -6};
        assert Arrays.equals(merg.mergeOrdenadosDecrescente(a, b), new int[]{0,1,2,3,4,5,6,7,8,9});

        a = new int[]{1};
        b = new int[]{2};
        assert merg.mergeOrdenadosDecrescente(a, b) == new int[]{1, 2};
    }

    public void testMergeOrdenadosDistintos(){
        MergeSort merg = new MergeSort();
        int[] a;
        int[] b;

        a = new int[]{1,2,4,5,8,10,12};
        b = new int[]{15,9,7,6,5,3,-4,-5};
        assert Arrays.equals(merg.mergeOrdenadosDistintos(a, b), new int[]{-5,-4,1,2,3,4,5,5,6,7,8,9,10,12,15});

        a = new int[]{1};
        b = new int[]{2};
        assert merg.mergeOrdenadosDistintos(a, b) == new int[]{1, 2};
    }

    public void testSort(){
        MergeSort merg = new MergeSort();
        int[] v;

        v = new int[]{8, 1, 78, 45, 3, 2, 103};
        merg.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{1, 2, 3, 8, 45, 78, 103});

        v = new int[]{2};
        merg.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{2});

        v = new int[]{1, 2, 3, -4};
        merg.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{-4, 1, 2, 3});

        v = new int[]{10, 2, 3, 4};
        merg.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{2, 3, 4, 10});
    }
}
 