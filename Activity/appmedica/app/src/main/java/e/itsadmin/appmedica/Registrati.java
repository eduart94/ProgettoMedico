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
        final TextView haigiaaccount=(TextView)findViewById(R.id.passlost);

    }
}
