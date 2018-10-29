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

    TextView txv,txv2,nombre,apellido,vacio;
    Button boton,boton2;
    Intent i;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv = (TextView)findViewById(R.id.textView9);
        txv2 = (TextView)findViewById(R.id.textView11);
        nombre = (TextView)findViewById(R.id.textViewApellidos2);
        apellido = (TextView)findViewById(R.id.textView10);
        vacio = (TextView)findViewById(R.id.textView12);
        i = new Intent(this, ModificarContacto.class);
        boton = (Button)findViewById(R.id.button);
        boton2 = (Button)findViewById(R.id.buttonModificarContacto);
        boton2.setEnabled(false);
        nombre.setVisibility(INVISIBLE);
        apellido.setVisibility(INVISIBLE);
        txv.setVisibility(INVISIBLE);
        txv2.setVisibility(INVISIBLE);
    }
    public void Modificar(View v){
        if(v.getId()==R.id.buttonModificarContacto) {
            String s = txv.getText().toString();
            String s2 = txv2.getText().toString();
            i.putExtra("p1", s);
            i.putExtra("p2", s2);
        }
        i.putExtra("id", v.getId());
        startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String respuesta;
        String respuesta2;

        // Como solo lanzamos una actividad, requestCode siempre será
        // SECONDARY_ACTIVITY_TAG. No hace falta que lo comprobemos.

        if (resultCode==RESULT_OK) {
            // Tenemos una respuesta. La recuperamos del intent que nos
            // ha llegado desde la segunda actividad.
            respuesta = data.getStringExtra("nom");
            respuesta2 = data.getStringExtra("apellido");
            if(!(respuesta.equals("")||respuesta2.equals(""))) {
                nombre.setVisibility(VISIBLE);
                apellido.setVisibility(VISIBLE);
                txv.setVisibility(VISIBLE);
                txv2.setVisibility(VISIBLE);
                vacio.setVisibility(INVISIBLE);
                toast = Toast.makeText(this,"Datos insertados correctamente",Toast.LENGTH_SHORT);
                toast.show();
                txv.setText(respuesta);
                txv2.setText(respuesta2);
                boton.setEnabled(false);
                boton2.setEnabled(true);
            }else{
                toast = Toast.makeText(this,"No has rellenado los dos campos",Toast.LENGTH_SHORT);
                toast.show();
            }

        }else{

            toast = Toast.makeText(this,"Has salido de la actividad sin pulsar el boton Aceptar",Toast.LENGTH_SHORT);
            toast.show();
        }

    } // onActivityResult
    /**
     * "Etiqueta" que usamos para llamar a la segunda actividad, y que
     * esperamos recibir como primer parámetro de vuelta en el
     * callback onActivityResult().
     */
    private static final int SECONDARY_ACTIVITY_TAG = 1;
}
