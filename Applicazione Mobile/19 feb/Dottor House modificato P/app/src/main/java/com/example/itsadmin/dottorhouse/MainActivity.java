package com.example.itsadmin.dottorhouse;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.example.itsadmin.dottorhouse.database.DatabaseAdapter;
import com.example.itsadmin.dottorhouse.fragments.frag_home;
import com.example.itsadmin.dottorhouse.fragments.frag_profilo;
import com.example.itsadmin.dottorhouse.fragments.frag_ricerca;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Fragment [] vetFrag ;
    DatabaseAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vetFrag = new Fragment[3];

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inizializzaFragment();

        db = new DatabaseAdapter(MainActivity.this);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_home:

                                cambiaFragment(0);
                                getSupportActionBar().setTitle("Bacheca");

                                return true;
                            case R.id.nav_ricerca:

                                cambiaFragment(1);
                                getSupportActionBar().setTitle("Cerca");

                                return true;
                            case R.id.nav_profilo:

                                cambiaFragment(2);
                                getSupportActionBar().setTitle("Il mio profilo");

                                return true;
                        }
                        return false;
                    }
                });

        cambiaFragment(0);
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
