package com.example.itsadmin.dottorhouse.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.database.DatabaseAdapter;

import com.example.itsadmin.dottorhouse.models.ModelRicerca;

import java.util.ArrayList;

public class AdapterRicerca extends ArrayAdapter<ModelRicerca> {
    Context c;
    ArrayList<ModelRicerca> lista_medico;
    DatabaseAdapter db;


    public AdapterRicerca(Context c, ArrayList<ModelRicerca> lmr) {
        super(c, R.layout.item_ricerca, lmr);

        db = new DatabaseAdapter(getContext());

        this.lista_medico = lmr;
        this.c = c;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){
        LayoutInflater lf = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View riga = lf.inflate(R.layout.item_ricerca, parent, false);



        TextView tipologia = (TextView)riga.findViewById(R.id.item_tipologia);
        TextView nomeMedico = (TextView)riga.findViewById(R.id.item_nome_medico);
        TextView citta = (TextView)riga.findViewById(R.id.item_luogo);


        tipologia.setText(lista_medico.get(position).getTipologia());
        nomeMedico.setText(lista_medico.get(position).getNomeMedico());
        citta.setText(lista_medico.get(position).getCitta());


        return riga;
    }


}