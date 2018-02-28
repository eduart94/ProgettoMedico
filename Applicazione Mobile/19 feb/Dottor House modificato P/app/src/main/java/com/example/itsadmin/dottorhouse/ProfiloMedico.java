package com.example.itsadmin.dottorhouse;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfiloMedico extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getExtra -> nomeMedico
        // query per ottenere tutti i dati del medico con quel nome
        // e con i risultati si compilano tutti i campi

        setContentView(R.layout.activity_prfilo_medico);
        ImageView im = (ImageView)findViewById(R.id.profilePicMedico);
        TextView textNomeMedico = (TextView)findViewById(R.id.nomeMedico);
        TextView textCognomeMedico = (TextView)findViewById(R.id.cognomeMedico);
        TextView textEmailMedico = (TextView)findViewById(R.id.emailMedico);
        TextView textTelefonoMedico = (TextView)findViewById(R.id.telefonoMedico);
        TextView textTipologia = (TextView)findViewById(R.id.tipologia_medico);
        TextView textLuogoMedico = (TextView)findViewById(R.id.luogo_medico);
    }
}
