package com.example.samuel.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Samuel on 13/03/2018.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        //Instancio los elementos de la actividad.
        final Spinner spin = (Spinner) findViewById(R.id.spinner2a);
        ImageView imagen = (ImageView) findViewById(R.id.imageView);
        Button boton = (Button) findViewById(R.id.button2a);
        //Inicializo el spinner.
        inicializarSpinner(spin);
        //Cojo el valor que me envia la primera actividad.
        int ref = getIntent().getIntExtra("ref",0);
        //Le meto la referencia de la imagen a mi Imagen.
        imagen.setImageResource(ref);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent datos = new Intent();
                // Metemos como datos extra del intent la respuesta del
                // usuario.
                String vuelta = (String) spin.getSelectedItem();
                datos.putExtra("vuelta", vuelta);
                setResult(RESULT_OK, datos);
                finish();
            }
        });
        //Meto un acción al cambiar de opción en el Spinner.
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String vuelta = (String) spin.getSelectedItem();
                Toast.makeText(SecondActivity.this, "Has seleccionado: "+vuelta, Toast.LENGTH_SHORT).show();
            }
            @Override
            //Si no se selecciona nada en el Spinner, no se hará nada.
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(SecondActivity.this, "No has seleccionado nada.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void inicializarSpinner(Spinner s){
        String [] array = {"Gracias","No es la que quería","Adiós","Hasta luego"};
        s.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array));
    }
}
