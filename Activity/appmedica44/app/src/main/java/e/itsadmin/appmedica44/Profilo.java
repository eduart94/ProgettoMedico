package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profilo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);

        Button notifiche=(Button)findViewById(R.id.notifiche);
        Button profilo=(Button)findViewById(R.id.profilo);
        Button ricerca=(Button)findViewById(R.id.ricerca);



        ricerca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent ricerca = new Intent(Profilo.this,Ricerca.class);
                // passo all'attivazione dell'activity
                startActivity(ricerca);
            }

        });

        notifiche.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent notifiche = new Intent(Profilo.this,Notifiche.class);
                // passo all'attivazione dell'activity
                startActivity(notifiche);
            }



        });



    }
}
