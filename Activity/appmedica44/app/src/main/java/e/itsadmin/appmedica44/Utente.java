package e.itsadmin.appmedica44;

import java.sql.Date;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class Utente {
    private int id;
    private boolean attivo;
    private Date data_nascita;
    private String codice_fiscale;
    private String cognome;
    private String nome;
    private String email;
    private String numero_telefono;
    private String username;
    private String password;

    public Utente(){

    }
    public Utente(int id, boolean attivo, Date data_nascita, String codice_fiscale, String cognome, String nome, String email, String numero_telefono, String username, String password){
        this.id=id;
        this.attivo=attivo;
        this.data_nascita=data_nascita;
        this.codice_fiscale=codice_fiscale;
        this.cognome= cognome;
        this.nome= nome;
        this.email= email;
        this.numero_telefono= numero_telefono;

        this.username= username;
        this.password= password;

    }
    public Utente( boolean attivo, Date data_nascita, String codice_fiscale, String cognome, String nome, String email, String numero_telefono, String username, String password){

        this.attivo=attivo;
        this.data_nascita=data_nascita;
        this.codice_fiscale=codice_fiscale;
        this.cognome= cognome;
        this.nome= nome;
        this.email= email;
        this.numero_telefono= numero_telefono;
        this.username= username;
        this.password= password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
