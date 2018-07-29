package com.cuadrado;

import java.util.concurrent.ThreadLocalRandom;

public class GeneraCuadricula {

	//Valores posibles en cada fila o columna
	int[] enterosPosibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	//Array resultado
	int[][] cuadricula = new int[enterosPosibles.length][enterosPosibles.length];
	//Variables para el control de fin de posibilidades en la combinación
	boolean intentosValor1 = false;
	boolean intentosValor2 = false;
	boolean intentosValor3 = false;
	boolean intentosValor4 = false;
	boolean intentosValor5 = false;
	boolean intentosValor6 = false;
	boolean intentosValor7 = false;
	boolean intentosValor8 = false;
	boolean intentosValor9 = false;
	
	/**
	 * Genera un entero aleatorio entre los indicados en "enterosPosibles"
	 * @return
	 */
	private int generaEnteroAleatorio() {
		return ThreadLocalRandom.current().nextInt(1, enterosPosibles.length+1);
	}
	
	/**
	 * Método que ejecuta y controla la asignación de valores a las posiciones de la cuadrícula
	 */
	public void recorridoCuadricula() {
		
		int valor = 0;
		//Contadores de posición de fila y columna
		int x = 0;
		int y = 0;
		
		while (x < enterosPosibles.length) {
			while (y < enterosPosibles.length) { 
				//Reset de registro de posibilidades
				resetRegistroIntentos();
				valor = 0;
				//Obtención de entero para la posición actual
				while (valor == 0) {				
					valor = obtenerEnteroPosicion(x, y);
					//Si se han agotado las posibilidades de combinación se interrumpe el intento
					if (valor == 666) {
						System.out.println("\nAgotadas posibilidades al combinar enteros. Se lanza un nuevo intento.");
						pintadoCuadricula();
						limpiarCuadricula();
						x = 0;
						y = 0;
						break;
					}
				}				
				//Asignación a cuadrícula
				if (valor != 0 && valor != 666) { 
					cuadricula[x][y] = valor;
					//Incremento de contador de columna
					y++;
				}
				//Si se han agotado las posibilidades de combinación se interrumpe el intento
				if (valor == 666) {
					x = 0;
					y = 0;
					break;
				}
				//Incremento de contador de fila y reset del de columna 
				if (y == enterosPosibles.length) {
					y = 0;
					x++;
					if (x == enterosPosibles.length) {
						break;
					}
				}
			}
		}
		//Output de cuadricula
		System.out.println("\nResultado: ");
		pintadoCuadricula();
	}
	
	/**
	 * Output de cuadricula
	 */
	private void pintadoCuadricula() {
		
		String lineaCuadricula = "";
		
		for (int x = 0 ; x < enterosPosibles.length ; x++) {
			lineaCuadricula = "";
			for (int y = 0 ; y < enterosPosibles.length ; y++) {
				lineaCuadricula = lineaCuadricula + " " + cuadricula[x][y];				
			}
			System.out.println(lineaCuadricula);
		}
	}
	
	/**
	 * Borrado de valores de cuadricula: se sustituyen por ceros
	 */
	private void limpiarCuadricula() {
		for (int x = 0 ; x < enterosPosibles.length ; x++) {
			for (int y = 0 ; y < enterosPosibles.length ; y++) {
				cuadricula[x][y] = 0;
			}
		}
	}
	
	/**
	 * Verificación de que, en la posición recibida de la cuadrícula, el valor obtenido no se repite con los que comparten su fila o columna
	 * @param x
	 * @param y
	 * @return
	 */
	private int obtenerEnteroPosicion(int x, int y) {
		
		int enteroCandidato = generaEnteroAleatorio();
		int contadorOk = 0;

		for (int aux = 0 ; aux < enterosPosibles.length ; aux++) {
			if (cuadricula[x][aux] != enteroCandidato && cuadricula[aux][y] != enteroCandidato) {
				contadorOk++;
			}
		}
		
		if (contadorOk == enterosPosibles.length) {
			return enteroCandidato;
		}else {
			if (registroIntentos(enteroCandidato)) {					
				return 666;
			}else {
				return 0;
			}
			
		}
	}
	
	/**
	 * Control de fin de posibilidades en la combinación
	 * @param entero
	 * @return
	 */
	private boolean registroIntentos(int entero) {		
		
		//Se marca a true el entero recibido
		switch (entero) {
			case 1: intentosValor1 = true; break;
			case 2: intentosValor2 = true; break;
			case 3: intentosValor3 = true; break;
			case 4: intentosValor4 = true; break;
			case 5: intentosValor5 = true; break;
			case 6: intentosValor6 = true; break;
			case 7: intentosValor7 = true; break;
			case 8: intentosValor8 = true; break;
			case 9: intentosValor9 = true; break;			
		}
	
		//Devuelve true si se han empleado todos los enteros sin que haya combinación posible en la cuadrícula
		return intentosValor1 && intentosValor2 && intentosValor3 && intentosValor4 && intentosValor5 && intentosValor6 && intentosValor7
			&& intentosValor8 && intentosValor9;
	}
	
	/**
	 * Reset del control de fin de posibilidades en la combinación
	 */
	private void resetRegistroIntentos() {
		intentosValor1 = false;
		intentosValor2 = false;
		intentosValor3 = false;
		intentosValor4 = false;
		intentosValor5 = false;
		intentosValor6 = false;
		intentosValor7 = false;
		intentosValor8 = false;
		intentosValor9 = false;
	}
		
}

