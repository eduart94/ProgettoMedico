package gestione;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;

import model.Ambulatorio;
import model.Disponibilita;
import model.Medico;
import model.Prenotazione;
import model.Utente;
import programma.JPAUtil;

public class GestionePrenotazione {
	
	public List<Prenotazione> elencoPrenotazioni(Utente utente){
		
		EntityManager em = JPAUtil.getInstance().getEm();
		return em.createQuery("select p from Prenotazione p where p.utente = :utente",Prenotazione.class)
				.setParameter("utente", utente)
				.getResultList();
		
	}
	public EsitoOperazione nuovaPrenotazione(Prenotazione nuovaPrenotazione) {
		EsitoOperazione eo = new EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Prenotazione p = em.find(Prenotazione.class, nuovaPrenotazione.getId());
			if(p != null) {
				eo.setSuccess(false);
				eo.setMessaggio("prenotazione già effetuata");
				eo.setOggettoRisultante(p);
			}else {
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				eo.setSuccess(true);
				eo.setMessaggio("prenotazione effetuata");
				eo.setOggettoRisultante(nuovaPrenotazione);
			}
		}catch(Exception e){
			eo.setSuccess(false);
			eo.setMessaggio("prenotazione non andata a buon fine " + e.getMessage());
			eo.setOggettoRisultante(e);
		}
		return eo;
	}
	
	public EsitoOperazione nuovaPrenotazione(Date data, Time ora, String motivazione,
			                                 int recensione, Ambulatorio ambulatorio,
			                                 Medico medico, Disponibilita disponibilita, Utente utente ) {
		
		EsitoOperazione eo = new EsitoOperazione();
		Prenotazione p = new Prenotazione();
		p.setAmbulatorio(ambulatorio);
		p.setData(data);
		p.setDisponibilita(disponibilita);
		p.setMedico(medico);
		p.setMotivazione(motivazione);
		p.setOra(ora);
		p.setRecensione(recensione);
		p.setUtente(utente);
		
		eo = nuovaPrenotazione(p);
		return eo;
	}
	
	public EsitoOperazione nuovaPrenotazione(Date data, Time ora, String motivazione, int recensione) {
		EsitoOperazione eo = new EsitoOperazione();
		Prenotazione p = new Prenotazione();
		p.setData(data);
		p.setOra(ora);
		p.setMotivazione(motivazione);
		p.setRecensione(recensione);
		
		eo = nuovaPrenotazione(p);
		return eo;
	}
	
	public EsitoOperazione cancellaPrenotazione(Utente utente, Prenotazione prenotazione) {
		EntityManager em = JPAUtil.getInstance().getEm();
		EsitoOperazione eo = new EsitoOperazione();
		Prenotazione p = em.find(Prenotazione.class, prenotazione.getId());
		if(utente.getEmail()==prenotazione.getUtente().getEmail()) {
			
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			eo.setSuccess(true);
			eo.setMessaggio("utente eliminato con successo");
			eo.setOggettoRisultante(null);
		}else {
			eo.setSuccess(false);
			eo.setMessaggio("non è stato eliminato");
			eo.setOggettoRisultante(null);
		}
		return eo;
	}
	
}
