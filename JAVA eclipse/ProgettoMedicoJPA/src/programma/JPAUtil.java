package programma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JPAUtil {
	
//	private static EntityManagerFactory emf;
//	
//	public static EntityManager getEm() {
//		if(emf==null)
//			emf = Persistence.createEntityManagerFactory("ProgettoMedicoJPA");
//		return emf.createEntityManager();
//	}

	private static final String PERSISTENCE_UNIT_NAME = "ProgettoMedicoJPA";
	private static JPAUtil instance;
	private EntityManagerFactory emf;
	
	private JPAUtil() {
		emf= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	public static JPAUtil getInstance() {
		if(instance == null)
			instance = new JPAUtil();
		return instance;
	}
	
	public EntityManager getEm() {
		return emf.createEntityManager();
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
}
