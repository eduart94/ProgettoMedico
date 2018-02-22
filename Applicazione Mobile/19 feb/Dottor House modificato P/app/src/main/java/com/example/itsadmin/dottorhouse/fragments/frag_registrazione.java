package com.example.itsadmin.dottorhouse.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.login;

public class frag_registrazione extends Fragment {
    Activity parent;

    public frag_registrazione() {
        parent = getActivity();
    }

    @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    final View view = inflater.inflate(R.layout.frag_registrazione, container, false);

        final EditText editNome = (EditText) view.findViewById(R.id.editNome);
        final EditText editCognome = (EditText) view.findViewById(R.id.editCognome);
        final EditText editCitta = (EditText) view.findViewById(R.id.editCitta);
        final EditText editDataDiNascita = (EditText) view.findViewById(R.id.editData);
        final EditText editTelefono = (EditText) view.findViewById(R.id.editTelefono);
        final EditText editEmail = (EditText) view.findViewById(R.id.editEmail);
        final EditText editPassword = (EditText) view.findViewById(R.id.editPassword);
        final EditText editConfermaPassword = (EditText) view.findViewById(R.id.editConfermaPassword);

        final RadioButton radioAcconsento = (RadioButton)view.findViewById(R.id.radioAcconsento);
        radioAcconsento.setChecked(false);

        Button registrati = (Button)view.findViewById(R.id.buttonRegistrati);

        // Fragment transaction fragment login
        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((login)getActivity()).cambiaFragment(new frag_login());
            }
        });

        return view;

        /*registrati.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view){
                if(editNome.getText().toString().isEmpty()||
                        editCognome.getText().toString().isEmpty()||
                        editCitta.getText().toString().isEmpty() ||
                        editDataDiNascita.getText().toString().isEmpty() ||
                        editTelefono.getText().toString().isEmpty() ||
                        editEmail.getText().toString().isEmpty() ||
                        editPassword.getText().toString().isEmpty()||
                        editConfermaPassword.getText().toString().isEmpty()){
                    Toast.makeText(frag_registrazione.this, "Compilare tutti i campi", Toast.LENGTH_LONG).show();
                }
                else if (editPassword.getText().toString() != editConfermaPassword.getText().toString()){
                    Toast.makeText(frag_registrazione.this, "La password non corrisponde", Toast.LENGTH_LONG).show();
                }
                else if(radioAcconsento.isUnhecked()){
                    Toast.makeText(frag_registrazione.this, "Confermare consenso per la trattazione dei dati", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intentReg = new Intent(frag_registrazione.this, AltraClasse.class);
                    startActivity(intentReg);
                    Toast.makeText(frag_registrazione.this, "Registrazione avvenuta con successo", Toast.LENGTH_LONG).show();
                }
            }
        });*/
}}
