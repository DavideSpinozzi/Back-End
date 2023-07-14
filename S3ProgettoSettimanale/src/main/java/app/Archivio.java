package app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PrestitoDAO;
import dao.ReadablexDAO;
import dao.UtenteDAO;
import entities.Libro;
import entities.Readablex;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;

public class Archivio {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3ProgettoSettimanale");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
            
            UtenteDAO utenteDAO = new UtenteDAO(em);
            PrestitoDAO prestitoDAO = new PrestitoDAO(em);
            ReadablexDAO readablexDAO = new ReadablexDAO(em);

            Libro libro1 = new Libro("Harry Potter 1", 2023, 300, "JKR", "Fantasy");
            readablexDAO.aggiungiElementoCatalogo(libro1);
            Libro libro2 = new Libro("Harry Potter 2", 2023, 300, "JKR", "Fantasy");
            readablexDAO.aggiungiElementoCatalogo(libro2);

            Rivista rivista1 = new Rivista("Harry Potter R1", 2023, 50, Rivista.Periodicita.MENSILE);
            readablexDAO.aggiungiElementoCatalogo(rivista1);
            Rivista rivista2 = new Rivista("Harry Potter R2", 2023, 50, Rivista.Periodicita.MENSILE);
            readablexDAO.aggiungiElementoCatalogo(rivista2);

            Utente utente = new Utente("Davide", "Spinozzi", LocalDate.of(2001, 2, 5));
            utenteDAO.aggiungiUtente(utente);

            Readablex elementoPrestato = libro1; 
            LocalDate dataInizioPrestito = LocalDate.of(2010, 2, 5); 
            LocalDate dataRestituzioneEffettiva = null; 

            Prestito prestito = new Prestito(utente, elementoPrestato, dataInizioPrestito, dataRestituzioneEffettiva);
            prestitoDAO.aggiungiPrestito(prestito);
         
            List<Prestito> prestitiUtente = utenteDAO.ricercaPrestitiUtente(utente.getNumeroTessera());
        
            List<Prestito> prestitiScadutiNonRestituiti = prestitoDAO.ricercaPrestitiScadutiNonRestituiti();

            System.out.println("Prestiti dell'utente:");
            for (Prestito prestitoUtente : prestitiUtente) {
                System.out.println(prestitoUtente);
            }

            System.out.println("Prestiti scaduti e non restituiti:");
            for (Prestito prestitoScadutoNonRestituito : prestitiScadutiNonRestituiti) {
                System.out.println(prestitoScadutoNonRestituito);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}