package giorno2.esercizio1;

public class Main {

	public static void main(String[] args) {

		Rettangolo rettangolo1 = new Rettangolo(34 , 20);
		Rettangolo rettangolo2 = new Rettangolo(15 , 60);
		
		stampaDueRettangoli( rettangolo1 , rettangolo2);
	}

	public static void stampaRettangolo(Rettangolo oggetto) {
		
		System.out.println("Area: " + oggetto.area());
		System.out.println("Perimetro: " + oggetto.perimetro());
		
	}
	
	public static void stampaDueRettangoli(Rettangolo oggetto1, Rettangolo oggetto2) {
		
		stampaRettangolo(oggetto1);
		System.out.println();
		stampaRettangolo(oggetto2);
		System.out.println();
		
		System.out.println("La somma delle aree dei due rettangoli e: " + oggetto1.area() + oggetto2.area());
		System.out.println("La somma dei perimetri dei due rettangoli e: " + oggetto1.perimetro() + oggetto2.perimetro());
		
	}
	
}
