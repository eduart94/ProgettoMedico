import java.util.List;

public class Ambulatorio {
	
	private int idAmbulatorio;
	private List<Medico> medici;
	private String luogo;
	
	public int getIdAmbulatorio() {
		return idAmbulatorio;
	}
	public void setIdAmbulatorio(int idAmbulatorio) {
		this.idAmbulatorio = idAmbulatorio;
	}
	public List<Medico> getMedici() {
		return medici;
	}
	public void setMedici(List<Medico> medici) {
		this.medici = medici;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
		
}
