package esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {

    public static void main(String[] args) {
        Map<String, String> contatti = creaContatto("Giacomo", "30");
        contatti.putAll(creaContatto("Peppe", "10"));
        
        stampaContatti(contatti);
       
        cercaNome(contatti, "30");
  
        cercaNumero(contatti, "Giacomo");
        
        rimuoviContatto(contatti, "Giacomo");
        
        stampaContatti(contatti);
    }

    public static Map<String, String> creaContatto(String nome, String numero) {
        Map<String, String> contatti = new HashMap<>();
        contatti.put(nome, numero);
        return contatti;
    }

    public static void rimuoviContatto(Map<String, String> contatti, String nome) {
        contatti.remove(nome);
    }

    public static void cercaNome(Map<String, String> contatti, String telefono) {
        for (Map.Entry<String, String> entry : contatti.entrySet()) {
            if (entry.getValue().equals(telefono)) {
                System.out.println("Il numero di telefono " + telefono + " corrisponde a " + entry.getKey());
                return;
            }
        }
        System.out.println("Nessun nome trovato per il numero di telefono " + telefono);
    }

    public static void cercaNumero(Map<String, String> contatti, String nome) {
        for (Map.Entry<String, String> entry : contatti.entrySet()) {
            if (entry.getKey().equals(nome)) {
                System.out.println("Il numero di telefono di " + nome + " è " + entry.getValue());
                return;
            }
        }
        System.out.println("Nessun numero di telefono trovato per il nome " + nome);
    }

    public static void stampaContatti(Map<String, String> contatti) {
        for (Map.Entry<String, String> entry : contatti.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + " Telefono: " + entry.getValue());
        }
    }
}