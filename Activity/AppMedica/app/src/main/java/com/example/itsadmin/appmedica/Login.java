package com.example.itsadmin.appmedica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends Activity {



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            Button nonRicordiPassword = findViewById(R.id.nonricordipassword);
            nonRicordiPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent nonRicordiPasswordIntent = new Intent(Login.this, RecuperaPassword.class);
                    startActivity(nonRicordiPasswordIntent);
                }
            });

            Button noRegistrazione = findViewById(R.id.noregistrazione);
            noRegistrazione.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent noRegistrazioneIntent = new Intent(Login.this, Registrati.class);
                    startActivity(noRegistrazioneIntent);
                }
            });


        }
    }





