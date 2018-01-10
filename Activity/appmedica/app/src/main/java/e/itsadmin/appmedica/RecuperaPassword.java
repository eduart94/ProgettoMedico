package e.itsadmin.appmedica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperaPassword extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera_password);
        final EditText Email=(EditText)findViewById(R.id.mailmodifica);
        Button but =(Button)findViewById(R.id.invia);


        Button button=(Button)findViewById(R.id.invia);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // definisco l'intenzione

                Intent button = new Intent(RecuperaPassword.this,Login.class);
                // passo all'attivazione dell'activity Recpass.java
                startActivity(button);
                Toast.makeText(RecuperaPassword.this,"prova",Toast.LENGTH_LONG).show();

    }
});
    }
}
