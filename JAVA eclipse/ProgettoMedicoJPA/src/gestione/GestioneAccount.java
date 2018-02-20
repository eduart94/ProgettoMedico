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
	
	private boolean checkPassword(String passwordUtente, Utente utente) {
		return utente.getPasswordUtente().equals(passwordUtente);
	}
}
