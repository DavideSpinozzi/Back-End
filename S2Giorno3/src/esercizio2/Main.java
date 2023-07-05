package esercizio2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
    	int[] numeri = new Random().ints(3000, 1, Integer.MAX_VALUE).toArray();

        int[] risultati = new int[3];

        SumThread[] threads = new SumThread[3];
        for (int i = 0; i < 3; i++) {
            int inizio = i * 1000;
            int fine = (i + 1) * 1000;
            threads[i] = new SumThread(numeri, inizio, fine, risultati, i);
            threads[i].start();
        }

        for (int i = 0; i < 3; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int sommaTotale = 0;
        for (int i = 0; i < 3; i++) {
            sommaTotale += risultati[i];
        }
        System.out.println("Somma totale: " + sommaTotale);
    }

}

class SumThread extends Thread {
    private int[] numeri;
    private int indiceInizio;
    private int indiceFine;
    private int[] risultati;
    private int indiceThread;

    public SumThread(int[] numeri, int indiceInizio, int indiceFine, int[] risultati, int indiceThread) {
        this.numeri = numeri;
        this.indiceInizio = indiceInizio;
        this.indiceFine = indiceFine;
        this.risultati = risultati;
        this.indiceThread = indiceThread;
    }

    @Override
    public void run() {
        int somma = 0;
        for (int i = indiceInizio; i < indiceFine; i++) {
            somma += numeri[i];
        }
        risultati[indiceThread] = somma;
    }
}