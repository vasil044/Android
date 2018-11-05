package com.example.alumno.aplicacion7intentimplicito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int SECONDARY_ACTIVITY_TAG = 1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = new Intent(this, barra_cargando.class);
    }

    public void cargar(View v){
        i.putExtra("id", v.getId());
        startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
    }

}
