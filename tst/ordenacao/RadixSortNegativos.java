import java.util.*;

class RadixSortNegativos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ent = sc.nextLine().split(" ");

        int[] nums = new int[ent.length];
        for(int i = 0; i < ent.length; i++){
            nums[i] = Integer.parseInt(ent[i]);
        }

        System.out.println(Arrays.toString(RadixSortNegativos(nums)));

    }

    private static int[] RadixSortNegativos(int v[]){
        int idxSepara = particionaNegPosi(v);
        int tamPosi = v.length - idxSepara;
        int[] neg = new int[idxSepara];
        int[] posi = new int[tamPosi];

        copiaArr(neg, v, 0, idxSepara);
        copiaArr(posi, v, idxSepara, v.length);

        RadixSort(neg);
        RadixSort(posi);
        int[] negOrg = new int[neg.length];
        int j = 0;
        for(int i = neg.length-1; i >= 0; i--){
            negOrg[j++] = neg[i];
        }

        int[] resultado = new int[negOrg.length + posi.length];
        int k = 0;
        for (int i = 0; i < negOrg.length; i++) 
            resultado[k++] = negOrg[i];

        for (int i = 0; i < posi.length; i++) 
            resultado[k++] = posi[i];
        
        return resultado;
    }       

    private static void copiaArr(int[] arr, int[] v, int ini, int fim){
        int k = 0;
        for(int i = ini; i < fim; i++){
            arr[k++] = v[i];
        }
    }
    
    private static void RadixSort(int[] v){
        int nDig = ("" + numDigMaior(v)).length();
        for(int i = 1; i <= nDig; i++){
            couting(v, i);
        }
    }

    private static void couting(int[] A, int nDig){
        int[] C = new int[10];
        int exp = (int) Math.pow(10, nDig-1);
        int digito;
        //Contagem
        for(int i = 0; i < A.length; i++){
            digito = (Math.abs(A[i])/exp) % 10;
            C[digito]++;
        }

        //Cumulativa
        for(int i = 1; i < C.length; i++){
            C[i] += C[i-1];
        }

        //Ordenação
        int[] B = new int[A.length];
        for(int i = A.length-1; i >= 0; i--){
            digito = (Math.abs(A[i])/exp) % 10;
            B[C[digito]-1] = A[i];
            C[digito]--;
        }

        //Copia
        for(int i = 0; i < A.length; i++){
            A[i] = B[i];
        }
    }

    private static int particionaNegPosi(int[] v){
        int i = 0;
        int auxiliar;
        for(int j = 0; j < v.length; j++){
            if(v[j] < 0){
                auxiliar = v[j];
                v[j] = v[i];
                v[i++] = auxiliar;
            }
        }
        return i;
    }

    private static int numDigMaior(int[] v){
        int maior = 0;
        for(int i = 0; i < v.length; i++){
            if(maior < Math.abs(v[i]))
                maior = Math.abs(v[i]);
        }
        return maior;
    }
}
