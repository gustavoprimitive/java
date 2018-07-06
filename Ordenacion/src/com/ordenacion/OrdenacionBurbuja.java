package com.ordenacion;

public class OrdenacionBurbuja {

	/**
	 * Ordenación de valores contenidos en array recibido
	 * @param numeros
	 * @return
	 */
	public String ordenar(int[] numeros) {		
	    
	    for (int i = 0; i < numeros.length; i++) {
	        for (int j = 1; j < (numeros.length - i); j++) {
	            if (numeros[j - 1] > numeros[j]) {
	                int temp = numeros[j - 1];
	                numeros[j - 1] = numeros[j];
	                numeros[j] = temp;
	            }
	        }
	    }
	    return generarOutput(numeros);
	}

	/**
	 * Generación de cadena de output 
	 * @param numeros
	 * @return
	 */
	private String generarOutput(int[] numeros) {

	    String outputOrdenados = "";
	    
		for (int a = 0 ; a < numeros.length ; a++) {
	    	outputOrdenados = outputOrdenados + " " + numeros[a];	
	    }
		return outputOrdenados;
	}
}
