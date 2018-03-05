package com.example.itsadmin.dottorhouse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterPrenotazioni;
import com.example.itsadmin.dottorhouse.database.DatabaseAdapter;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;

/**
 * Created by itsadmin on 15/02/2018.
 */

public class frag_home extends Fragment {

    public frag_home (){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        /*QUERY CHE RESTITUISCE TUTTE visite NON EFFETTUATE DI UN UTENTE
        * SE RESTITUISCE ALMENO UN RISULTATO */

        TextView txtNonP = (TextView)view.findViewById(R.id.txtNonP);
        TextView textPrenotazioni = (TextView)view.findViewById(R.id.textPrenotazioni);
        ListView listVisiteDaFare = (ListView)view.findViewById(R.id.listaVisite);

        txtNonP.setVisibility(View.INVISIBLE);
        //textPrenotazioni.setText("Prenotazioni");


        ArrayList<ModelPrenotazione> listaPrenotazioni = new ArrayList<>();
        //listaPrenotazioni = (new DatabaseAdapter(getActivity()).getAllPrenotazioni);
        /*RIEMPIAMO ARRAY LIST CON LE PRENOTAZIONI NON EFFETTUATE*/

        AdapterPrenotazioni ap = new AdapterPrenotazioni(getActivity(), listaPrenotazioni);
        listVisiteDaFare.setAdapter(ap);
        ap.notifyDataSetChanged();




        return view;
    }
}
