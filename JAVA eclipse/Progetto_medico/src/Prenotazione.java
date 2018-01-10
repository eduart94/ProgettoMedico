import java.util.Date;

public class Prenotazione {

	private int idPrenotazione;
	private String nomeDottore;
	private String nomeAmbulatorio;
	private Date data;
	private Date ora;
	private String tipologiaPrenotazione;
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
	public String getNomeDottore() {
		return nomeDottore;
	}
	public void setNomeDottore(String nomeDottore) {
		this.nomeDottore = nomeDottore;
	}
	public String getNomeAmbulatorio() {
		return nomeAmbulatorio;
	}
	public void setNomeAmbulatorio(String nomeAmbulatorio) {
		this.nomeAmbulatorio = nomeAmbulatorio;
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
	public String getTipologiaPrenotazione() {
		return tipologiaPrenotazione;
	}
	public void setTipologiaPrenotazione(String tipologiaPrenotazione) {
		this.tipologiaPrenotazione = tipologiaPrenotazione;
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
