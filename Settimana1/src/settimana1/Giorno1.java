package settimana1;

import java.util.Arrays;
import java.util.Scanner;

public class Giorno1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		while (counter != 8) {
			System.out.println();
			System.out.println();
			System.out.println("Inserisci l' operazione da effetuare");
			System.out.println("1 : Moltiplicazione");
			System.out.println("2 : Concatenazione");
			System.out.println("3 : Array con stringa");
			System.out.println("4 : Tre stringhe");
			System.out.println("5 : Perimetro Rettangolo");
			System.out.println("6 : Pari e Dispari");
			System.out.println("7 : Area Triangolo");
			System.out.println("8 : Esci");
			System.out.println();
			counter = scanner.nextInt();
			switch (counter) {

			case 1:
				System.out.println("Inserisci il primo numero : ");
				int num1 = scanner.nextInt();
				System.out.println("Inserisci il secondo numero : ");
				int num2 = scanner.nextInt();
				int result = multiply(num1, num2);
				System.out.println("Il risultato e : " + result);
				break;

			case 2:
				System.out.println("Inserisci una stringa: ");
				String stringa1 = scanner.next();
				System.out.println("Inserisci un numero intero : ");
				int num = scanner.nextInt();
				String concatena = concat(stringa1, num);
				System.out.println("concatenazione effettuata : " + concatena);
				break;

			case 3:
				String[] array = { "Primo", "Secondo", "Quarto", "Quinto", "Sesto" };
				String stringa2 = "Terzo";
				String[] nuovoarray = inserisciInArray(array, stringa2);
				System.out.println("Ecco il tuo Array: " + Arrays.toString(nuovoarray));
				break;

			case 4:
				System.out.println("Inserisci la prima stringa");
				String string1 = scanner.next();
				System.out.println("Inserisci la seconda stringa");
				String string2 = scanner.next();
				System.out.println("Inserisci la terza stringa");
				String string3 = scanner.next();
				System.out.println("Ordine normale: " + string1 + string2 + string3);
				System.out.println("Ordine inverso: " + string3 + string2 + string1);
				break;

			case 5:
				System.out.println("Inserisci la lunghezza del lato verticale: ");
				double lator1 = scanner.nextDouble();
				System.out.println("Inserisci la lunghezza dle lato orizzontale: ");
				double lator2 = scanner.nextDouble();
				double PerimetroRettangolo = Rettangolo(lator1, lator2);
				System.out.println("Perimetro del rettangolo: " + PerimetroRettangolo + " cm");
				break;

			case 6:
				System.out.println("Inserisci un numero: ");
				int numero = scanner.nextInt();
				int PariDisp = PariDispari(numero);
				System.out.println("Il risultato di pari e dispari: " + PariDisp);
				break;

			case 7:
				System.out.println("Inserisci la lunghezza del primo lato: ");
				double latot1 = scanner.nextDouble();
				System.out.println("Inserisci la lunghezza del secondo lato: ");
				double latot2 = scanner.nextDouble();
				System.out.println("Inserisci la lunghezza del terzo lato: ");
				double latot3 = scanner.nextDouble();
				double AreaTriangolo = Erone(latot1, latot2, latot3);
				System.out.println("Area del triangolo: " + AreaTriangolo + " cm2");
				break;

			case 8:
				System.out.println();
				System.out.println("Operazioni Terminate");
				scanner.close();
				break;

			}
		}

	}

	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}

	public static String concat(String stringa, int num) {
		return stringa + num;
	}

	public static String[] inserisciInArray(String[] array, String stringa) {
		String[] nuovoArray = new String[array.length + 1];
		for (int i = 0; i < nuovoArray.length; i++) {
			if (i < 2) {
				nuovoArray[i] = array[i];
			} else if (i == 2) {
				nuovoArray[i] = stringa;
			} else if (i > 2) {
				nuovoArray[i] = array[i - 1];
			}
		}
		return nuovoArray;
	}

	public static double Rettangolo(double lato1, double lato2) {
		return (lato1 + lato2) * 2;
	}

	public static int PariDispari(int num) {
		if (num % 2 == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public static double Erone(double lato1, double lato2, double lato3) {
		double p = (lato1 + lato2 + lato3) / 2;
		return Math.sqrt(p * (p - lato1) * (p - lato2) * (p - lato3));
	}
}