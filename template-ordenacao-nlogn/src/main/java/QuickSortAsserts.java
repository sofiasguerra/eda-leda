import java.util.Arrays;

public class QuickSortAsserts {

    public static void main(String[] args) {
      QuickSortAsserts q = new QuickSortAsserts();
        q.testMediana();
        q.testMedianaDeTres();
        q.testSort();

        System.out.println("\n todos os testes passaram!");
    }

    public void testMediana(){
        QuickSort qs = new QuickSort();
        int[] a;

        a = new int[]{5, 1, 2, 4, 3};
        assert qs.mediana(a) == 3;

        a = new int[]{-1, 0, 5, 2, 1, 9, -3}; 
        assert qs.mediana(a) == 1;

        a = new int[]{5, 6, 2}; 
        assert qs.mediana(a) == 5;

        a = new int[]{2}; 
        assert qs.mediana(a) == 2;
    }

    public void testMedianaDeTres(){
        QuickSort qs = new QuickSort();
        int[] a;

        a = new int[]{5, 1, 2, 4, 3, 10};
        assert qs.medianaDeTres(a) == 5;

        a = new int[]{-1, 0, 5, 2, 1, 9, -3}; 
        assert qs.medianaDeTres(a) == -1;

        a = new int[]{5, 6, 2}; 
        assert qs.medianaDeTres(a) == 5;

        a = new int[]{2}; 
        assert qs.medianaDeTres(a) == 2;
    }

    public void testSort(){
        QuickSort qs = new QuickSort();
        int[] a;

        a = new int[]{5, 1, 2, 4, 3, 10};
        qs.sort(a, 0, a.length-1);
        assert Arrays.equals(a, new int[]{1,2,3,4,5,10});

        a = new int[]{9,8,7,6,5,4,3,2,1,0};
        qs.sort(a, 0, a.length-1);
        assert Arrays.equals(a, new int[]{0,1,2,3,4,5,6,7,8,9});

        a = new int[]{5,2,1,9,-10,-7,63};
        qs.sort(a, 0, a.length-1);
        assert Arrays.equals(a, new int[]{-10,-7,1,2,5,9,63});

        a = new int[]{1};
        qs.sort(a, 0, a.length-1);
        assert Arrays.equals(a, new int[]{1});
    }
}