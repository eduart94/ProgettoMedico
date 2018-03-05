package gestione;

import javax.persistence.EntityManager;

import model.Prenotazione;
import programma.JPAUtil;

public class GestioneRecensione {
	
	public void aggiungiRecensione(Prenotazione prenotazione, int voto) {
		EntityManager em = JPAUtil.getInstance().getEm();
		em.getTransaction().begin();
		Prenotazione prenotazioneEsistente = em.find(Prenotazione.class, prenotazione.getId());
		prenotazioneEsistente.setRecensione(voto);
		em.getTransaction().commit();
	}

}
