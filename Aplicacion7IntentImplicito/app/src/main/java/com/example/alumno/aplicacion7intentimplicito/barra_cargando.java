package com.example.alumno.aplicacion7intentimplicito;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class barra_cargando extends AppCompatActivity {

    ProgressBar barraProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barra_cargando);
        barraProgreso=findViewById(R.id.progressBar);
        finish();
    }

}
