package it.appmedica;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMedico;

	@Column(name="codice_fiscale_medico")
	private String codiceFiscaleMedico;

	@Column(name="cognome_medico")
	private String cognomeMedico;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita_medico")
	private Date dataNascitaMedico;

	@Column(name="email_medico")
	private String emailMedico;

	@Column(name="nome_medico")
	private String nomeMedico;

	@Column(name="numero_telefono_medico")
	private String numeroTelefonoMedico;

	@Column(name="password_medico")
	private String passwordMedico;

	private String tipologia;

	//bi-directional many-to-many association to Ambulatorio
	@ManyToMany
	@JoinTable(
		name="medico_has_ambulatorio"
		, joinColumns={
			@JoinColumn(name="Medico_idMedico")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Ambulatorio_idAmbulatorio")
			}
		)
	private List<Ambulatorio> ambulatorios;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="medico")
	private List<Prenotazione> prenotaziones;

	public Medico() {
	}

	public int getIdMedico() {
		return this.idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getCodiceFiscaleMedico() {
		return this.codiceFiscaleMedico;
	}

	public void setCodiceFiscaleMedico(String codiceFiscaleMedico) {
		this.codiceFiscaleMedico = codiceFiscaleMedico;
	}

	public String getCognomeMedico() {
		return this.cognomeMedico;
	}

	public void setCognomeMedico(String cognomeMedico) {
		this.cognomeMedico = cognomeMedico;
	}

	public Date getDataNascitaMedico() {
		return this.dataNascitaMedico;
	}

	public void setDataNascitaMedico(Date dataNascitaMedico) {
		this.dataNascitaMedico = dataNascitaMedico;
	}

	public String getEmailMedico() {
		return this.emailMedico;
	}

	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}

	public String getNomeMedico() {
		return this.nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getNumeroTelefonoMedico() {
		return this.numeroTelefonoMedico;
	}

	public void setNumeroTelefonoMedico(String numeroTelefonoMedico) {
		this.numeroTelefonoMedico = numeroTelefonoMedico;
	}

	public String getPasswordMedico() {
		return this.passwordMedico;
	}

	public void setPasswordMedico(String passwordMedico) {
		this.passwordMedico = passwordMedico;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public List<Ambulatorio> getAmbulatorios() {
		return this.ambulatorios;
	}

	public void setAmbulatorios(List<Ambulatorio> ambulatorios) {
		this.ambulatorios = ambulatorios;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setMedico(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setMedico(null);

		return prenotazione;
	}

}