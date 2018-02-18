package gestione;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import model.Utente;
import programma.JPAUtil;

public class GestioneAccount {

	public boolean login(String mailOrUsername, String passwordUtente) {
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
}
