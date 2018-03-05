package com.example.itsadmin.dottorhouse.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.MainActivity;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.login;

public class frag_login extends Fragment {

    String textlogin = "";
    String textPass = "";
    Activity parent;



    public frag_login() {
        parent = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        ImageView fotoMedico = (ImageView)view.findViewById(R.id.testLogin);
        final EditText editTextlogin = (EditText)view.findViewById(R.id.textEmailLogin);
        final EditText editTextPass = (EditText)view.findViewById(R.id.textLoginPass);
        TextView textregis = (TextView)view.findViewById(R.id.textRegis);
        Button btnAccedi = (Button)view.findViewById(R.id.buttonAccedi);
        ImageView accaount = (ImageView) view.findViewById(R.id.iconAccount);
        ImageView lock = (ImageView) view.findViewById(R.id.iconLock);

        // listener sulla scritta registrati che porta al fragment registrazione (con fragment transaction)
        textregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((login)getActivity()).cambiaFragment(new frag_registrazione());
            }
        });



        btnAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textlogin = editTextlogin.getText().toString();
                textPass = editTextPass.getText().toString();


                // considerazioni database
                // intent activity main

                Intent goMain = new Intent(getActivity(), MainActivity.class);
                startActivity(goMain);
            }
        });


        return view;
    }





}
