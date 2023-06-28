package giorno3.esercizio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int counter = 0;

		while (counter != 3) {
			System.out.println("1: Stringa Pari e dispari  |  2: Anno bisestile  |  3: Esci");
            counter= scanner.nextInt();
            switch(counter) {
            
            case 1: 
            	System.out.println("Inserisci una stringa");
            	String x = scanner.next();
            	System.out.println(stringaPariDispari(x));
            	break;
            	
            case 2: 
            	System.out.println("Inserisci un anno");
            	int y = scanner.nextInt();
            	System.out.println(annoBisestile(y));
            	break;
            case 3:
            	counter = 3;
            	scanner.close();
            	break;
            }
            
		}

	}

	public static boolean stringaPariDispari(String stringa) {

		return stringa.length() % 2 == 0;

	}

	public static boolean annoBisestile(int anno) {

		if (anno % 4 == 0) {
			if (anno % 100 == 0) {
				if (anno % 400 == 0) {

					return true;

				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}