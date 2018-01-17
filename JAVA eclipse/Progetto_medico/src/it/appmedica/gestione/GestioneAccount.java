package it.appmedica.gestione;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import it.appmedica.model.Utente;

public class GestioneAccount {
	
	
	public boolean login(String mailOrUsername, String passwordUtente) {
		
	    EntityManager em = JPAUtility.emf.createEntityManager();
	    
	    // em.find cerca un'entità data la sua chiave (@Id)
	    // Utente utente = em.find(Utente.class, 1);
	    TypedQuery<Utente> q = em.createQuery("select u from Utente u where u.emailUtente=:peramMailUser OR u.usernameUtente=:peramMailUser", Utente.class);
	    q.setParameter("peramMailUser", mailOrUsername);
	    
	    try {
	    	Utente utente = q.getSingleResult();
	    	return checkPassword(passwordUtente, utente);
	    } catch (NoResultException | NonUniqueResultException e) {
	    	return false;
	    }		
	}


	
	    
	
	
    public boolean registrazioneUtente(String codiceFiscale, String numeroDiTelefono, String cognome, String nome, String email, String username, String password) {
    	 EntityManager em = JPAUtility.emf.createEntityManager();
    	 
    	 Utente utente = utentePeremail(email, em);
 		if (utente != null) {
 			return false;
 		} else {
 			utente = utentePerUsername(username, em);
 			if (utente != null) {
 				return false;
 			}
 		}
 		Utente u = new Utente();
 	
 		u.setCognomeUtente(cognome);
 		u.setNomeUtente(nome);
 		u.setUsernameUtente(username);
 		u.setPasswordUtente(password);
 		u.setEmailUtente(email);
 		u.setCodiceFiscaleUtente(codiceFiscale);
 		u.setAttivo(true);
 		
 		u.setNumeroTelefonoUtente(numeroDiTelefono);
 		em.getTransaction().begin();
 		em.persist(u);
 		em.getTransaction().commit();
 		
 		return true;
 	}
    
  
    
    public boolean cancellazioneUtente(int id){
    	
    	EntityManager em = JPAUtility.emf.createEntityManager();
    	 
    	Utente utente = em.find(Utente.class, id);
    	
    	if(utente == null)
    		return false;
    	
    		
    	em.getTransaction().begin();
    	em.remove(utente);
    	em.getTransaction().commit();
    	
    	
    	return true;
    }
      
        private boolean checkPassword(String passwordUtente, Utente utente) {
		return utente.getPasswordUtente().equals(passwordUtente);
	}
    
    
    
 	
    
    
 	private Utente utentePerUsername(String username, EntityManager em) {
 		Utente utente = null;
 		try {
 			utente = em.createQuery("select u from Utente u where u.usernameUtente=:username", Utente.class)
 					.setParameter("username", username)
 					.getSingleResult();
 		} catch (NoResultException ex) {
 			ex.printStackTrace();
 		}
 		return utente;
 	}	
 	private Utente utentePeremail(String email, EntityManager em) {
 		Utente utente = null;
 		try {
 			utente = em.createQuery("select u from Utente u where u.emailUtente=:email", Utente.class)
 					.setParameter("email", email)
 					.getSingleResult();
 		} catch (NoResultException ex) {
 			ex.printStackTrace();
 		}
 		return utente;
 	}	
    }
	


