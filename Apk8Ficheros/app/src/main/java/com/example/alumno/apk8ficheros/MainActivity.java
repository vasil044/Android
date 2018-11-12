package com.example.alumno.apk8ficheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner opcion;
    TextView opcSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opcion=(Spinner)findViewById(R.id.spinnerOpcion);
        opcSelec=(TextView)findViewById(R.id.textViewOpcSeleccionada);

    }

    /*
    opcion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Object item = parent.getItemAtPosition(pos); }
            public void onNothingSelected(AdapterView<?> parent) {

        } });
    */

    public void seleccionarOpcion(){
        if(opcion.getSelectedItemPosition()==0){
            opcSelec.setText("Peces");
        }else{
            opcSelec.setText("Algas e invertebrados");
        }
    }
}
