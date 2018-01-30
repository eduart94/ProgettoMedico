package it.appmedica.gestione;

import javax.persistence.EntityManager;

import it.appmedica.model.Prenotazione;

public class GestioneRecensione {
	
	public void aggiungiRecensione(Prenotazione prenotazione, int voto) {
		
		EntityManager em = JPAUtility.emf.createEntityManager();
		
		em.getTransaction().begin(); 
		Prenotazione prenotazioneEsistente = em.find(Prenotazione.class, prenotazione.getIdPrenotazione()); 
		prenotazioneEsistente.setRecensione(voto);
		em.getTransaction().commit();
	}

}
