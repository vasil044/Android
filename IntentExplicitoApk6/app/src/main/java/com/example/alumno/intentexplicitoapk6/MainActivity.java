package com.example.alumno.intentexplicitoapk6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    TextView nombre,apellido,vacio;
    Button botonAlta,botonMod;
    Intent i;
    Toast toast;
    String nom;
    String ape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (TextView)findViewById(R.id.textViewNombre);
        apellido = (TextView)findViewById(R.id.textViewApellidos);
        vacio = (TextView)findViewById(R.id.textViewContactoVacio);
        i = new Intent(this, ModificarContacto.class);
        botonAlta = (Button)findViewById(R.id.buttonAltaContacto);
        botonMod = (Button)findViewById(R.id.buttonModificarContacto);
        botonMod.setEnabled(false);
        nombre.setVisibility(INVISIBLE);
        apellido.setVisibility(INVISIBLE);
    }
    public void modificar(View v){
        if(v.getId()==R.id.buttonModificarContacto) {
            i.putExtra("p1", nom);
            i.putExtra("p2", ape);
        }
        i.putExtra("id", v.getId());
        startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String respuesta;
        String respuesta2;

        if (resultCode==RESULT_OK) {
            respuesta = data.getStringExtra("nom");
            respuesta2 = data.getStringExtra("apellido");
            if(!(respuesta.equals("")||respuesta2.equals(""))) {
                nombre.setVisibility(VISIBLE);
                apellido.setVisibility(VISIBLE);
                vacio.setVisibility(INVISIBLE);
                toast = Toast.makeText(this,"Datos insertados correctamente",Toast.LENGTH_SHORT);
                toast.show();
                nombre.setText("Nombre: " + respuesta);
                nom=respuesta;
                apellido.setText("Apellido: " + respuesta2);
                ape=respuesta2;
                botonAlta.setEnabled(false);
                botonMod.setEnabled(true);
            }else{
                toast = Toast.makeText(this,"No has rellenado los dos campos",Toast.LENGTH_SHORT);
                toast.show();
            }
        }else{
            toast = Toast.makeText(this,"Has salido de la actividad sin pulsar el boton Aceptar",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    private static final int SECONDARY_ACTIVITY_TAG = 1;
}
