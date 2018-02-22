package gestione;

import java.util.List;

import javax.persistence.EntityManager;

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
	public boolean nuovaPrenotazione() {
		return false;
	}
	
	public boolean cancellaPrenotazione(Utente utente, Prenotazione prenotazione) {
		EntityManager em = JPAUtil.getInstance().getEm();
		Prenotazione p = em.find(Prenotazione.class, prenotazione.getId());
		if(utente.getEmail()==prenotazione.getUtente().getEmail()) {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		}else {
			return false;
		}
		return true;
	}
	
}
