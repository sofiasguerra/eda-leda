public class SelectionSort implements SortingStrategy {

    private void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
    /**
    * Ordena um array de inteiros utilizando o selection sort.
    */
    public void sort(int[]v){
        for(int i = 0; i < v.length; i++){
           
            int iMenor = i;
            for(int j = i+1; j < v.length; j++)
                if(v[j] < v[iMenor]) iMenor = j;
        
            swap(v, i, iMenor);
        }
    }

    /**  public void sort(int[] v) {
        for(int i = 0; i < v.length; i++){
            int iMenor = i;
            int iMaior = v.length-1-i;
            if(iMenor > iMaior) return;

            for(int j = i+1; j < v.length-1-i; j++){
                if (v[iMenor] > v[j]){
                    iMenor = j;
                }
                if(v[iMaior] < v[j]){
                    iMaior = j;
                }
            }
            swap(v, i, iMenor);
            if(iMaior == i)
                iMaior = iMenor;

            swap(v, v.length-1-i, iMaior);
        }
    }   
    */

    /**
    * Ordena um array de inteiros utilizando o selection sort de maneira recursiva.
    * Pense que selection sort são várias execuções da atividade de procurar 
    * o menor e colocá-lo em seu lugar. Use essa estratégia chamando recursivamente. 
    * Você não pode mudar a assinatura desse método, mas pode/deve criar outros
    * métodos para te auxiliar na recursão.
    */
    public void sortRecursivo(int[] v) {
        sortRec(v, 0);
    }
    
    private void sortRec(int[] v, int ini){
        if(ini > v.length-1) return;
        int iMenor = ini;
        for(int j = ini+1; j < v.length; j++){
            if(v[j] < v[iMenor])
                iMenor = j;
        }
        swap(v, iMenor, ini);
        sortRec(v, ini+1);
    }
}

