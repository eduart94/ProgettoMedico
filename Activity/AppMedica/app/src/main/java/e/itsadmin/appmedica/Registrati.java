package e.itsadmin.appmedica;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Registrati extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati);
        final TextView titolo=(TextView)findViewById(R.id.id_titolo);
        final EditText nome=(EditText)findViewById(R.id.id_nome);
        final EditText cognome=(EditText)findViewById(R.id.id_cognome);
        final EditText email=(EditText)findViewById(R.id.id_email);
        final EditText password=(EditText)findViewById(R.id.id_password);
        final EditText conferma=(EditText)findViewById(R.id.id_conferma);
        final RadioButton autorizzo=(RadioButton)findViewById(R.id.id_autorizzo);
        final Button button1=(Button)findViewById(R.id.id_button1);
<<<<<<< HEAD:Activity/AppMedica/app/src/main/java/e/itsadmin/appmedica/Registrati.java
<<<<<<< HEAD:Activity/AppMedica/app/src/main/java/e/itsadmin/appmedica/Registrati.java
=======
>>>>>>> 41a2349d61294f78a4d71cda60d08b53f7ffcd9b:Activity/AppMedica/app/src/main/java/e/itsadmin/appmedica/Registrati.java
<<<<<<< HEAD:Activity/appmedica/app/src/main/java/e/itsadmin/appmedica/Registrati.java
        final TextView haigiaaccount=(TextView)findViewById(R.id.passlost);
=======
        final TextView haigiaaccount=(TextView)findViewById(R.id.nonricordipassword);


        Button haiGiaAccount = findViewById(R.id.haigiaaccount);
        haiGiaAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent haiGiaAccountIntent = new Intent(Registrati.this, Login.class);
                startActivity(haiGiaAccountIntent);
            }
        });
>>>>>>> c392f63a19f207805e57e8a522663651f5a804d2:Activity/AppMedica/app/src/main/java/com/example/itsadmin/appmedica/Registrati.java
<<<<<<< HEAD:Activity/AppMedica/app/src/main/java/e/itsadmin/appmedica/Registrati.java
=======
        final TextView haigiaaccount=(TextView)findViewById(R.id.haigiaaccount);
>>>>>>> parent of 8eb8931... fatto gli intent dei bottoni:Activity/AppMedica/app/src/main/java/com/example/itsadmin/appmedica/Registrati.java
=======
>>>>>>> 41a2349d61294f78a4d71cda60d08b53f7ffcd9b:Activity/AppMedica/app/src/main/java/e/itsadmin/appmedica/Registrati.java

    }
}
