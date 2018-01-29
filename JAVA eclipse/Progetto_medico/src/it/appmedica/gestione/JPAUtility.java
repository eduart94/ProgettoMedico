package it.appmedica.gestione;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
	
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Progetto_medico");


}
