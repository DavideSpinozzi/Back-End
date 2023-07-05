package esercizio3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroPresenze {
    private List<Presenza> presenze;

    public RegistroPresenze() {
        presenze = new ArrayList<>();
    }

    public void aggiungiPresenza(Presenza presenza) {
        presenze.add(presenza);
    }

    public void salvaPresenzeSuFile(String nomeFile) {
        StringBuilder sb = new StringBuilder();
        for (Presenza presenza : presenze) {
            sb.append(presenza.getNome()).append("@").append(presenza.getGiorni()).append("#");
        }

        try {
            FileUtils.writeStringToFile(new File(nomeFile), sb.toString(), "UTF-8");
            System.out.println("Presenze salvate con successo su file.");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

    public void caricaPresenzeDaFile(String nomeFile) {
        try {
            String data = FileUtils.readFileToString(new File(nomeFile), "UTF-8");
            String[] presenzeString = data.split("#");

            for (String presenzaString : presenzeString) {
                String[] parts = presenzaString.split("@");
                if (parts.length == 2) {
                    String nome = parts[0];
                    int giorni = Integer.parseInt(parts[1]);
                    Presenza presenza = new Presenza(nome, giorni);
                    presenze.add(presenza);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stampaPresenze() {
        for (Presenza presenza : presenze) {
            System.out.println(presenza.getNome() + ": " + presenza.getGiorni() + " giorni");
        }
    }

    public static void main(String[] args) {
        RegistroPresenze registro = new RegistroPresenze();
        registro.aggiungiPresenza(new Presenza("Mario Rossi", 5));
        registro.aggiungiPresenza(new Presenza("Giorgio Bianchi", 7));
        registro.aggiungiPresenza(new Presenza("Gianni Verdi", 7));

        registro.salvaPresenzeSuFile("presenze.txt");

        RegistroPresenze registroCaricato = new RegistroPresenze();
        registroCaricato.caricaPresenzeDaFile("presenze.txt");
        registroCaricato.stampaPresenze();
    }
}

class Presenza {
    private String nome;
    private int giorni;

    public Presenza(String nome, int giorni) {
        this.nome = nome;
        this.giorni = giorni;
    }

    public String getNome() {
        return nome;
    }

    public int getGiorni() {
        return giorni;
    }
}