package e.itsadmin.appmedica44;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Date;

public class Dettagli extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettagli);
        final Button buttonCanc = (Button)findViewById(R.id.buttonCanc);

        /*buttonCanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 TextView data = (TextView) findViewById(R.id.dataSpecifica);
                if((data - curdate)>48){

            }
        });
    }

}
