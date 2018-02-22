package gestione;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import model.Utente;
import programma.JPAUtil;

public class GestioneAccount {

/*	public boolean login(String mailOrUsername, String passwordUtente) {
		EntityManager em = JPAUtil.getEm();
		TypedQuery<Utente> q = em.createQuery
				("select u from Utente u where u.emailUtente=:"
						+ " paramMailUser OR u.usernameUtente=: paramMailUser",Utente.class );
		q.setParameter("paramMailUser", mailOrUsername);
		try {
			Utente utente = q.getSingleResult();
			return checkPassword(passwordUtente, utente);
		}   catch(NoResultException| NonUniqueResultException e) {
			return false;
		}
	}
	
	public boolean registrazioneUtente(String codiceFiscale, String numeroDiTelefono, String cognome, String nome, String email, String username, String password) {
		EntityManager em = JPAUtil.getEm();
		Utente utente = utentePerEmail(email, em);
		if(utente!=null) {
			return false;
		}else {
		    utente = utentePerUsername(username, em);
			if(utente!=null) {
				return false;
			}
			
		}
		Utente u = new Utente();
		u.setAttivo(true);
		u.setCodiceFiscaleUtente(codiceFiscale);
		u.setCognomeUtente(cognome);
		u.setEmailUtente(email);
	    u.setNomeUtente(nome);
	    u.setNumeroTelefonoUtente(numeroDiTelefono);
	    u.setPasswordUtente(password);
	    u.setUsernameUtente(username);
	    
	    em.getTransaction().begin();
	    em.persist(u);
	    em.getTransaction().commit();
	    return true;
		
		
	}
	public boolean cancellaUtente(int id) {
		EntityManager em = JPAUtil.getEm();
		Utente utente = em.find(Utente.class, id);
		if(utente==null) {
			return false;
		}
		em.getTransaction().begin();
		em.remove(utente);
		em.getTransaction().commit();
		return true;
	}
	
	
	private boolean checkPassword(String passwordUtente, Utente utente) {
		return utente.getPasswordUtente().equals(passwordUtente);
	}
	
	private Utente utentePerUsername(String username, EntityManager em) {
		Utente utente= null;
		try {
			utente= em.createQuery("select u from Utente u where u.usernameUtente:username", Utente.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch(NoResultException ex){
			ex.printStackTrace();
			
		}
		return utente;
	}
	private Utente utentePerEmail(String email, EntityManager em) {
		Utente utente = null;
		try {
			utente= em.createQuery("select u from Utente u where u.emailUtente=:email", Utente.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch(NoResultException ex) {
			ex.printStackTrace();
		}
		return utente;
	}
	// La versione sopra andava bene, ma adesso ne vediamo una piu completa.   */
	
	public EsitoOperazione login(String email, String password) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Utente u = em.find(Utente.class, email);
			boolean ok = u != null && u.getPassword().equals(password);
			_return.setSuccess(ok);
			_return.setMessaggio(!ok ? "Accesso fallito" : "Accesso effettuato");
			if(ok) {
				_return.setOggettoRisultante(u);
			}else {
				_return.setOggettoRisultante(null);
			}
		} catch(Exception ex){
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato male ->" + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}
	
	public EsitoOperazione registraUtente(String email, String password, 
			String nome, String cognome, 
			String codiceFiscale, Date dataNascita,
			String numeroTelefono, boolean attivo) {
		EsitoOperazione _return = new EsitoOperazione();
		Utente u = new Utente();
		u.setEmail(email);
		u.setPassword(password);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setDataNascita(dataNascita);
		u.setNumeroTelefono(numeroTelefono);
		u.setCodiceFiscale(codiceFiscale);
		u.setAttivo(attivo);
		
		_return = registraUtente(u);
		return _return;
	}
	
	public EsitoOperazione registraUtente(Utente nuovoUtente) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Utente u = em.find(Utente.class, nuovoUtente.getEmail());
			if(u != null) {
				_return.setSuccess(false);
				_return.setMessaggio("L'utente esiste già");
				_return.setOggettoRisultante(u);
			}else {
				em.getTransaction().begin();
				em.persist(nuovoUtente);
				em.getTransaction().commit();
				_return.setSuccess(true);
				_return.setMessaggio("Utente creato con successo");
				_return.setOggettoRisultante(nuovoUtente);
			}
		}catch(Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato storto ->" + ex.getMessage());
		    _return.setOggettoRisultante(ex);
		}
		return _return;
	}
	
	public EsitoOperazione rimuoviUtente(String email) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtil.getInstance().getEm();
			Utente u = em.find(Utente.class, email);
			if(u != null) {
				em.getTransaction().begin();
				em.remove(u);
				em.getTransaction().commit();
				_return.setSuccess(true);
				_return.setMessaggio("Utente rimosso correttamente");
				_return.setOggettoRisultante(null);
			}else {
				_return.setSuccess(false);
				_return.setMessaggio("utente non esiste");
				_return.setOggettoRisultante(null);
			}
		}catch(Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato storto -> " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
		
	}
}
	
	
