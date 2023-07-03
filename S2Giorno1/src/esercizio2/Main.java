package esercizio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Inserisci il numero di chilometri percorsi:");
            double chilometri = scanner.nextDouble();

            System.out.println("Inserisci il numero di litri di carburante consumati:");
            double litri = scanner.nextDouble();

            double kmPerLitro = chilometri / litri;
            System.out.println("Il consumo medio è di " + kmPerLitro + " km/litro.");
        } catch (ArithmeticException e) {
            System.out.println("Errore: divisione per zero");

        scanner.close();
    }
}
    }