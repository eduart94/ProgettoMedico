package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

public class Ricerca extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca);
        Button notifiche=(Button)findViewById(R.id.notifiche);
        Button profilo=(Button)findViewById(R.id.profilo);
  //      Button ricerca=(Button)findViewById(R.id.ricerca);
        Button butcertop=(Button)findViewById(R.id.buttonCercaTop);
        Button butcerbott=(Button)findViewById(R.id.buttonCercaBottom);
        EditText cercaMedico=(EditText)findViewById(R.id.cercaMedico);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        MultiAutoCompleteTextView completamento=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

        notifiche.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent notifiche = new Intent(Ricerca.this,Notifiche.class);
                // passo all'attivazione dell'activity Recpass.java
                startActivity(notifiche);
            }

        });

        profilo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent profilo = new Intent(Ricerca.this,Profilo.class);
                // passo all'attivazione dell'activity
                startActivity(profilo);
            }

        });


    }
}
