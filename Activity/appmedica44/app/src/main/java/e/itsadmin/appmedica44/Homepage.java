package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homepage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        TextView benvenuto=(TextView)findViewById(R.id.benvenuto);
        final Button register=(Button) findViewById(R.id.register);
        TextView prenota=(TextView)findViewById(R.id.prenotazione);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent registers = new Intent(Homepage.this,Registrati.class);
                // passo all'attivazione dell'activity Recpass.java
                startActivity(registers);
            }

        });

        prenota.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent prenota = new Intent(Homepage.this,Login.class);
                // passo all'attivazione dell'activity Recpass.java
                startActivity(prenota);
            }

        });



    }
}
