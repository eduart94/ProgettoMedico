package model;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="email", nullable = false)
	private String email;
    
    @Column(name="password", nullable = false)
	private String password;
    
    @Column(name="nome", nullable = false)
	private String nome;
    
    @Column(name="cognome", nullable = false)
	private String cognome;
	


	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita")
	private Date dataNascita;

	@Column(name="numero_telefono", nullable = false)
	private String numeroTelefono;

	@Column(nullable = false)
	private String tipologia;

	//bi-directional many-to-many association to Ambulatorio
	@ManyToMany
	@JsonIgnore
	@JoinTable(
		name="medico_has_ambulatorio"
		, joinColumns={
			@JoinColumn(name="Medico_email", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Ambulatorio_id", nullable=false)
			}
		)
	private List<Ambulatorio> ambulatorios;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="medico", cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(nullable=false)
	private List<Prenotazione> prenotaziones;
	
	@OneToMany(mappedBy="medico", cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(nullable=false)
	private List<SlotCalendar> slotCalendar;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public List<Ambulatorio> getAmbulatorios() {
		return ambulatorios;
	}

	public void setAmbulatorios(List<Ambulatorio> ambulatorios) {
		this.ambulatorios = ambulatorios;
	}

	public List<Prenotazione> getPrenotaziones() {
		return prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public List<SlotCalendar> getSlotCalendar() {
		return slotCalendar;
	}

	public void setSlotCalendar(List<SlotCalendar> slotCalendar) {
		this.slotCalendar = slotCalendar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
