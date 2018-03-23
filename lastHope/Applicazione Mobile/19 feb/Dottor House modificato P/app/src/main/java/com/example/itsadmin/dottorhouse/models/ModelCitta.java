package com.example.itsadmin.dottorhouse.models;

public class ModelCitta {

    int idCitta;
    String nome;
    String paese;

    public ModelCitta(){

    }

    public ModelCitta(int idCitta, String nome, String paese) {
        this.idCitta=idCitta;
        this.nome=nome;
        this.paese=paese;

    }

    public int getIdCitta() {
        return idCitta;
    }

    public void setIdCitta(int idCitta) {
        this.idCitta = idCitta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }
}
