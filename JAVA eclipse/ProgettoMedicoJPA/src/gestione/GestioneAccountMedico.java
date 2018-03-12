package gestione;

import java.util.Date;

import javax.persistence.EntityManager;

import model.Medico;
import model.Utente;
import programma.JPAUtil;

public class GestioneAccountMedico {
	
	public EsitoOperazione login(String email, String password) {
		EsitoOperazione _return = new EsitoOperazione();
		
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Medico m = em.find(Medico.class, email);
			boolean ok = m != null && m.getPassword().equals(password);
			_return.setSuccess(ok);
			_return.setMessaggio(!ok ? "Accesso fallito" : "Accesso effettuato");
			if(ok) {
				_return.setOggettoRisultante(m);
			}else {
				_return.setOggettoRisultante(null);
			}
		}catch(Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato male ->" + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}
	
	public EsitoOperazione registraMedico(String email, String password, 
			String nome, String cognome, 
		    Date dataNascita,
			String numeroTelefono, String tipologia) {
		EsitoOperazione _return = new EsitoOperazione();
		Medico m = new Medico();
		m.setEmail(email);
		m.setPassword(password);
		m.setNome(nome);
		m.setCognome(cognome);
		m.setDataNascita(dataNascita);
		m.setNumeroTelefono(numeroTelefono);
	
		m.setTipologia(tipologia);
		
		_return = registraMedico(m);
		return _return;
}
	
	public EsitoOperazione registraMedico(Medico nuovoMedico) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Medico m = em.find(Medico.class, nuovoMedico.getEmail());
			if(m != null) {
				_return.setSuccess(false);
				_return.setMessaggio("L'utente medico esiste già");
				_return.setOggettoRisultante(m);
			}else {
				em.getTransaction().begin();
				em.persist(nuovoMedico);
				em.getTransaction().commit();
				_return.setSuccess(true);
				_return.setMessaggio("Utente medico creato con successo");
				_return.setOggettoRisultante(nuovoMedico);
			}
		}catch(Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato storto ->" + ex.getMessage());
		    _return.setOggettoRisultante(ex);
		}
		return _return;
	}
	
	public EsitoOperazione rimuoviMedico(String email) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Medico m = em.find(Medico.class, email);
			if(m != null) {
				em.getTransaction().begin();
				em.remove(m);
				em.getTransaction().commit();
				_return.setSuccess(true);
				_return.setMessaggio("Utente medico rimosso correttamente");
				_return.setOggettoRisultante(null);
			}else {
				_return.setSuccess(false);
				_return.setMessaggio("utente medico non esiste");
				_return.setOggettoRisultante(null);
			}
		}catch(Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato storto -> " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
		
	}
	
	public EsitoOperazione aggiornaDatiMedico(String email, String password, String numeroTelefono) {
		EsitoOperazione eo = new EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Medico m = em.find(Medico.class, email);
			if(m != null) {
				m.setPassword(password);
				m.setNumeroTelefono(numeroTelefono);
				
				em.getTransaction().begin();
				em.persist(m);
				em.getTransaction().commit();
				
				eo.setSuccess(true);
				eo.setMessaggio("modifica avvenuta con successo");
				eo.setOggettoRisultante(m);
			}else {
				eo.setSuccess(false);
				eo.setMessaggio("medico non trovato");
				eo.setOggettoRisultante(null);
			}
	}catch(Exception e) {
		eo.setSuccess(false);
		eo.setMessaggio("qualcosa non sta andando = " + e.getMessage());
		eo.setOggettoRisultante(e);
	}
		return eo;
	}

	
}