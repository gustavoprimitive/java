package com.ordenacion;

import java.util.concurrent.ThreadLocalRandom;

public class GeneracionNumerosAleatorios {
	
	/**
	 * Genera un numérico aleatoriamente dentro del rango minimo-maximo
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static int numeroAleatorio(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo);
	}		
}
