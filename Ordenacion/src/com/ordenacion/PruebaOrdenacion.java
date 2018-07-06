package com.ordenacion;

public class PruebaOrdenacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numerosDesordenados = new int[10];
		String outputDesordenados = "";
		
		//Generación de array de enteros aleatorios
		for (int i = 0 ; i < numerosDesordenados.length ; i++) {
			numerosDesordenados[i] = GeneracionNumerosAleatorios.numeroAleatorio(1, 10);
			outputDesordenados = outputDesordenados + " " + numerosDesordenados[i];	
		}
		System.out.println("Datos de entrada: " + outputDesordenados);
		
		//Ordenación
		OrdenacionBurbuja numerosOrdenados = new OrdenacionBurbuja();		
		System.out.println("Datos de entrada: " + numerosOrdenados.ordenar(numerosDesordenados));
	}
}
