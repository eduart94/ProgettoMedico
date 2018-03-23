package com.example.itsadmin.dottorhouse;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.StyleableRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import com.example.itsadmin.dottorhouse.database.DatabaseHelper;
import com.example.itsadmin.dottorhouse.fragments.frag_home;
import com.example.itsadmin.dottorhouse.fragments.frag_profilo;
import com.example.itsadmin.dottorhouse.fragments.frag_ricerca;
import com.example.itsadmin.dottorhouse.models.ModelMedico;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Fragment [] vetFrag ;
    //DatabaseAdapter db;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vetFrag = new Fragment[3];

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        inizializzaFragment();

        //db = new DatabaseAdapter(MainActivity.this);
		
		  Button btnSettings = (Button)findViewById(R.id.settings);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Settings.class);
                startActivity(intent);

            }
        });

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_home:

                                cambiaFragment(0);
                                getSupportActionBar().setTitle("Home");

                                return true;
                            case R.id.nav_ricerca:

                                cambiaFragment(1);
                                getSupportActionBar().setTitle("Cerca");

                                return true;
                            case R.id.nav_profilo:

                                cambiaFragment(2);
                                getSupportActionBar().setTitle("Il mio profilo");

                                return true;

                            case R.id.logout:
                                Esci();
                                getSupportActionBar();

                        }
                        return false;
                    }
                });

        cambiaFragment(0);


//        db.addmedico(new ModelMedico("Luca","gigi","luca@gmail.com","333","dentista","Firenze","via magenta"));
//        db.addmedico(new ModelMedico("laura","rossi","Max@gmail.com","222","pediatra","milano","via rossi"));
//        db.addmedico(new ModelMedico("Alex","Rio","SPIA@hotmail.it","1111","medico di base","magenta","via novara"));
//        db.addmedico(new ModelMedico("Anna","Maria","anna@it","023455","medico di base","novara","via firenze"));
    }

    private void Esci() {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.popup_logout);
        dialog.setTitle("Logout");

        Button btnOk = (Button)dialog.findViewById(R.id.btnOK);
        Button btnAnnulla = (Button)dialog.findViewById(R.id.btnAnnulla);

        btnAnnulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent logout = new Intent(MainActivity.this, login.class);
                logout.putExtra("from", 1);
                startActivity(logout);

                Toast.makeText(MainActivity.this,"hai effettuato il logout",Toast.LENGTH_LONG).show();
                dialog.hide();

            }
        });

        dialog.show();

    }

    public void inizializzaFragment (){

        vetFrag[0] = new frag_home();
        vetFrag[1] = new frag_ricerca();
        vetFrag[2] = new frag_profilo();
    }

    public void cambiaFragment(int frag){

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenitore,vetFrag[frag]);
        transaction.commit();
    }
}
