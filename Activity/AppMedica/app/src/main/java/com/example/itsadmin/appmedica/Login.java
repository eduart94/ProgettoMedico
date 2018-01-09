package com.example.itsadmin.appmedica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button haigiaaccount = findViewById(R.id.haigiaaccount);
        haigiaaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recupPasswordIntent = new Intent(Login.this, RecuperaPassword.class);
                startActivity(recupPasswordIntent);
            }
        });

    }
}
