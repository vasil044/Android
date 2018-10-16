package com.example.alumno.listviewpractica4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = (ListView)findViewById(R.id.miLista);
        Button boton = (Button) findViewById(R.id.botonAceptar);

        int atletismo = R.drawable.atletismo;
        int baloncesto = R.drawable.baloncesto;
        int futbol = R.drawable.futbol;
        int golf = R.drawable.golf;
        int pingpong = R.drawable.pingpong;
        int motociclismo = R.drawable.motociclismo;
        int natacion = R.drawable.natacion;

        final Opcion[] opc = new Opcion[7];
        opc[0]=(new Opcion("Baloncesto",baloncesto,false));
        opc[1]=(new Opcion("Futbol",futbol,false));
        opc[2]=(new Opcion("Motociclismo",motociclismo,false));
        opc[3]=(new Opcion("Natacion",natacion,false));
        opc[4]=(new Opcion("Golf",golf,false));
        opc[5]=(new Opcion("Atletismo",atletismo,false));
        opc[6]=(new Opcion("Pingpong",pingpong,false));


        final Deportes adaptador = new Deportes(this, opc);

        list.setAdapter(adaptador);

        list.setOnItemClickListener((adapterView, view, i, 1){

            Toast toast1 = Toast.makeText(getApplicationContext(),"seleccionado", Toast.LENGTH_SHORT);
            toast1.show();

            if(adaptador.getItem(i).getSeleccionado()) {

                adaptador.getItem(i).setSeleccionado(false);
                list.setAdapter(adaptador);

            }else{

                adaptador.getItem(i).setSeleccionado(true);
                list.setAdapter(adaptador);

            }
        });

        boton.setOnClickListener(view){
            boolean checkeado = false;
            String gusto = "Te gusta ";

            for (int i = 0; i < 7; i++) {

                if (adaptador.getItem(i).getSeleccionado()){

                    checkeado = true;

                    if (i!=3){

                        gusto = gusto + "el " + adaptador.getItem(i).getNombre() + ",";

                    }else{

                        gusto = gusto + "la " + adaptador.getItem(i).getNombre() + ",";

                    }
                }

            }

            Toast toast1;

            if (checkeado){

                String[] splitter = gusto.split(",");

                for (int i = 0; i < splitter.length; i++) {

                    if (i==0){

                        gusto=splitter[i];

                        if (splitter.length==1){

                            gusto=gusto + ".";

                        }
                    }

                    if (splitter.length!=1) {

                        if (i != 0) {

                            gusto = gusto + splitter[i];

                        }
                        if (i == splitter.length - 2) {

                            gusto = gusto + " y ";
                        } else {

                            if (i == splitter.length - 1) {

                                gusto = gusto + ".";

                            } else {

                                gusto = gusto + " ,";

                            }
                        }
                    }
                }
                toast1 = Toast.makeText(getApplicationContext(), gusto, Toast.LENGTH_SHORT);
                toast1.show();
            }else{
                toast1 = Toast.makeText(getApplicationContext(), "No has seleccionado nada", Toast.LENGTH_SHORT);
            }
        });
    }
}
