package com.ordenacion;

public class PruebaOrdenacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int numEnterosArray = 10;
		final int valorMinimoRango = 1;
		final int valorMaximoRango = 20;		
		
		//Construcción array a ordenar
		GeneracionNumerosAleatorios enterosDesordenados = new GeneracionNumerosAleatorios();		
		System.out.println("Datos de entrada:\t" + enterosDesordenados.generaArrayEnterosAleatorios(numEnterosArray, valorMinimoRango, valorMaximoRango));
		
		//Construcción de array ordenado
		OrdenacionBurbuja enterosOrdenados = new OrdenacionBurbuja();		
		System.out.println("Datos de salida:\t" +  enterosOrdenados.ordenar(enterosDesordenados.arrayEnterosAleatorios));
		
	}
}
