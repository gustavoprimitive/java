import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ejecutaPinFuerzaBruta {

	static int numDigitos = 4;
	static String pin = "";	
	static String patron = "^[0-9]{" + numDigitos + "}$"; 
	
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub		
		
		Scanner sc = new Scanner(System.in);
		
		while (!Pattern.matches(patron, pin)) {			
			System.out.print("Código PIN (" + numDigitos + " dígitos numéricos enteros): ");
			pin = sc.next();
			Pattern.matches(patron, pin);
		}
				
		PinFuerzaBruta myPinFuerzaBruta = new PinFuerzaBruta(pin);
		myPinFuerzaBruta.permute();
		
		sc.close();
		
	}	
}