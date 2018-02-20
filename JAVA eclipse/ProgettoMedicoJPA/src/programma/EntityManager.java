package programma;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoMedicoJPA");
		

	}

}
