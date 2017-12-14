import java.util.Date;

public class Prenotazione {

	private int idPrenotazione;
	private String nome_dottore;
	private String nome_ambulatorio;
	private Date data;
	private Date ora;
	private String tipologia_prenotazione;
	private String motivazione;
	private Ambulatorio ambulatorio;
	private Utente utente;
	private Medico medico;
	
	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public String getNome_dottore() {
		return nome_dottore;
	}
	public void setNome_dottore(String nome_dottore) {
		this.nome_dottore = nome_dottore;
	}
	public String getNome_ambulatorio() {
		return nome_ambulatorio;
	}
	public void setNome_ambulatorio(String nome_ambulatorio) {
		this.nome_ambulatorio = nome_ambulatorio;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getOra() {
		return ora;
	}
	public void setOra(Date ora) {
		this.ora = ora;
	}
	public String getTipologia_prenotazione() {
		return tipologia_prenotazione;
	}
	public void setTipologia_prenotazione(String tipologia_prenotazione) {
		this.tipologia_prenotazione = tipologia_prenotazione;
	}
	public String getMotivazione() {
		return motivazione;
	}
	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}
	public Ambulatorio getAmbulatorio() {
		return ambulatorio;
	}
	public void setAmbulatorio(Ambulatorio ambulatorio) {
		this.ambulatorio = ambulatorio;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
