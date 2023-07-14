package s3giorno4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import s3giorno4.entities.Concerto;
import s3giorno4.entities.Evento;
import s3giorno4.entities.GaraDiAtletica;
import s3giorno4.entities.GenereConcerto;
import s3giorno4.entities.PartitaDiCalcio;
import s3giorno4.entities.Persona;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        evento = em.merge(evento);
        em.remove(evento);
        transaction.commit();
    }

    public void refresh(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.refresh(evento);
        transaction.commit();
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        String jpql = "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming";
        TypedQuery<Concerto> query = em.createQuery(jpql, Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(List<GenereConcerto> generi) {
        String jpql = "SELECT c FROM Concerto c WHERE c.genere IN :generi";
        TypedQuery<Concerto> query = em.createQuery(jpql, Concerto.class);
        query.setParameter("generi", generi);
        return query.getResultList();
    }
    
    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartitePareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
        TypedQuery<GaraDiAtletica> query = em.createNamedQuery("GaraDiAtletica.getGareDiAtleticaPerVincitore", GaraDiAtletica.class);
        query.setParameter("vincitore", vincitore);
        return query.getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Persona partecipante) {
        TypedQuery<GaraDiAtletica> query = em.createNamedQuery("GaraDiAtletica.getGareDiAtleticaPerPartecipante", GaraDiAtletica.class);
        query.setParameter("partecipante", partecipante);
        return query.getResultList();
    }

    public List<Evento> getEventiSoldOut() {
        TypedQuery<Evento> query = em.createNamedQuery("Evento.getEventiSoldOut", Evento.class);
        return query.getResultList();
    }

    public List<Evento> getEventiPerInvitato(Persona invitato) {
        TypedQuery<Evento> query = em.createNamedQuery("Evento.getEventiPerInvitato", Evento.class);
        query.setParameter("invitato", invitato);
        return query.getResultList();
    }
}