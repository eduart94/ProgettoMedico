package it.appmedica.programma;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMedicaProgramma {

	public static void main(String[] args) {
     
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Progetto_medico");

	}

}
