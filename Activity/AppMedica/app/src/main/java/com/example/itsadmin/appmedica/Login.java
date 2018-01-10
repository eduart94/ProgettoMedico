package com.example.itsadmin.appmedica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends Activity {

<<<<<<< HEAD
=======
   public class MainActivity1 extends Activity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recupera_password);
            Button button2=(Button)findViewById(R.id.recuperapassword);
            button2.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    // definisco l'intenzione
                    Intent Recpass = new Intent(MainActivity1.this,RecuperaPassword.class);
                    // passo all'attivazione dell'activity Recpass.java
                    startActivity(Recpass);
                }
            });
        }
    }

    public class MainActivity2 extends Activity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registrati);
            Button Button3=(Button)findViewById(R.id.noregistrazione);
            Button3.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    // definisco l'intenzione
                    Intent NoReg = new Intent(MainActivity2.this,Registrati.class);
                    // passo all'attivazione dell'activity Pagina.java
                    startActivity(NoReg);
                }
            });
        }
    }

    public class MainActivity3 extends Activity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            Button login=(Button)findViewById(R.id.accedi);
            login.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    // definisco l'intenzione
                    Intent Profile = new Intent(MainActivity3.this,Profilo.class);
                    // passo all'attivazione dell'activity Pagina.java
                    startActivity(Profile);
                }
            });
        }
    }

>>>>>>> 69cc123106d82fed0a58bc52dd54258659af31ef
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
