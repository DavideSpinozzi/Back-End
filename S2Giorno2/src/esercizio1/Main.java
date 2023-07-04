package esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		 Set<String> wordSet = new HashSet<>();
	        Set<String> duplicateSet = new HashSet<>();

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Inserisci il numero di parole da inserire: ");
	        int N = scanner.nextInt();

	        System.out.println("Inserisci le " + N + " parole:");

	        for (int i = 0; i < N; i++) {
	            String word = scanner.next();

	            if (!wordSet.add(word)) {
	                duplicateSet.add(word);
	            }
	        }

	        System.out.println(" Parole duplicate:");
	        for (String duplicate : duplicateSet) {
	            System.out.println(duplicate);
	        }

	        System.out.println(" Numero di parole distinte: " + wordSet.size());

	        System.out.println(" Elenco delle parole distinte:");
	        for (String distinctWord : wordSet) {
	            System.out.println(distinctWord);
	        }
	    }
	}