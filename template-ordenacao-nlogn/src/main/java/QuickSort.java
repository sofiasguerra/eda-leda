import java.util.Arrays;

public class QuickSort implements SortingStrategy {

  
    /*
       A mediana de uma sequência de tamanho ímpar é o valor que divide uma sequência ao meio, isto é, 
       metado dos valores são menores que ela, enquanto metade são maiores. Implemente o método abaixo
       que recebe uma sequência de tamanho ímpar e retorna a mediana dessa sequência.
    */
    public int mediana(int[] v) {
        Arrays.sort(v);
        int meio = v.length/2;
        return v[meio];
    }

    /**
    * Implemente a versão do quick sort usando o particionamento Hoare, que está descrito
    * neste material: https://joaoarthurbm.github.io/eda/posts/particionamento-hoare/
    */
    public void sort(int[] v, int ini, int fim) {
        if (ini < fim){
            int idxPivot = partitionHoare(v, ini, fim); 
            sort(v, ini, idxPivot-1);
            sort(v, idxPivot+1, fim);
        }
    }

    private int partitionHoare(int[] v, int ini, int fim) {
        int idxMediana = medianaDeTresPartition(v, ini, fim);
        swap(v, ini, idxMediana);
        int pivot = v[ini];
        int i = ini+1;
        int j = fim;
        while(i <= j){

            while(i<=j && v[i] <= pivot){
                i++;
        }
            while(i<=j && v[j] > pivot){
                j--;
            }

            if(i<j){
                swap(v, i, j);
            }
        }

        swap(v, ini, j);
        return j;
    }

    private int partitionLomuto(int[] v, int ini, int fim){
        int idxMediana = medianaDeTresPartition(v, ini, fim);
        swap(v, ini, idxMediana);
        int pivot = v[ini];
        int i = ini;
        for(int j = ini+1; j <= fim; j++){
            if(v[j] <= pivot){
                swap(v, ++i, j);
            }
        }
        swap(v, ini, i);
        return i;
    }

    private void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
        
    public int medianaDeTresPartition(int[] v, int ini, int fim) {
        int meio = (ini+fim)/2;
        int[] arr = {v[ini], v[meio], v[fim]};
        Arrays.sort(arr);

        if(arr[1] == v[ini]) return ini;
        else if(arr[1] == v[meio]) return meio;
        return fim;
    }

    /**
    * Nós discutimos em sala de aula que uma tentativa para melhorar a escolha do pivot é
    * decidir usar o valores mediano (não média, cuidado) entre o primeiro elemento do array,
    * o elemento central e o último.

    * Implemente o método abaixo que retorna o valor que seria escolhido como pivot seguindo
    * a abordagem acima.
    * 
    * Interprete os testes para saber qual valor usar como elemento central para calcular a mediana de três.
    */
    public int medianaDeTres(int[] v){
        int meio = (v.length-1)/2;
        int[] arr = {v[0], v[meio], v[v.length-1]};
        Arrays.sort(arr);

        return arr[1];
    }
}
