package com.example.samuel.dosactividadescontactos;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se declaran dos variables de tipo Button para trabajar con los botones de la app.
        Button bA= (Button) findViewById(R.id.botonAlta);
        Button bM= (Button) findViewById(R.id.botonModificar);

        //Si se pulsa el botón de Alta.
        bA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se llama a la actividad secundaria y se le manda el mensaje opcion.
                String resp="alta";
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("opcion", resp);
                startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
            }
        });

        //Si se pulsa el botón de Alta.
        bM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se llama a la actividad secundaria y se le mandan los mensajes de opcion,nombre y apellidos.
                TextView t = (TextView) findViewById(R.id.textoSinContactos);
                TextView t2 = (TextView) findViewById(R.id.textViewApellidos);
                String resp="modificacion";
                String nombre = t.getText().toString();
                String apellidos = t2.getText().toString();
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("opcion", resp);
                i.putExtra("nombre", nombre);
                i.putExtra("apellidos", apellidos);
                startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String respuesta="";

        //Si se cancela la operación de la actividad secundaria se mostrará un mensaje informativo de tipo Toast.
        if (resultCode == RESULT_CANCELED){
            respuesta = "Has salido de la subactividad sin pulsar el botón 'Aceptar'.";
            Toast toast1 = Toast.makeText(getApplicationContext(),respuesta, Toast.LENGTH_SHORT);
            toast1.show();
        }
        else {
            //Si se sale pulsando el botón de aceptar de la actividad secundaria mostraremos un mensaje informativo según el estado de la actividad principal.
            // Además cogeremos los datos que nos ha enviado y cambiaremos al segundo estado de la actividad principal.
            if(data.getStringExtra("opcion").equals("alta")) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Has dado de alta al contacto correctamente.", Toast.LENGTH_SHORT);
                toast1.show();
            }else
            {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Modificación del contacto hecha correctamente.", Toast.LENGTH_SHORT);
                toast1.show();
            }
            respuesta = data.getStringExtra("vuelta");
            TextView t = (TextView) findViewById(R.id.textoSinContactos);
            TextView t2 = (TextView) findViewById(R.id.textViewApellidos);
            Button bA= (Button) findViewById(R.id.botonAlta);
            Button bM= (Button) findViewById(R.id.botonModificar);

            String [] splitter = respuesta.split(";");
            t.setText("Nombre: "+splitter[0]);
            t2.setText("Apellidos: "+splitter[1]);
            bA.setEnabled(false);
            bM.setEnabled(true);
        }
    }
    private static final int SECONDARY_ACTIVITY_TAG = 1;
}
