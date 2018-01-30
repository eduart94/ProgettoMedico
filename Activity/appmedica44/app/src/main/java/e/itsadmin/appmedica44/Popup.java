package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by itsadmin on 18/01/2018.
 */

public class Popup extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_layout);
        Button conferma =(Button)findViewById(R.id.conferma);
        TextView recensione =(TextView)findViewById(R.id.recensione);
        RatingBar stelle =(RatingBar)findViewById(R.id.stelle);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent conferma = new Intent(Popup.this, Notifiche.class);
                // passo all'attivazione dell'activity Pagina.java
                startActivity(conferma);
                Toast.makeText(Popup.this, "Recensione inviata", Toast.LENGTH_LONG).show();
                                        }
        });



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
    }
}

