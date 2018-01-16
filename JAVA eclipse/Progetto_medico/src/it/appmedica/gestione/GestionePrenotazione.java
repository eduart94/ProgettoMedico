package it.appmedica.gestione;

import java.util.List;

import javax.persistence.EntityManager;

import it.appmedica.gestione.JPAUtility;
import it.appmedica.model.Prenotazione;
import it.appmedica.model.Utente;

public class GestionePrenotazione {
	
	public List<Prenotazione> elencoPrenotazioni(Utente utente){
		
		EntityManager em = JPAUtility.emf.createEntityManager();
		
		return em.createQuery("select p from Prenotazione p where p.utente= :utente", Prenotazione.class)
				.setParameter("utente", utente)
				.getResultList();
	}
	public boolean nuovaPrenotazione() {
		return false;
	}

}
