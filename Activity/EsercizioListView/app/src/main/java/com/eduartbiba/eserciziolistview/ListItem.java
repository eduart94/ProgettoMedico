package com.eduartbiba.eserciziolistview;

/**
 * Created by itsadmin on 22/01/2018.
 */

public class ListItem {

   private String contenuto;
   private Integer numeroCaratteri;
   private Integer numeroClick;

    public ListItem(String contenuto, int numeroCaratteri, int numeroClick){
        this.contenuto = contenuto;
        this.numeroCaratteri=numeroCaratteri;
        this.numeroClick = numeroClick;
    }

    public void incrementa (){
        numeroClick++;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public Integer getNumeroCaratteri() {
        return numeroCaratteri;
    }

    public void setNumeroCaratteri(int numeroCaratteri) {
        this.numeroCaratteri = numeroCaratteri;
    }

    public Integer getNumeroClick() {
        return numeroClick;
    }

    public void setNumeroClick(int numeroClick) {
        this.numeroClick = numeroClick;
    }



}
