package com.digitocontrol;

import java.util.regex.Pattern;


public class ValidaDigitoControl {
	
	//ICCID recibido
	String strIccid;
	//Último dígito de ICCID (dígito de control)
	int intDCRecibido;
	//Cadena sin el dígito de control
	String iccidSinDigitoControl;
	
	/**
	 * Constructor
	 * @param strIccid
	 */
	public ValidaDigitoControl(String strIccid) {
		this.strIccid = strIccid;
	}
	
	/**
	 * Método de validación del dígito de control a partir del valor de ICCID
	 * @param strIccid
	 * @return
	 */
	public String validar() {
		
		//Mensajes a devolver
		final String MSG[] = {"La numeración " + strIccid + " de la tarjeta SIM es correcta",
				      "La numeración " + strIccid + " de la tarjeta SIM es incorrecta",
				      "La numeración " + strIccid + " de la tarjeta SIM es incorrecta",
				      "La longitud de la tarjeta SIM debe ser de 13 dígitos"}; 
		int intSuma = 0;
		
		//Si el valor recibido está formado por 13 valores numéricos
		if (strIccid.length() == 13) {
			//Si el valor está formado por numéricos
			if (Pattern.matches("^[0-9]+$", strIccid)) {		 

				//Cálculo
				for(int i = 1; i < iccidSinDigitoControl(strIccid).length()+1; i++) {

					int intDigito = extraeDigito(i, iccidSinDigitoControl(strIccid));
			
					//Si está en posición par se asigna el doble
					if (i%2 == 0) {
						intDigito = intDigito*2;

						//Si el nuevo valor tiene dos dígitos se suman entre sí
						if (intDigito >= 10) {
							intDigito = intDigito-9;
						}
					}			
					//Suma de dígitos
					intSuma = intSuma + intDigito;
				}
				//Se le suma 36
				intSuma = intSuma + 36;
								
				//Comparación de dígito de control calulado y recibido
				if (calculoDigitoControl(intSuma) == extraeDigito(strIccid.length(), strIccid)) {
					return MSG[0];
				} else {
					return MSG[1];
				}				
			} else {
				return MSG[2];
			}
		} else {
			return MSG[3];
		}
	}

	/**
	 * Extrae dígito en posición "i" de la cadena recibida
	 * @param i
	 * @param iccidSinDigitoControl
	 * @return
	 */
	private int extraeDigito(int i, String iccidSinDigitoControl) {
		return Integer.parseInt(iccidSinDigitoControl.substring(i-1, i));
	}

	/**
	 * Cálculo
	 * @param intSuma
	 * @return
	 */
	private int calculoDigitoControl(int intSuma) {
		return(intSuma*9)%10;
	}

	/**
	 * Genera subcadena obviando el último dígito 
	 * @param strIccid
	 * @return
	 */
	private String iccidSinDigitoControl(String strIccid) {
		return strIccid.substring(0, strIccid.length()-1);		
	}
}
