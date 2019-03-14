package com.pin;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PinFuerzaBruta {

	final char[] valoresPosibles = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	String pin;	
	ArrayList<Character> auxConcatPermute = new ArrayList<Character>();
	ArrayList<Character> auxConcatRevPermute = new ArrayList<Character>();
	Date comienzoEjec;
	boolean esfinEjec = false;

	
	/**
	 * Constructor
	 * @param pin
	 */
	public PinFuerzaBruta(String pin) {		
		this.pin = pin;
	}
	
	/**
	 * Comprobación de cadena candidata y PIN
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
	 * Conversión de ArrayList a String
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
	 * Ejecución en paralelo de los métodos "permute" y "revPermute"
	 */
	public void execute(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        comienzoEjec = new Date();
        executorService.submit(() -> {
			try {
				permute();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		});
        executorService.submit(() -> {
			try {
				revPermute();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		});

        executorService.shutdown();
    }

	
	/**
	 * Permutación de valores
	 * @throws UnknownHostException 
	 * 
	 */
	private void permute() throws UnknownHostException {		

		for (Character v1 : valoresPosibles) {
			for (Character v2 : valoresPosibles) {
				for (Character v3 : valoresPosibles) {
					for (Character v4 : valoresPosibles) {
						auxConcatPermute.add(v1); auxConcatPermute.add(v2); auxConcatPermute.add(v3); auxConcatPermute.add(v4);							
						//System.out.println(loggerLine() + "Intento:\t" + v1 + "-" + v2 + "-" + v3 + "-" + v4);
						if (compruebaCoincidencia(concatDigitos(auxConcatPermute)) || esfinEjec) {
							if (!esfinEjec) {
								finEjec(v1, v2, v3, v4);
							}
							return;
						}else {							
							auxConcatPermute.removeAll(auxConcatPermute);
						}							
					}					
				}				
			}			
		}
	}
	
	
	/**
	 * Permutación de valores en orden inverso
	 * @param exec
	 * @throws UnknownHostException
	 */
	private void revPermute() throws UnknownHostException {		

		for (int i1=valoresPosibles.length-1; i1>=0; i1--) {
			char v1 = valoresPosibles[i1];
			for (int i2=valoresPosibles.length-1; i2>=0; i2--)  {
			char v2 = valoresPosibles[i2];
				for (int i3=valoresPosibles.length-1; i3>=0; i3--) {
				char v3 = valoresPosibles[i3];
					for (int i4=valoresPosibles.length-1; i4>=0; i4--) {
					char v4 = valoresPosibles[i4];
					auxConcatRevPermute.add(v1); auxConcatRevPermute.add(v2); auxConcatRevPermute.add(v3); auxConcatRevPermute.add(v4);							
						//System.out.println(loggerLine() + "Intento:\t" + v1 + "-" + v2 + "-" + v3 + "-" + v4);
						if (compruebaCoincidencia(concatDigitos(auxConcatRevPermute)) || esfinEjec) {
							if (!esfinEjec) {
								finEjec(v1, v2, v3, v4);
							}
							return;
						}else {							
							auxConcatRevPermute.removeAll(auxConcatRevPermute);
						}							
					}					
				}				
			}			
		}
	}	
	
	/**
	 * Output de fin de ejecución
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param v4
	 * @throws UnknownHostException
	 */
	private void finEjec(char v1, char v2, char v3, char v4) throws UnknownHostException {
		System.out.println(loggerLine() + "Resuelto:\t" + v1 + "-" + v2 + "-" + v3 + "-" + v4 + " (desde hilo " + Thread.currentThread().getId() + ")");
		loggerSegEjec();
		esfinEjec = true;			
	}
	
	/**
	 * Nombre de host para traza de output
	 * @return
	 * @throws UnknownHostException
	 */
	private String loggerHost() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}

	/**
	 * Tiempo de ejecución
	 */
	private void loggerSegEjec() {
		Date finEjec= new Date();
		long diferenciaMs = Math.abs(finEjec.getTime() - comienzoEjec.getTime());
		long diferenciaSs = diferenciaMs / 1000; 
		System.out.println(diferenciaSs + " segundos " + (diferenciaMs - (diferenciaSs) * 1000) + " milisegundos");
	}

	/**
	 * Fecha y hora para traza de output
	 * @return
	 * @throws UnknownHostException
	 */
	public String loggerLine() throws UnknownHostException {
		Date timestamp = new Date();
		return (timestamp + "\t" + loggerHost() + "\tThreads: " + Thread.activeCount() + "\t");
	}
	
}







