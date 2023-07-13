package s3giorno4.app;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import s3giorno4.dao.EventoDAO;
import s3giorno4.dao.LocationDAO;
import s3giorno4.dao.PartecipazioneDAO;
import s3giorno4.dao.PersonaDAO;
import s3giorno4.entities.Evento;
import s3giorno4.entities.Location;
import s3giorno4.entities.Partecipazione;
import s3giorno4.entities.Persona;
import s3giorno4.entities.StatoPartecipazione;
import s3giorno4.entities.*;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3Giorno4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
        	PersonaDAO personaDAO = new PersonaDAO(em);
            Persona persona = new Persona("Nome", "Cognome", "email@example.com", LocalDate.of(1990, 1, 1), Sesso.Maschio);
            personaDAO.save(persona);
            System.out.println("Persona salvata: " + persona);

            LocationDAO locationDAO = new LocationDAO(em);
            Location location = new Location();
            location.setNome("Nome Location");
            location.setCittà("Città Location");
            locationDAO.save(location);
            System.out.println("Location salvata: " + location);

            EventoDAO eventoDAO = new EventoDAO(em);
            Evento evento = new Evento("Titolo Evento", LocalDate.of(2023, 7, 13), "Descrizione Evento", "Tipo Evento", 100);
            evento.setLocation(location);
            eventoDAO.save(evento);
            System.out.println("Evento salvato: " + evento);

            PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
            Partecipazione partecipazione = new Partecipazione(persona, evento, StatoPartecipazione.CONFERMATA);
            partecipazioneDAO.save(partecipazione);
            System.out.println("Partecipazione salvata: " + partecipazione);
            
        } finally {
            em.close();
            emf.close();
        }
    }
}
