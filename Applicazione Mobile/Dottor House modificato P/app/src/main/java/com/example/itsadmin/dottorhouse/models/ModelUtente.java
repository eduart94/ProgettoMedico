package com.example.itsadmin.dottorhouse.models;

import java.sql.Date;

/**
 * Created by itsadmin on 15/02/2018.
 */

public class ModelUtente {
    String nome;
    String cognome;
    Date data_di_nascita;
    String email_utente;
    String numero_telefono;
    String citta;
    String password;

    public ModelUtente(){
    }

    public ModelUtente(String nome, String cognome, Date data_di_nascita, String email, String numero_telefono, String citta, String password){
        this.nome=nome;
        this.cognome=cognome;
        this.data_di_nascita=data_di_nascita;
        this.email_utente =email;
        this.numero_telefono=numero_telefono;
        this.citta=citta;
        this.password=password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(Date data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public String getEmail() {
        return email_utente;
    }

    public void setEmail(String email) {
        this.email_utente = email;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
