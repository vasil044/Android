package com.example.alumno.apk8ficheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner opcion;
    TextView opcSelec;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opcion=(Spinner)findViewById(R.id.spinnerOpcion);
        opcSelec=(TextView)findViewById(R.id.textViewOpcSeleccionada);
        lista = (ListView)findViewById(R.id.miLista);

    }

    public void cargarPeces() throws IOException {
        List<String>nombrePeces=new ArrayList<String>();
        String linea;

        InputStream is = this.getResources().openRawResource(R.raw.peces);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null){
            while ((linea=reader.readLine())!=null){
                nombrePeces.add(linea.split(",")[0]);
            }
        }
        is.close();

        String[]datos=nombrePeces.toArray(new String[nombrePeces.size()]);
        ArrayAdapter<String>adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datos);
        lista.setAdapter(adaptador);
    }

    ///   Declaracion de variables   \\\

    ///   Declaracion de esteros que corresponden con las imagenes   \\\

    int atletismo = R.drawable.atletismo;
    int baloncesto = R.drawable.baloncesto;
    int futbol = R.drawable.futbol;
    int golf = R.drawable.golf;
    int pingpong = R.drawable.pingpong;
    int motociclismo = R.drawable.motociclismo;
    int natacion = R.drawable.natacion;

    ///   Declaracion del array   \\\

    final Opcion[] opc = new Opcion[7];
    opc[0]=(new Opcion("Futbol",futbol,false));
    opc[1]=(new Opcion("Pingpong",pingpong,false));
    opc[2]=(new Opcion("Motociclismo",motociclismo,false));
    opc[3]=(new Opcion("Atletismo",atletismo,false));
    opc[4]=(new Opcion("Natacion",natacion,false));
    opc[5]=(new Opcion("Golf",golf,false));
    opc[6]=(new Opcion("Baloncesto",baloncesto,false));

    //Array chekeados que corresponde con la posicion de los deportes
    final boolean[] check = new boolean[7];

    ///   Codigo   \\\

    final Deportes adaptador = new Deportes(this, opc);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast toast1 = Toast.makeText(getApplicationContext(), "seleccionado", Toast.LENGTH_SHORT);
            toast1.show();
            if (adaptador.getItem(i).getSeleccionado()) {
                adaptador.getItem(i).setSeleccionado(false);
                list.setAdapter(adaptador);
            } else {
                adaptador.getItem(i).setSeleccionado(true);
                list.setAdapter(adaptador);
            }
        }
    });
        boton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            int contador1=0;
            int contador=0;
            boolean checkeado = false;

            //Pone a false el array de chekeados
            for (int i = 0; i < check.length; i++) {
                check[i]=false;
            }

            for (int i = 0; i < 7; i++) {
                if (adaptador.getItem(i).getSeleccionado()) {
                    checkeado = true;
                    check[i]=true;
                    contador++;
                }
            }
            Toast toast1;
            String gusto = "Te gusta ";
            if (checkeado){
                for (int i = 0; i < check.length; i++) {
                    if (check[i]==true){
                        contador1++;
                        if (i==4) {
                            gusto = gusto + "la " +adaptador.getItem(i).getNombre();
                        }else{
                            gusto = gusto + "el " +adaptador.getItem(i).getNombre();
                        }
                        if (contador-1==contador1){
                            gusto=gusto + " y ";
                        }else if (contador==contador1){
                            gusto=gusto + ". ";
                        }else {
                            gusto=gusto + ", ";
                        }
                    }
                }
                toast1 = Toast.makeText(getApplicationContext(), gusto, Toast.LENGTH_SHORT);
                toast1.show();
            }else {
                toast1 = Toast.makeText(getApplicationContext(), "No has seleccionado nada", Toast.LENGTH_SHORT);
                toast1.show();
            }
        }
    });


    public void seleccionarOpcion(){
        if(opcion.getSelectedItemPosition()==0){
            opcSelec.setText("Peces");
        }else{
            opcSelec.setText("Algas e invertebrados");
        }
    }
}
