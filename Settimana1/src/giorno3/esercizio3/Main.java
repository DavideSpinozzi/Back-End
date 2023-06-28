package giorno3.esercizio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String x = "";
		while(!x.equals(":q")) {
			System.out.println("Inserisci una stringa");
		x = scanner.next();
		
		if(!x.equals(":q")) {
			virgola(x);}
		
		}
		scanner.close();
	}

	public static void virgola(String x) {
		String y = "";
		for (int i =0; i<x.length(); i++) {
			y += x.charAt(i) + ",";
		}
		System.out.println(y);
	}
	
}
