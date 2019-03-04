package com.example.samuel.dosactividadescontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_secundaria);

        Button bA= (Button) findViewById(R.id.buttonAceptarSec);

        //Se actuará según el String que reciba opcion.
        String opcion = getIntent().getStringExtra("opcion");

        switch (opcion){
            //Caso para el primer estado de la actividad principal.
            case "alta":
                //Pulsando el botón:
                bA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText e1 = (EditText) findViewById(R.id.editTextNombre);
                        EditText e2 = (EditText) findViewById(R.id.editTextApellidos);
                        //Se comprobará que ninguna de las cajas de texto están vacías.
                        // Si alguna lo está se mandará un mensaje Toast informativo.
                        if(e1.getText().toString().equals("") || e2.getText().toString().equals("")){
                            Toast toast1 = Toast.makeText(getApplicationContext(),"No puedes dejar ningún campo vacío.", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                        //Si ninguna esta vacía, se devolverán a la actividad principal los valores en las cajas de texto y se cerrará esta actividad.
                        else{
                            String vuelta="";
                            String opcion="alta";
                            vuelta=e1.getText().toString()+";"+e2.getText().toString();
                            Intent datos = new Intent();
                            // Metemos como datos extra del intent la respuesta del
                            // usuario.
                            datos.putExtra("vuelta", vuelta);
                            datos.putExtra("opcion", opcion);
                            setResult(RESULT_OK, datos);
                            finish();
                        }
                    }
                });
                break;
            //Caso para el segundo estado de la actividad principal.
            case "modificacion":
                //Se recogerán los datos que devuelve la actividad principal para rellenar las cajas de texto.
                EditText e1 = (EditText) findViewById(R.id.editTextNombre);
                EditText e2 = (EditText) findViewById(R.id.editTextApellidos);
                String nom;
                String ape;
                String [] splitter = getIntent().getStringExtra("nombre").split(": ");
                nom=splitter[1];
                splitter = getIntent().getStringExtra("apellidos").split(": ");
                ape=splitter[1];
                e1.setText(nom);
                e2.setText(ape);
                //Si se pulsa el botón:
                bA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText e1 = (EditText) findViewById(R.id.editTextNombre);
                        EditText e2 = (EditText) findViewById(R.id.editTextApellidos);
                        //Se comprueba, una vez haya podido el usuario modificar las cajas de texto, si están vacías o no.
                        // Si alguna lo está se mandará un mensaje Toast informativo.
                        if(e1.getText().toString().equals("") || e2.getText().toString().equals("")){
                            Toast toast1 = Toast.makeText(getApplicationContext(),"No puedes dejar ningún campo vacío.", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                        //Si ninguna esta vacía, se devolverán a la actividad principal los valores en las cajas de texto y se cerrará esta actividad.
                        else{
                            String vuelta="";
                            String opcion="mod";
                            vuelta=e1.getText().toString()+";"+e2.getText().toString();
                            Intent datos = new Intent();
                            // Metemos como datos extra del intent la respuesta del
                            // usuario.
                            datos.putExtra("vuelta", vuelta);
                            datos.putExtra("opcion",opcion);
                            setResult(RESULT_OK, datos);
                            finish();
                        }
                    }
                });
                break;
        }
    }

}
