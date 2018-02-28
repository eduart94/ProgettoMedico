package programma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf;
	
	public static EntityManager getEm() {
		if(emf==null)
			emf = Persistence.createEntityManagerFactory("ProgettoMedicoJPA");
		return emf.createEntityManager();
	}

}
