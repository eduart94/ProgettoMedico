package model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the ambulatorio database table.
 * 
 */
@Entity
@NamedQuery(name="Ambulatorio.findAll", query="SELECT a FROM Ambulatorio a")
public class Ambulatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAmbulatorio;
    
	@Column(nullable=false)
	private String indirizzo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Citta citta;

	//bi-directional many-to-many association to Medico
	@ManyToMany(mappedBy="ambulatorios")
	@JoinColumn(nullable=false)
	@JsonIgnore
	private List<Medico> medicos;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="ambulatorio", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Prenotazione> prenotaziones;
	
	

	
	
	public Ambulatorio() {
	}
	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public int getIdAmbulatorio() {
		return this.idAmbulatorio;
	}

	public void setIdAmbulatorio(int idAmbulatorio) {
		this.idAmbulatorio = idAmbulatorio;
	}



	public List<Medico> getMedicos() {
		return this.medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setAmbulatorio(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setAmbulatorio(null);

		return prenotazione;
	}

}
