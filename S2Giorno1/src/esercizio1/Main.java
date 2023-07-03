package esercizio1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        int[] array = ThreadLocalRandom.current().ints(5, 1, 11).toArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Quale numero vuoi inserire?");
            int numero = scanner.nextInt();

            System.out.println("In quale posizione da 1 a 5 lo vuoi inserire? (Inserisci 0 per terminare)");
            int posizione = scanner.nextInt() - 1;

            if (posizione <= 0) {
            	System.out.println("Uscita...");
                break;
            }

            if (posizione < array.length) {
                array[posizione] = numero;
                System.out.println(Arrays.toString(array));
            } else {
                System.out.println("Posizione non valida. Riprova.");
            }
        }

        scanner.close();
    }
}