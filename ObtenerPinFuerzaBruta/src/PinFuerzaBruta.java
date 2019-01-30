import java.util.ArrayList;

public class PinFuerzaBruta {

	public final int[] enterosPosibles = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	public String pin;
	
	
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
	public boolean compruebaCoincidencia(String candidato) {
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
	public String concatDigitos(ArrayList<Integer> digitos) {
		String auxConcat = "";
		for (int num : digitos) {
			auxConcat = auxConcat.concat(String.valueOf(num));
		}
		return auxConcat;
	}
	
	
	/**
	 * 
	 */
	public void permute() {
		ArrayList<Integer> auxConcat = new ArrayList<Integer>();
		for (int n1 : enterosPosibles) {
			for (int n2 : enterosPosibles) {
				for (int n3 : enterosPosibles) {
					for (int n4 : enterosPosibles) {
						auxConcat.add(n1); auxConcat.add(n2); auxConcat.add(n3); auxConcat.add(n4);							
						if (compruebaCoincidencia(concatDigitos(auxConcat))) {
							System.out.println("Ok: " + n1 + "-" + n2 + "-" + n3 + "-" + n4);
							return;
						}else {
							System.out.println(n1 + "-" + n2 + "-" + n3 + "-" + n4);
							auxConcat.removeAll(auxConcat);
						}							
					}					
				}				
			}			
		}
	}
}

