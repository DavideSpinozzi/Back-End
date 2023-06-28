package giorno3.esercizio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci un numero intero");
		int x = scanner.nextInt();
		countdown(x);
		scanner.close();
	}

	public static void countdown(int x) {
		
		for(int i=x ;i>-1; i--) {
			
			System.out.println(i);
			
		}
	}
	
	
}
