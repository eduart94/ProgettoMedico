package com.example.itsadmin.dottorhouse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterRicerca;
import com.example.itsadmin.dottorhouse.models.ModelRicerca;

import java.util.ArrayList;

public class frag_ricerca extends Fragment {

    String tipologia = "";
    String citta = "";

    public frag_ricerca(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.ricerca, container, false);

        ListView risultatiRicerca = (ListView) view.findViewById(R.id.lista_medico);
        ArrayList<ModelRicerca> lmr = new ArrayList<>();
        AdapterRicerca adapter = new AdapterRicerca(getActivity(),lmr);
        final EditText textTipologia = (EditText) view.findViewById(R.id.text_tipologia);
        //final EditText textNomeMedico = (EditText) view.findViewById(R.id.text_nome_medico);
        final EditText textCitta = (EditText) view.findViewById(R.id.text_luogo);

        Button cerca = (Button) view.findViewById(R.id.cerca);

        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipologia = textTipologia.getText().toString();
                citta = textCitta.getText().toString();

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