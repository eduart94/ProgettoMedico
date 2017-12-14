import java.util.Date;
import java.util.List;

public class Medico {

	private int idMedico;
	private String tipologia;
	private String nome_medico;
	private String cognome_medico;
	private Date data_nascita_medico;
	private String codice_fiscale_medico;
	private String numero_telefono_medico;
	private String email_medico;
	private String password_medico;
	private List<Ambulatorio> ambulatori;
	
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getNome_medico() {
		return nome_medico;
	}
	public void setNome_medico(String nome_medico) {
		this.nome_medico = nome_medico;
	}
	public String getCognome_medico() {
		return cognome_medico;
	}
	public void setCognome_medico(String cognome_medico) {
		this.cognome_medico = cognome_medico;
	}
	public Date getData_nascita_medico() {
		return data_nascita_medico;
	}
	public void setData_nascita_medico(Date data_nascita_medico) {
		this.data_nascita_medico = data_nascita_medico;
	}
	public String getCodice_fiscale_medico() {
		return codice_fiscale_medico;
	}
	public void setCodice_fiscale_medico(String codice_fiscale_medico) {
		this.codice_fiscale_medico = codice_fiscale_medico;
	}
	public String getNumero_telefono_medico() {
		return numero_telefono_medico;
	}
	public void setNumero_telefono_medico(String numero_telefono_medico) {
		this.numero_telefono_medico = numero_telefono_medico;
	}
	public String getEmail_medico() {
		return email_medico;
	}
	public void setEmail_medico(String email_medico) {
		this.email_medico = email_medico;
	}
	public String getPassword_medico() {
		return password_medico;
	}
	public void setPassword_medico(String password_medico) {
		this.password_medico = password_medico;
	}
	
	public List<Ambulatorio> getAmbulatori() {
		return ambulatori;
	}
	public void setAmbulatori(List<Ambulatorio> ambulatori) {
		this.ambulatori = ambulatori; 
	}
		
}
