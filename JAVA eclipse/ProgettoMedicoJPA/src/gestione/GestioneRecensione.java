package gestione;

import javax.persistence.EntityManager;

import model.Prenotazione;
import programma.JPAUtil;

public class GestioneRecensione {
	
	public EsitoOperazione aggiungiRecensione(Prenotazione prenotazione, int voto) {
		EsitoOperazione eo = new EsitoOperazione();
		try {
	    EntityManager em = JPAUtil.getInstance().getEm();
		em.getTransaction().begin();
		Prenotazione prenotazioneEsistente = em.find(Prenotazione.class, prenotazione.getId());
		prenotazioneEsistente.setRecensione(voto);
		em.getTransaction().commit();
		eo.setSuccess(true);
		eo.setMessaggio("recensione effettuata");
		eo.setOggettoRisultante(prenotazioneEsistente);
	}catch(Exception e) {
		eo.setSuccess(false);
		eo.setMessaggio("Qualcosa è andato storto " + e.getMessage());
		eo.setOggettoRisultante(e);
	}
		return eo;
	}

}
