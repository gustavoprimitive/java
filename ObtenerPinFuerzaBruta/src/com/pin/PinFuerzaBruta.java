package com.pin;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

public class PinFuerzaBruta {

	final char[] valoresPosibles = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	String pin;
	ArrayList<Character> auxConcat = new ArrayList<Character>();
	
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
	 * @param auxConcat2
	 * @return
	 */
	private String concatDigitos(ArrayList<Character> auxConcat) {
		String auxConcatCadena = "";
		
		for (Character val : auxConcat) {
			auxConcatCadena = auxConcatCadena + val;
		}
		return auxConcatCadena;
	}
	
	
	/**
	 * @throws UnknownHostException 
	 * 
	 */
	public void permute() throws UnknownHostException {		

		for (Character v1 : valoresPosibles) {
			for (Character v2 : valoresPosibles) {
				for (Character v3 : valoresPosibles) {
					for (Character v4 : valoresPosibles) {
						auxConcat.add(v1); auxConcat.add(v2); auxConcat.add(v3); auxConcat.add(v4);							
						if (compruebaCoincidencia(concatDigitos(auxConcat))) {
							System.out.println(loggerLine() + "Resuelto:\t" + v1 + "-" + v2 + "-" + v3 + "-" + v4);
							return;
						}else {
							System.out.println(loggerLine() + "Intento:\t" + v1 + "-" + v2 + "-" + v3 + "-" + v4);
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







