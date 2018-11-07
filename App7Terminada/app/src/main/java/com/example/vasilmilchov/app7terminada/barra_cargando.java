package com.example.vasilmilchov.app7terminada;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

public class barra_cargando extends AppCompatActivity {

    ProgressBar barraProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barra_cargando);
        barraProgreso=findViewById(R.id.progressBar);
        Toast toast1 = Toast.makeText(getApplicationContext(),"Completado", Toast.LENGTH_SHORT);
        /*
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        toast1.show();
        finish();
    }

}
