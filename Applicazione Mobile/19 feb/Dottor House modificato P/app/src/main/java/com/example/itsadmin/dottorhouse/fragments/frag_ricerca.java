package com.example.itsadmin.dottorhouse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterRicerca;
import com.example.itsadmin.dottorhouse.cursor.TipologiaCursorAdapter;
import com.example.itsadmin.dottorhouse.database.DatabaseAdapter;
import com.example.itsadmin.dottorhouse.database.DatabaseHelper;
import com.example.itsadmin.dottorhouse.models.ModelRicerca;

import java.util.ArrayList;
import java.util.List;

public class frag_ricerca extends Fragment {
    TipologiaCursorAdapter tca;


    public frag_ricerca(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.ricerca, container, false);





        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        EditText citta = (EditText)view.findViewById(R.id.citta);
        Button cerca = (Button) view.findViewById(R.id.cerca);
        ListView risultatiRicerca = (ListView) view.findViewById(R.id.lista_medico);
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(getActivity());

        //spinner
        tca = new TipologiaCursorAdapter(getActivity(), databaseAdapter.getAllTipologie());


        //tca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(tca);
        //spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener())


        //listView
        ArrayList<ModelRicerca> lmr = new ArrayList<>();
        AdapterRicerca adapter = new AdapterRicerca(getActivity(),lmr);
        risultatiRicerca.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //button
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //lmr = db.ricerca(new ModelRicerca(tipologia,nomeMedico,citta));

                // adapter.setNotifyDataChanged();
            }
        });

        risultatiRicerca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // intent activity medico con un putExtra = nomeMedico
            }
        });



        return view;
    }


}