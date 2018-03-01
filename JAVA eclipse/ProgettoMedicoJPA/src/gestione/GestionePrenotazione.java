package gestione;

import java.util.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;



import model.Prenotazione;
import model.*;
import programma.JPAUtil;

public class GestionePrenotazione {
	
	public List<Prenotazione> elencoPrenotazioni(Utente utente){
		
		EntityManager em = JPAUtil.getInstance().getEm();
		return em.createQuery("select p from Prenotazione p where p.utente = :utente",Prenotazione.class)
				.setParameter("utente", utente)
				.getResultList();
		
	}
	public EsitoOperazione nuovaPrenotazione(Date data, Time ora, String motivazione, int recensione, 
			String emailMedico, String emailUtente, int idDisponibilita, int idAmbulatorio) {
	
		EsitoOperazione eo = new EsitoOperazione();
		EntityManager em = JPAUtil.getInstance().getEm();
		
		Medico m = em.find(Medico.class, emailMedico);
		Utente u = em.find(Utente.class, emailUtente);
		Disponibilita d = em.find(Disponibilita.class, idDisponibilita);
		Ambulatorio a = em.find(Ambulatorio.class, idAmbulatorio);
		
		Prenotazione p = new Prenotazione();
		p.setAmbulatorio(a);
		p.setDisponibilita(d);
		p.setUtente(u);
		p.setMedico(m);
		p.setData(data);
		p.setOra(ora);
		p.setMotivazione(motivazione);
		p.setRecensione(recensione);

		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		eo = nuovaPrenotazione(p);
		return eo;
	}
	
	public EsitoOperazione nuovaPrenotazione(Prenotazione nuovaPrenotazione) {
		EsitoOperazione eo = new  EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Prenotazione p = em.find(Prenotazione.class, nuovaPrenotazione.getId());
			if(p != null) {
				eo.setSuccess(true);
				eo.setMessaggio("Prenotazione creata con successo");
				eo.setOggettoRisultante(nuovaPrenotazione);
			}else {
				eo.setSuccess(false);
				eo.setMessaggio("Prenotazione non creata");
				eo.setOggettoRisultante(null);
			}
		}catch(Exception e){
			eo.setSuccess(false);
			eo.setMessaggio("qualcosa non va" + e.getMessage());
			eo.setOggettoRisultante(null);
		}
		return eo;
	}
	
	public EsitoOperazione cancellaPrenotazione(Utente utente, Prenotazione prenotazione) {
		EsitoOperazione eo = new EsitoOperazione();
		try {
		EntityManager em = JPAUtil.getInstance().getEm();
		Prenotazione p = em.find(Prenotazione.class, prenotazione.getId());
		if(utente.getEmail()==prenotazione.getUtente().getEmail()) {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			eo.setSuccess(true);
			eo.setMessaggio("prenotazione cancellata");
			eo.setOggettoRisultante(null);
		}else {
			eo.setSuccess(false);
			eo.setMessaggio("prenotazione non esistente");
			eo.setOggettoRisultante(null);
		}
		
	}catch(Exception e ) {
		eo.setSuccess(false);
		eo.setMessaggio("sei nel catch " + e.getMessage());
		eo.setOggettoRisultante(e);
	}
		return eo;
}
	
}
