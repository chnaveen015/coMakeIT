package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionEstablishment {
		public EntityManager getConnection()
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("busreservationsystem");
			EntityManager entityManager = emf.createEntityManager();
			return entityManager;
		}
}
