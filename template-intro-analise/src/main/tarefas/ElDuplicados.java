
import java.io.*;
import java.util.*;

public class ElDuplicados {


	// Gera uma entrada de pior caso: N números distintos, sem repetição
	public static String[] gerarEntradaPiorCaso(int n) {
        String[] entrada = new String[n];
        	for (int i = 0; i < n; i++) {
            	entrada[i] = Integer.toString(i);
        }
        	return entrada;
   	 }

	public static void main(String[] args) {
        	int[] tamanhos = {100, 500, 1000, 2000, 5000, 10000, 20000, 50000, 80000, 100000};

        	System.out.println("alg time sample");

        	for (int n : tamanhos) {
            		String[] entrada = gerarEntradaPiorCaso(n);

            		long inicioFor = System.nanoTime();
            		duplicadosFor(entrada);
            		long tempoFor = System.nanoTime() - inicioFor;
            		System.out.println("duplicadosFor " + tempoFor + " " + n);

            		long inicioSet = System.nanoTime();
            		duplicadosSet(entrada);
            		long tempoSet = System.nanoTime() - inicioSet;
            		System.out.println("duplicadosSet " + tempoSet + " " + n);
       		}
    	}	

        public static boolean duplicadosFor(String[] lista) {
        	for(int i = 0; i < lista.length-1; i++) {
        		for(int j = i+1; j < lista.length; j++) {
        			if(lista[i].equals(lista[j])) {
        				return true;
        			}
        		}
        	}
        	return false;
        }

        public static boolean duplicadosSet(String[] lista) {
        	HashSet<String> listaSet = new HashSet<>();
        	for(int i = 0; i < lista.length; i++) {
        		if(listaSet.contains(lista[i])) {
        			return true;
        		}
        		listaSet.add(lista[i]);
        	}
        	return false;
        }
}

