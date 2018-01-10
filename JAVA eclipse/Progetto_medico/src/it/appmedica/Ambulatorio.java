package it.appmedica;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private String luogo;

	//bi-directional many-to-many association to Medico
	@ManyToMany(mappedBy="ambulatorios")
	private List<Medico> medicos;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="ambulatorio")
	private List<Prenotazione> prenotaziones;

	public Ambulatorio() {
	}

	public int getIdAmbulatorio() {
		return this.idAmbulatorio;
	}

	public void setIdAmbulatorio(int idAmbulatorio) {
		this.idAmbulatorio = idAmbulatorio;
	}

	public String getLuogo() {
		return this.luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
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