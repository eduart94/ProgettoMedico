package com.example.itsadmin.dottorhouse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterPrenotazioni;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;

/**
 * Created by itsadmin on 14/02/2018.
 */

public class frag_profilo extends Fragment {

    public frag_profilo(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList<ModelPrenotazione>lista = new ArrayList<ModelPrenotazione>();
        //lista = (new DatabaseAdapter(getActivity()).getAllPrenotazioni());

        final View view = inflater.inflate(R.layout.fragment_profilo, container, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView cognome = (TextView) view.findViewById(R.id.cognome);
        TextView mail = (TextView) view.findViewById(R.id.mail);
        ImageView profilePic = (ImageView) view.findViewById(R.id.profilePic);
        ListView listaVisiteFatte = (ListView) view.findViewById(R.id.listaPren);

        AdapterPrenotazioni adpt = new AdapterPrenotazioni(getActivity(), lista);

        System.out.println("Adapter settato");

        listaVisiteFatte.setAdapter(adpt);
        adpt.notifyDataSetChanged();

        return view;
    }


}

