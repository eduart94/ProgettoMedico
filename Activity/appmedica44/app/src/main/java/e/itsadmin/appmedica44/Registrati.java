package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Registrati extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati);
        final TextView titolo = (TextView) findViewById(R.id.id_titolo);
        final EditText nome = (EditText) findViewById(R.id.id_nome);
        final EditText cognome = (EditText) findViewById(R.id.id_cognome);
        final EditText email = (EditText) findViewById(R.id.id_email);
        final EditText password = (EditText) findViewById(R.id.id_password);
        final EditText conferma = (EditText) findViewById(R.id.id_conferma);
        final RadioButton autorizzo = (RadioButton) findViewById(R.id.id_autorizzo);
        final Button button1 = (Button) findViewById(R.id.id_button1);
        final Button haigiaaccount = (Button) findViewById(R.id.haigiaaccount);


        haigiaaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent accEsis = new Intent(Registrati.this, Login.class);
                // passo all'attivazione dell'activity Pagina.java
                startActivity(accEsis);
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().isEmpty()||cognome.getText().toString().isEmpty()||email.getText().toString().isEmpty()||password.getText().toString().isEmpty()||conferma.getText().toString().isEmpty())
                {
                    Toast.makeText(Registrati.this, "Compilare tutti i campi", Toast.LENGTH_LONG).show();
                }

                else
                {
                    Intent noReg = new Intent(Registrati.this, Login.class);
                    // passo all'attivazione dell'activity Pagina.java
                    startActivity(noReg);
                    Toast.makeText(Registrati.this, "Registrazione effettuata con successo. Conferma la registrazione cliccando nell' e-mail ricevuta", Toast.LENGTH_LONG).show();
                }
            }
        });


    }






}
