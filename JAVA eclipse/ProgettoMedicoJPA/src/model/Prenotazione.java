package model;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Transient
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Column(nullable=false)
	private int recensione;
    
	public int getRecensione() {
		return recensione;
	}

	public void setRecensione(int recensione) {
		this.recensione = recensione;
	}

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
    
	@Column(nullable = false)
	private String motivazione;
	

	
	
	public boolean getIniziato() {
		Instant instant = this.data.toInstant();
		return instant.isBefore(Instant.now());
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    
	@Column(nullable = false)
	private Time ora;

	

	public void setId(int id) {
		this.id = id;
	}

	//bi-directional many-to-one association to Ambulatorio
	@ManyToOne
	@JoinColumn(nullable=false)
	private Ambulatorio ambulatorio;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(nullable=false)
	private Medico medico;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(nullable=false)
	private Utente utente;

	public Prenotazione() {
	}
	
	public String getDataStringa() {
		return sdf.format(this.data);
	}

	public int getId() {
		return this.id;
	}

	public void setIdPrenotazione(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMotivazione() {
		return this.motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	

	public Time getOra() {
		return this.ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
	}



	public Ambulatorio getAmbulatorio() {
		return this.ambulatorio;
	}

	public void setAmbulatorio(Ambulatorio ambulatorio) {
		this.ambulatorio = ambulatorio;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}