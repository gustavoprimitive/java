import java.util.Scanner;
import java.util.regex.Pattern;

public class ejecutaPinFuerzaBruta {

	static String pin = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Scanner sc = new Scanner(System.in);
		
		while (!Pattern.matches("^[0-9]{4}$", pin)) {			
			System.out.print("Código PIN (4 dígitos numéricos enteros): ");
			pin = sc.next();
			Pattern.matches("^[0-9]{4}$", pin);
		}
				
		PinFuerzaBruta myPinFuerzaBruta = new PinFuerzaBruta(pin);
		myPinFuerzaBruta.permute();
		
		sc.close();
		
	}
}