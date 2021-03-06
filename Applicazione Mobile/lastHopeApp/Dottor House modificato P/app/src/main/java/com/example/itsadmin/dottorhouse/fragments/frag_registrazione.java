package com.example.itsadmin.dottorhouse.fragments;

import android.app.Activity;
import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.MainActivity;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.database.DatabaseAdapter;
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

        ImageView iconNome = (ImageView)view.findViewById(R.id.iconNome);
        ImageView iconCognome = (ImageView)view.findViewById(R.id.iconCognome);
        ImageView iconCitta = (ImageView)view.findViewById(R.id.iconCity);
        ImageView iconDataDiNascita = (ImageView)view.findViewById(R.id.iconData);
        ImageView iconTel = (ImageView)view.findViewById(R.id.iconTel);
        ImageView iconEmail = (ImageView)view.findViewById(R.id.iconEmail);
        ImageView iconPass = (ImageView)view.findViewById(R.id.iconPass);
        ImageView iconConfermaPass = (ImageView)view.findViewById(R.id.iconConPass);


        final RadioButton radioAcconsento = (RadioButton)view.findViewById(R.id.radioAcconsento);
        radioAcconsento.setChecked(false);

        Button registrati = (Button)view.findViewById(R.id.buttonRegistrati);
        ImageButton buttonGoBack = (ImageButton)view.findViewById(R.id.goBack);

        //button torna indietro.

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((login)getActivity()).cambiaFragment(new frag_login());
            }
        });


        // Fragment transaction fragment login

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view){
                if(editNome.getText().toString().isEmpty()||
                        editCognome.getText().toString().isEmpty()||
                        editCitta.getText().toString().isEmpty() ||
                        editDataDiNascita.getText().toString().isEmpty() ||
                        editTelefono.getText().toString().isEmpty() ||
                        editEmail.getText().toString().isEmpty() ||
                        editPassword.getText().toString().isEmpty()||
                        editConfermaPassword.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(),"Compilare tutti i campi", Toast.LENGTH_LONG).show();

                }
                else if (!(editPassword.getText().toString().equals(editConfermaPassword.getText().toString()))){
                    Toast.makeText(getActivity(), "La password non corrisponde", Toast.LENGTH_LONG).show();
                }
                else if (radioAcconsento.isChecked()== false) {
                    Toast.makeText(getActivity(), "Confermare consenso per la trattazione dei dati", Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(getActivity(), "Registrazione effettuata", Toast.LENGTH_LONG).show();
                    ((login)getActivity()).cambiaFragment(new frag_login());
                }
            }
        });
        return view;
    }
}