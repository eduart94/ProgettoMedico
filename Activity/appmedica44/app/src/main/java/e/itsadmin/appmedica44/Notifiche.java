package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifiche extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifiche);
        Button notifiche=(Button)findViewById(R.id.notifiche);
        Button profilo=(Button)findViewById(R.id.profilo);
        Button ricerca=(Button)findViewById(R.id.ricerca);
        Button recensisci=(Button)findViewById(R.id.buttonFeedback);


        ricerca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent ricerca = new Intent(Notifiche.this,Ricerca.class);
                // passo all'attivazione dell'activity Recpass.java
                startActivity(ricerca);
            }

        });

        profilo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent profilo = new Intent(Notifiche.this,Profilo.class);
                // passo all'attivazione dell'activity
                startActivity(profilo);
            }



        });

        recensisci.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent recensione = new Intent(Notifiche.this,Recensione.class);
                // passo all'attivazione dell'activity
                startActivity(recensione);
            }



        });

    }
}
