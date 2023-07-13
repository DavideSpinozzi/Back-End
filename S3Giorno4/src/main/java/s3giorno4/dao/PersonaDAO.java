package s3giorno4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import s3giorno4.entities.Persona;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(persona);

        transaction.commit();
    }

    public Persona getById(Long id) {
        return em.find(Persona.class, id);
    }

    public void delete(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        persona = em.merge(persona);
        em.remove(persona);

        transaction.commit();
    }

    public void refresh(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.refresh(persona);

        transaction.commit();
    }
}
