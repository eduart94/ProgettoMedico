package com.example.itsadmin.dottorhouse;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.itsadmin.dottorhouse.fragments.frag_login;

public class login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // si gestisce la toolbar

        // setta come fragment iniziale il fragment login
        cambiaFragment(new frag_login());

    }
    public void cambiaFragment(Fragment frm){

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenitoreLogin,frm);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        try{
            if(getIntent().getExtras().getInt("from")==1){

            finishAffinity();
        }
        } catch (NullPointerException e){
            super.onBackPressed();
        }

    }
}
