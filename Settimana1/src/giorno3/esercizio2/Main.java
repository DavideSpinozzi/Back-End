package giorno3.esercizio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int counter = 0;
	
			System.out.println("Inserisci un numero compreso tra 0 e 3");
            counter= scanner.nextInt();
            switch(counter) {
		
            case 1: 
            	System.out.println("uno");
            	break;
            case 2: 
            	System.out.println("due");
            	break;
            default:
                System.out.println("non e un valore compreso tra 0 e 3");
                break;
	}
	
	}
}
