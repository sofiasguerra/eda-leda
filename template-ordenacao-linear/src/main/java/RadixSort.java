public class RadixSort {

	// Você pode assumir que todos os valores possuem a mesma quantidade de dígitos
	// Caso precise do counting sort, use o que você já implementou na outra classe.
	public int[] radixSort(int[] v) {
		int nDig = ("" + v[0]).length();
		for(int i = 1; i <= nDig; i++){
			counting(v, i);
		}

		return v;
	}

	public void counting(int[] v, int i){
		int[] c = new int[10];
		int div = (int) Math.pow(10, i-1);
		int dig;
		for(int j = 0; j < v.length; j++){
			dig = (v[j]/div) % 10;
			c[dig]++;
		}

		for(int j = 1; j < c.length; j++){
			c[j] += c[j-1];
		}

		int[] b = new int[v.length];
		for(int j = b.length-1; j >= 0; j--){
			dig = (v[j]/div) % 10;
			b[c[dig]-1] = v[j];
			c[dig]--;
		}

		for(int j = 0; j < b.length; j++){
			v[j] = b[j];
		}
	}

}