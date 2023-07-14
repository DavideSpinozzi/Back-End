package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Archivio {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3ProgettoSettimanale");

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		
    }
}