package e.itsadmin.appmedica44;


import java.sql.Date;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class Medico {
    private int id;
    private Date data_nascita;
    private String codice_fiscale;
    private String cognome;
    private String email;
    private String nome;
    private String numero_telefono;
    private String tipologia;
    private String password;


    public Medico(){

    }
    public Medico(int id, String codice_fiscale, String cognome, String email, String nome, String numero_telefono, String tipologia, String password, Date data_nascita){
        this.id= id;
        this.codice_fiscale= codice_fiscale;
        this.cognome= cognome;
        this.email= email;
        this.nome= nome;

        this.numero_telefono= numero_telefono;
        this.tipologia= tipologia;
        this.password= password;
        this.data_nascita= data_nascita;

    }
    public Medico( String codice_fiscale, String cognome, String email, String nome, String numero_telefono, String tipologia, String password, Date data_nascita){

        this.codice_fiscale= codice_fiscale;
        this.cognome= cognome;
        this.email= email;
        this.nome= nome;
        this.numero_telefono= numero_telefono;
        this.tipologia= tipologia;
        this.password= password;
        this.data_nascita= data_nascita;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
