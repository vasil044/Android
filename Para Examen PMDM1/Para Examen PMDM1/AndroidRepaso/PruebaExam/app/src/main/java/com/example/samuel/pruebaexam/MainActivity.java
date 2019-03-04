package com.example.samuel.pruebaexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    TextView nameR;
    TextView ccR;
    TextView districtR;
    TextView populationR;
    TextView nameW;
    TextView ccW;
    TextView districtW;
    TextView populationW;
    EditText editText;
    BDManager manager;
    Button boton;
    CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializamos los valores de todos los elementos de la app.
        nameR = (TextView) findViewById(R.id.textViewName);
        ccR = (TextView) findViewById(R.id.textViewCountryCode);
        districtR = (TextView) findViewById(R.id.textViewDistrict);
        populationR = (TextView) findViewById(R.id.textViewPopulation);
        nameW = (TextView) findViewById(R.id.nametxt);
        ccW = (TextView) findViewById(R.id.cctxt);
        districtW = (TextView) findViewById(R.id.districttxt);
        populationW = (TextView) findViewById(R.id.populationtxt);
        list = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText1a);
        boton = (Button) findViewById(R.id.button1a);
        //Escondo los textos innecesarios.
        inicializarTextViews();
        //Instancio los gestores de las bases de datos.
        manager = new BDManager(this);
        manager.conectado(this);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Saco el texto del editText.
                String nombre=editText.getText().toString();
                ArrayList<City> al = new ArrayList<>();
                al = manager.volcarDatosAL(nombre);
                adapter = new CityAdapter(MainActivity.this,al);
                list.setAdapter(adapter);
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                City c = adapter.getItem(i);
                mostrarValores(c);
            }
        });
    }

    //Hago todo invisible.
    public void inicializarTextViews(){
        nameR.setVisibility(View.INVISIBLE);
        ccR.setVisibility(View.INVISIBLE);
        districtR.setVisibility(View.INVISIBLE);
        populationR.setVisibility(View.INVISIBLE);
    }

    public void mostrarValores(City c){
        nameR.setVisibility(View.VISIBLE);
        ccR.setVisibility(View.VISIBLE);
        districtR.setVisibility(View.VISIBLE);
        populationR.setVisibility(View.VISIBLE);
        nameW.setText(c.nombre);
        ccW.setText(c.cc);
        districtW.setText(c.district);
        populationW.setText(c.population+"");
    }
}
