package com.example.alumno.aplicacion9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Spinner opcion;
    TextView opcSelec;
    ListView lista;
    Opcion[] peces = new Opcion[26];
    Opcion[] algas = new Opcion[22];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcion = (Spinner) findViewById(R.id.spinnerOpcion);
        opcSelec = (TextView) findViewById(R.id.textViewOpcSeleccionada);
        lista = (ListView) findViewById(R.id.miLista);

        seleccionarOpcion();

    }

    public void seleccionarOpcion() {
        opcion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (opcion.getSelectedItemPosition() == 0) {
                    opcSelec.setText("Peces");
                    try {
                        cargarPeces();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    opcSelec.setText("Algas e invertebrados");
                    try {
                        cargarAlgas();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
        String longi;
        String habit;
        String linea;
        String imag;
        int imagen;
        int cont = 0;

        InputStream is = this.getResources().openRawResource(R.raw.peces);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is != null) {
            while ((linea = reader.readLine()) != null && cont < 26) {
                imag = (linea.split(",")[0]);
                nom = (linea.split(",")[1]);
                nomLat = (linea.split(",")[2]);
                longi = (linea.split(",")[3]);
                habit = (linea.split(",")[4]);
                imagen = getResources().getIdentifier(imag, "drawable", getPackageName());
                peces[cont] = (new Opcion(nom, nomLat, longi, habit, imagen));
                cont++;
            }
        }
        is.close();

        final Peces adaptador = new Peces(this, peces);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "seleccionado", Toast.LENGTH_SHORT);
                toast1.show();
                //mostrarInformacion(null, adaptador.getItem(i).getIcono(),adaptador.getItem(i).getNombre());
                /*
                if (adaptador.getItem(i).getSeleccionado()) {
                    adaptador.getItem(i).setSeleccionado(false);
                    list.setAdapter(adaptador);
                } else {
                    adaptador.getItem(i).setSeleccionado(true);
                    list.setAdapter(adaptador);
                }
                */
            }
        });
    }

    public void cargarAlgas() throws IOException {
        String nom;
        String nomLat;
        String longi;
        String habit;
        String linea;
        String imag;
        int imagen;
        int cont = 0;


        InputStream is = this.getResources().openRawResource(R.raw.algas);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is != null) {
            while ((linea = reader.readLine()) != null && cont < 22) {
                imag = (linea.split(",")[0]);
                nom = (linea.split(",")[1]);
                nomLat = (linea.split(",")[3]);
                longi = (linea.split(",")[4]);
                habit = (linea.split(",")[5]);
                imagen = getResources().getIdentifier(imag, "drawable", getPackageName());
                algas[cont] = (new Opcion(nom, nomLat, longi, habit, imagen));
                cont++;
            }
        }
        is.close();

        final Peces adaptador = new Peces(this, algas);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Seleccionado", Toast.LENGTH_SHORT);
                toast1.show();
                //mostrarInformacion(null, adaptador.getItem(i).getIcono(),adaptador.getItem(i).getNombre());
            }
        });
    }
    /*
    public void mostrarInformacion(View view, int img, String nom){
        Intent i = new Intent(this, AbrirInfromacion.class);
        ImageView imagen=(ImageView)findViewById(R.id.imageViewMarisco);
        TextView nombre=(TextView)findViewById(R.id.textViewNombre);
        imagen.setImageResource(img);
        nombre.setText(nom);
        startActivity(i);
    }*/
}


