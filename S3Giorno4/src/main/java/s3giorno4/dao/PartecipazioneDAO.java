package s3giorno4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import s3giorno4.entities.Evento;
import s3giorno4.entities.Partecipazione;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(partecipazione);

        transaction.commit();
    }

    public Partecipazione getById(Long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        partecipazione = em.merge(partecipazione);
        em.remove(partecipazione);

        transaction.commit();
    }

    public void refresh(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.refresh(partecipazione);

        transaction.commit();
    }
    
    public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento) {
        TypedQuery<Partecipazione> query = em.createNamedQuery("Partecipazione.getPartecipazioniDaConfermarePerEvento", Partecipazione.class);
        query.setParameter("evento", evento);
        return query.getResultList();
    }
}
