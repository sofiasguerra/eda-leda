
public class MergeSort implements SortingStrategy {

    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma crescente
    * e retorna um novo array também ordenado em forma crescente.
    */
    public int[] mergeOrdenadosCrescente(int[] a, int[] b) {
        int[] arr = new int[a.length + b.length];
        
        int menor = 0;
        if(a.length < b.length){
            menor = a.length;
        } else{
            menor = b.length;
        }

        int k = 0, iA = 0, iB = 0;
        while(iA < a.length && iB < b.length){
            if(a[iA] <= b[iB]){
                arr[k++] = a[iA++];
            } else {
                arr[k++] = b[iB++];
            }
        }

        while(iA < a.length){
            arr[k++] = a[iA++];
        }

        while(iB < b.length){
            arr[k++] = b[iB++];
        }
        return arr;
    }
    
    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma decrescente
    * e retorna um novo array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDecrescente(int[] a, int[] b) {
       int[] arr = new int[a.length + b.length];

       int k = 0, iA = a.length-1, iB = b.length-1;
       while(iA >= 0 && iB >= 0){
        if(a[iA] < b[iB])
            arr[k++] = a[iA--];
        else 
            arr[k++] = b[iB--];
       }

       while(iA >= 0)
        arr[k++] = a[iA--];

       while(iB >=0)
        arr[k++] = b[iB--];

    return arr;
    }
   
    /**
    * Implemente o método abaixo, que recebe dois arrays: a, ordenado em forma crescente e b, ordenado
    * em forma descrescente. Seu método deve retornar um array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDistintos(int[] a, int[] b) {
       int[] arr = new int[a.length + b.length];

       int k = 0, iA = 0, iB = b.length-1;
       while(iA < a.length && iB >= 0){
        if(a[iA] < b[iB])
            arr[k++] = a[iA++];
        else 
            arr[k++] = b[iB--];
       }

       while(iA < a.length)
        arr[k++] = a[iA++];

       while(iB >=0)
        arr[k++] = b[iB--];

    return arr;
    }
   
    /**
    * Implemente a versão clássica do merge sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public void sort(int[] v, int ini, int fim) {
        if (ini < fim){
            int meio = (ini + fim)/2;
            sort(v, ini, meio);
            sort(v, meio +1, fim);
            merge(v, ini, fim);
        }
    }

    private void merge(int[] v, int ini, int fim){
        int tam = fim - ini;
        int[] helper = new int[tam+1];
        for(int i = 0; i <= tam; i++){
            helper[i] = v[ini + i];
        }

        int middleHelper = tam/2;
        int i = 0;
        int j = middleHelper+1;
        int k = ini;
        while(i <= middleHelper && j <= tam){
            if(helper[i] <= helper[j]){
                v[k++] = helper[i++];
            } else{
                v[k++] = helper[j++];
            }
        }

        while(i <= middleHelper){
            v[k++] = helper[i++];
        }
    }
}
