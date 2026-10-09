
public class MergeSort implements SortingStrategy {

    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma crescente
    * e retorna um novo array também ordenado em forma crescente.
    */
    public int[] mergeOrdenadosCrescente(int[] a, int[] b) {
         int[] resp = new int[a.length + b.length];
         int idxA = 0;
         int idxB = 0;
         int i = 0;
        while(idxA < a.length && idxB < b.length){
            if(a[idxA] <= b[idxB]) resp[i++] = a[idxA++];
            else resp[i++] = b[idxB++];
         }

        while(idxA < a.length)
            resp[i++] = a[idxA++];

        while(idxB < b.length)
            resp[i++] = b[idxB++];

        return resp;
    }
    
    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma decrescente
    * e retorna um novo array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDecrescente(int[] a, int[] b) {
        int[] resp = new int[a.length + b.length];
        int iA = a.length-1;
        int iB = b.length-1;
        int i = 0;
        while(iA >= 0 && iB >= 0){
            if(a[iA] <= b[iB]) resp[i++] = a[iA--];
            else resp[i++] = b[iB--];
        }

        while(iA >= 0)
            resp[i++] = a[iA--];
        
        while(iB >= 0)
            resp[i++] = b[iB--];

        return resp;
    }
   
    /**
    * Implemente o método abaixo, que recebe dois arrays: a, ordenado em forma crescente e b, ordenado
    * em forma descrescente. Seu método deve retornar um array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDistintos(int[] a, int[] b) {
        int[] resp = new int[a.length+b.length];
        int iA = 0;
        int iB = b.length-1;
        int i = 0;
        while(iA < a.length && iB >= 0){
            if(a[iA] <= b[iB]) resp[i++] = a[iA++];
            else resp[i++] = b[iB--];
        }

        while(iA < a.length)
            resp[i++] = a[iA++];

        while(iB >= 0)
            resp[i++] = b[iB--];

        return resp;
    }
   
    /**
    * Implemente a versão clássica do merge sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public void sort(int[] v, int ini, int fim) {
        if(ini >= fim) return;
        int meio = (ini+fim)/2;
        sort(v, ini, meio);
        sort(v, meio+1, fim);
        merge(v, ini, fim);
    }

    private void merge(int[] v, int ini, int fim){
        int idxFimHelper = fim-ini;
        int[] helper = new int[idxFimHelper+1];
        for(int x = 0; x < helper.length; x++){
            helper[x] = v[x+ini];
        }

        int meioHelper = idxFimHelper/2;
        int i = 0;
        int j = meioHelper+1;
        int k = ini;
        while(i <= meioHelper && j <= idxFimHelper){
            if(helper[i] <= helper[j]) v[k++] = helper[i++];
            else v[k++] = helper[j++];
        }
        while(i <= meioHelper)
            v[k++] = helper[i++];
    }
}
       
