package com.ordenacion;

import java.util.concurrent.ThreadLocalRandom;

public class GeneracionNumerosAleatorios {
	
	public int[] arrayEnterosAleatorios;
	
	/**
	 * Genera array de N enteros dentro del rango indicado en los parámetros
	 * @param numeroPosiciones
	 * @param minimoRango
	 * @param maximoRango
	 * @return
	 */
	public String generaArrayEnterosAleatorios(int numeroPosiciones, int minimoRango, int maximoRango) {
		
		arrayEnterosAleatorios = new int[numeroPosiciones];
		
		for (int i = 0 ; i < arrayEnterosAleatorios.length ; i++) {
			arrayEnterosAleatorios[i] = generaNumeroAleatorio(minimoRango, maximoRango);
		}
		return generarOutput(arrayEnterosAleatorios);
	}
	
	/**
	 * Genera un numérico aleatoriamente dentro del rango minimo-maximo
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	private int generaNumeroAleatorio(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo);
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
