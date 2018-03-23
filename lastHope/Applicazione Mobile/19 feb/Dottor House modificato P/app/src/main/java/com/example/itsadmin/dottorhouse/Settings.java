package com.example.itsadmin.dottorhouse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        TextView txtImp = (TextView)findViewById(R.id.impostazione);
        TextView txtNome = (TextView)findViewById(R.id.nomeSett);
        TextView txtCognome = (TextView)findViewById(R.id.cognomeSett);
        TextView txtEmail = (TextView)findViewById(R.id.emailSett);
        TextView txtModifica = (TextView)findViewById(R.id.textModifica);

        txtNome.setText(getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("NomeUtente", null));
        txtCognome.setText(getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("CognomeUtente", null));
        txtEmail.setText(getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("EmailUtente", null));

        EditText txtEmailAtt = (EditText)findViewById(R.id.textEmailAtt);
        EditText txtEmailNew = (EditText)findViewById(R.id.textEmailNew);
        Button btnConferma = (Button) findViewById(R.id.btnConfermaEmail);

        TextView txtModificaPass = (TextView)findViewById(R.id.textModificaPass);
        EditText txtPassAtt = (EditText)findViewById(R.id.txtPassAtt);
        EditText txtPssNew = (EditText)findViewById(R.id.modificaPassNew);
        Button btnConfermaPss = (Button) findViewById(R.id.btnConfermaPass);


        Button btnBackMain = (Button)findViewById(R.id.backMian);

        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backMain = new Intent(Settings.this,MainActivity.class);
                startActivity(backMain);
            }
        });


    }
}
