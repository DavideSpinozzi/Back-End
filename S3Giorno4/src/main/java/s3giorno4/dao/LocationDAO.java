package s3giorno4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import s3giorno4.entities.Location;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(location);

        transaction.commit();
    }

    public Location getById(Long id) {
        return em.find(Location.class, id);
    }

    public void delete(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        location = em.merge(location);
        em.remove(location);

        transaction.commit();
    }

    public void refresh(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.refresh(location);

        transaction.commit();
    }
}
