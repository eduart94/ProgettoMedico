package com.example.itsadmin.dottorhouse.Utils;


import java.util.ArrayList;

public class Utilita {

    public static String formattaData(String giorno,String mese,String anno){

        String dataFormattata = "";
        int i = 0;

        dataFormattata += anno;

        dataFormattata += "-";

        if (mese.length() == 1){

            dataFormattata += "0";
        }

        dataFormattata += mese;

        dataFormattata += "-";

        if (giorno.length() == 1) {

            dataFormattata += "0";
        }

        dataFormattata += giorno;

        return dataFormattata;
    }

    public static String formattaOra (String ora, String minuti){

        String oraFormattata = "";

        if (ora.length()==1){

            oraFormattata += "0";
        }

        oraFormattata += ora;
        oraFormattata += ":";

        if (minuti.length() == 1){

            oraFormattata += "0";
        }

        oraFormattata += minuti;

        oraFormattata += ":00";

        return oraFormattata;
    }
}

