package com.example.samuel.faunamarina;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentListado.FMarinaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado frgListado =
                (FragmentListado) getSupportFragmentManager()
                        .findFragmentById(R.id.FrgListado);

        frgListado.setFMarinaListener(this);
    }

    @Override
    public void onFMarinaSeleccionado(FMarina fm) {

        if(findViewById(R.id.FrgDetalle) != null) {
            ((FragmentDetalles)getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarDetalle(String.valueOf(fm.getRef()));
        }
        else {
            Intent i = new Intent(this, MainActivity2.class);
            i.putExtra(MainActivity2.EXTRA_TEXTO,fm.getRef());
            startActivity(i);
        }
    }
}
