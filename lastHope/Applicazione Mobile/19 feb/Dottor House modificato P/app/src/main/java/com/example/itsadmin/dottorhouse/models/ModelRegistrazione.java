package com.example.itsadmin.dottorhouse.models;


import com.google.gson.annotations.SerializedName;

public class ModelRegistrazione {
    String nome;
    String cognome;
    @SerializedName("data_nascita")
    String dataNascita;
    @SerializedName("numero_telefono")
    String telefono;
    String email;
    String password;


    public ModelRegistrazione(){

    }

    public ModelRegistrazione(String nome, String cognome, String dataNascita, String telefono, String email, String password, String confermaPassword){
        this.nome=nome;
        this.cognome=cognome;
        this.dataNascita=dataNascita;
        this.telefono=telefono;
        this.email=email;
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

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

}
