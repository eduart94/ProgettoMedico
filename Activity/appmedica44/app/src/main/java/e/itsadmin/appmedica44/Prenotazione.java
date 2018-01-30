package e.itsadmin.appmedica44;

import java.time.LocalDateTime;
import java.sql.Date;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class Prenotazione {
    private int id;
    private Date data;
    private String motivazione;
    private String nome_ambulatorio;
    private String nome_dottore;
    private String ora;
    private String recensione;
    private String tipo_prenotazione;

    public Prenotazione(){

    }
    public Prenotazione(int id, Date data, String motivazione, String nome_ambulatorio, String nome_dottore, String ora, String recensione, String tipo_prenotazione){

        this.id= id;
        this.data= data;
        this.motivazione= motivazione;
        this.nome_ambulatorio= nome_ambulatorio;
        this.nome_dottore= nome_dottore;
        this.ora=ora;
        this.recensione= recensione;

        this.tipo_prenotazione= tipo_prenotazione;

    }
    public Prenotazione( Date data, String motivazione, String nome_ambulatorio, String nome_dottore, String ora, String recensione, String tipo_prenotazione){


        this.data= data;
        this.motivazione= motivazione;
        this.nome_ambulatorio= nome_ambulatorio;
        this.nome_dottore= nome_dottore;
        this.ora=ora;
        this.recensione= recensione;
        this.tipo_prenotazione= tipo_prenotazione;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public String getNome_ambulatorio() {
        return nome_ambulatorio;
    }

    public void setNome_ambulatorio(String nome_ambulatorio) {
        this.nome_ambulatorio = nome_ambulatorio;
    }

    public String getNome_dottore() {
        return nome_dottore;
    }

    public void setNome_dottore(String nome_dottore) {
        this.nome_dottore = nome_dottore;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getRecensione() {
        return recensione;
    }

    public void setRecensione(String recensione) {
        this.recensione = recensione;
    }

    public String getTipo_prenotazione() {
        return tipo_prenotazione;
    }

    public void setTipo_prenotazione(String tipo_prenotazione) {
        this.tipo_prenotazione = tipo_prenotazione;
    }


}
