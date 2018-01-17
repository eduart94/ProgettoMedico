package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView login=(TextView)findViewById(R.id.login);
        final TextView email=(TextView) findViewById(R.id.email);
        final TextView password=(TextView)findViewById(R.id.password);
        final Button passLost=(Button)findViewById(R.id.passlost);
        final Button NoReg=(Button)findViewById(R.id.noregistrazione);
        final Button Accesso=(Button)findViewById(R.id.accedi);
        final EditText InsEmail=(EditText)findViewById(R.id.insmail);
        final EditText InsPass=(EditText)findViewById(R.id.inspass);


        passLost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent recpass = new Intent(Login.this,RecuperaPassword.class);
                // passo all'attivazione dell'activity Recpass.java
                startActivity(recpass);
            }

            });


        NoReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent noReg = new Intent(Login.this,Registrati.class);
                // passo all'attivazione dell'activity Pagina.java
                startActivity(noReg);
            }
        });




            Accesso.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // definisco l'intenzione
                    Intent profile = new Intent(Login.this,Profilo.class);
                    // passo all'attivazione dell'activity Pagina.java
                    startActivity(profile);
                }
            });}
    }

