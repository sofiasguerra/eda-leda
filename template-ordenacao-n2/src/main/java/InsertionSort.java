public class InsertionSort implements SortingStrategy {
    
    private void swap(int[] v, int i, int j){
    int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    /**
    * O array  está ordenado exceto pelo último elemento. Esse método
    * deve colocar o último elemento em sua posição.
    * Importante: seu algoritmo deve ser O(n).
    */
    public void insereUltimoOrdenado(int[] v) {
        int i = v.length-1;
        while(i > 0 && v[i] < v[i-1]){
            swap(v, i-1, i);
            i--;
        }
    }
   
    /**
    * O array  está ordenado exceto pelo primeiro elemento. Esse método
    * deve colocar o primeiro elemento em sua posição. Ao final da execução,
    * v deve estar ordenado.
    * Importante: seu algoritmo deve ser O(n);
    */
    public void inserePrimeiroOrdenado(int[] v) {
        int i = 0;
        while(i < v.length-1 && v[i] > v[i+1]){
            swap(v, i, i+1);
            i++;
        }
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort.
    */
    public void sort(int[] v) {
        for(int i = 1; i < v.length; i++){
            int j = i;
            while(j > 0 && v[j-1] > v[j]){
                swap(v, j-1, j);
                j--;
            }
        }
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort de maneira recursiva.
    * Pense que insertion sort são várias execuções da inserção ordenada e use
    * essa estratégia chamando recursivamente. 
    * Você não pode mudar a assinatura desse método, mas pode/deve criar outros
    * métodos para te auxiliar na recursão.
    */
    public void sortRecursivo(int[] v) {
        sortRec(v, v.length);
    }  

    private void sortRec(int[] v, int n){
        if (n <= 1) return;
        sortRec(v, n-1);
        trocaInsertion(v, n-1);
    }

    private void trocaInsertion(int[] v, int i){
        int j = i;
        while(j > 0 && v[j] < v[j-1]){
            swap(v, j-1, j);
            j--;
        }
    }
}
