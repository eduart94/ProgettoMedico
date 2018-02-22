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
			String codiceFiscale, Date dataNascita,
			String numeroTelefono, String tipologia) {
		EsitoOperazione _return = new EsitoOperazione();
		Medico m = new Medico();
		m.setEmail(email);
		m.setPassword(password);
		m.setNome(nome);
		m.setCognome(cognome);
		m.setDataNascita(dataNascita);
		m.setNumeroTelefono(numeroTelefono);
		m.setCodiceFiscale(codiceFiscale);
		m.setTipologia(tipologia);
		
		_return = registraMedico (m);
		return _return;
}

	
}