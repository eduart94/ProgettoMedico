package com.eduartbiba.progettomedico;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView lgn = (TextView)findViewById(R.id.login);
        TextView Email = (TextView)findViewById(R.id.email);
        EditText insem = (EditText)findViewById(R.id.insemail);
        TextView pass = (TextView)findViewById(R.id.password);
        EditText inspass = (EditText)findViewById(R.id.inspassword);
        Button passdim = (Button)findViewById(R.id.passdimenticata);
        Button nonreg = (Button)findViewById(R.id.nonregistrato);
        Button acced = (Button)findViewById(R.id.accedi);



    }
}
