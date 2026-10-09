import java.util.*;

public class RadixSort {

	// Você pode assumir que todos os valores possuem a mesma quantidade de dígitos
	// Caso precise do counting sort, use o que você já implementou na outra classe.
	public int[] radixSort(int[] v) {
		 int dig = ("" + v[0]).length();
		
		for(int i = 1;  i <= dig; i++){
			counting(v, i);
		}
		return v;
	}

	public void counting(int[] a, int d){
		int[] c = new int[10];
		int exp = (int) Math.pow(10, d-1);
		int digito;
		for(int i = 0; i < a.length; i++){
			digito = (a[i]/exp) % 10;
			c[digito]++;
		}
		
		for(int i = 1; i < c.length; i++){
			c[i] += c[i-1];
		}
	
		int[] b = new int[a.length];
		for(int i = a.length-1; i >= 0; i--){
			digito = (a[i]/exp) % 10;
			b[c[digito]-1] = a[i];
			c[digito]--;
		}
		
		//Copia os el de B pra A;
		for(int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}

}