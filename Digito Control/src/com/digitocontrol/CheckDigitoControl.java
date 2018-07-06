package com.digitocontrol;

public class CheckDigitoControl {

	public static void main(String[] args) {
		
		ValidaDigitoControl strIccidProbar = new ValidaDigitoControl("6021300345596"); 					
		System.out.println(strIccidProbar.validar());
	}
}	