package com.example.alumno.intentexplicitoapk6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ModificarContacto extends AppCompatActivity {

    String r1,r2;
    TextView textViewApe,textViewNom,textViewMod;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_contacto_activity);
        textViewNom = (TextView)findViewById(R.id.editTextNombre);
        textViewApe = (TextView)findViewById(R.id.editTextApellidos);
        textViewMod = (TextView)findViewById(R.id.textViewModificar2);
        id=getIntent().getIntExtra("id",0);
        if(id==R.id.buttonModificarContacto) {
            textViewMod.setText("Modificar contacto, cambia el nombre y los apellidos");
            r1 = getIntent().getStringExtra("p1");
            r2 = getIntent().getStringExtra("p2");
            textViewNom.setText(r1);
            textViewApe.setText(r2);
        }
    }
    public void respuesta(View v){

        Intent datos = new Intent();
        String nom,apellido;
        nom = textViewNom.getText().toString();
        apellido = textViewApe.getText().toString();
        datos.putExtra("nom",nom);
        datos.putExtra("apellido",apellido);
        setResult(RESULT_OK,datos);
        finish();
    }
}
