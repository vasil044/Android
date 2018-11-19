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
    Opcion[]peces=new Opcion[26];
    Opcion[]algas=new Opcion[22];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcion=(Spinner)findViewById(R.id.spinnerOpcion);
        opcSelec=(TextView)findViewById(R.id.textViewOpcSeleccionada);
        lista = (ListView)findViewById(R.id.miLista);

        seleccionarOpcion();


    }

    public void seleccionarOpcion() {
        opcion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (opcion.getSelectedItemPosition() == 0) {
                    opcSelec.setText("Peces");
                } else {
                    opcSelec.setText("Algas e invertebrados");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void cargarPeces() throws IOException {
        String nom;
        String nomLat;
        /*
        List<String>nombrePeces=new ArrayList<String>();
        List<String>nombreLatPeces=new ArrayList<String>();
        List<String>longitudPeces=new ArrayList<String>();
        List<String>habitadPeces=new ArrayList<String>();
        */
        String linea;
        int cont=0;

        InputStream is = this.getResources().openRawResource(R.raw.peces);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null){
            while ((linea=reader.readLine())!=null&&cont<26){
                nombrePeces.add(linea.split(",")[0]);
                nombreLatPeces.add(linea.split(",")[1]);
                longitudPeces.add(linea.split(",")[2]);
                habitadPeces.add(linea.split(",")[3]);
                peces[cont]=(new Opcion(i, words[1], words[2], words[3], words[4]));
                cont++;
            }
        }
        is.close();

        String[]datos=nombrePeces.toArray(new String[nombrePeces.size()]);
        ArrayAdapter<String>adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datos);
        lista.setAdapter(adaptador);
    }
}

/*
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
    */

    /*
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         spinner = (Spinner)findViewById(R.id.spinner);
         listaOpciones = (ListView)findViewById(R.id.lstvw);
        // Creamos los objetos y los guardamos en un array

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                peces(position);

                listaOpciones.setAdapter(adaptador);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void peces(int position){
        try {
            if(position==0){
                is = getResources().openRawResource(R.raw.peces);
            }else if(position == 1){
                is = getResources().openRawResource(R.raw.algaseinvertebrados);
            }

        bf = new BufferedReader(new InputStreamReader(is));
        String linea;
        int i,bab = 0;
        while ( (linea = bf.readLine())!= null) {
            String words[] = linea.split(",");
            i = getResources().getIdentifier(words[0],"drawable",getPackageName());
            if(bab == 0 ){ //La existencia de esta condición se debe a que sin ella la imagen de la babosa no la introduce
                i = R.drawable.babosa;// no se donde puede estar el error, si lo encuentras, dímelo por favor.
                bab++;// Como la babosa es la primera linea, lo he dejado así en plan chapuza.
            }
            datos.add(new Data(i, words[1], words[2], words[3], words[4]));

        }
            adaptador = new Adapter(this,datos);
        }catch (Exception e){}
    }
}
     */

