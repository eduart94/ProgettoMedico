package com.example.itsadmin.dottorhouse.models;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;


public class ModelUtente {

    @SerializedName("emailUtente")
    String email;
    @SerializedName("passwordUtente")
    String password;
    @SerializedName("nomeUtente")
    String nome;
    @SerializedName("cognomeUtente")
    String cognome;
    String dataNascita;
    String numeroTelefono;


    public ModelUtente(){
    }

    public ModelUtente(String email, String password, String nome, String cognome, String dataNascita, String numeroTelefono) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString (){


        return "ciao, sono " +nome+" e la mia mail è "+email;
    }
}
