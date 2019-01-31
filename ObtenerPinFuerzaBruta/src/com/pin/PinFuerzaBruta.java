package com.pin;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

public class PinFuerzaBruta {

	final int[] enterosPosibles = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	String pin;
	ArrayList<Integer> auxConcat = new ArrayList<Integer>();
	
	/**
	 * @param pin
	 */
	public PinFuerzaBruta(String pin) {		
		this.pin = pin;
	}
	
	/**
	 * @param candidato
	 * @return
	 */
	private boolean compruebaCoincidencia(String candidato) {
		if (candidato.equals(pin)) {			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * @param digitos
	 * @return
	 */
	private String concatDigitos(ArrayList<Integer> digitos) {
		String auxConcat = "";
		
		for (int num : digitos) {
			auxConcat = auxConcat.concat(String.valueOf(num));
		}
		return auxConcat;
	}
	
	
	/**
	 * @throws UnknownHostException 
	 * 
	 */
	public void permute() throws UnknownHostException {		

		for (int n1 : enterosPosibles) {
			for (int n2 : enterosPosibles) {
				for (int n3 : enterosPosibles) {
					for (int n4 : enterosPosibles) {
						auxConcat.add(n1); auxConcat.add(n2); auxConcat.add(n3); auxConcat.add(n4);							
						if (compruebaCoincidencia(concatDigitos(auxConcat))) {
							System.out.println(loggerLine() + "Resuelto:\t" + n1 + "-" + n2 + "-" + n3 + "-" + n4);
							return;
						}else {
							System.out.println(loggerLine() + "Intento:\t" + n1 + "-" + n2 + "-" + n3 + "-" + n4);
							auxConcat.removeAll(auxConcat);
						}							
					}					
				}				
			}			
		}
	}
	
	/**
	 * @return
	 * @throws UnknownHostException
	 */
	private String loggerHost() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}


	/**
	 * @return
	 * @throws UnknownHostException
	 */
	private String loggerLine() throws UnknownHostException {
		Date timestamp = new Date();
		return (timestamp + "\t" + loggerHost() + "\t");
	}
	
}







