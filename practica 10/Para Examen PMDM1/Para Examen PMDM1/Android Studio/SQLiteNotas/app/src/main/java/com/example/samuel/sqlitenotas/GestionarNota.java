package com.example.samuel.sqlitenotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Samuel on 09/12/2017.
 */

public class GestionarNota extends AppCompatActivity {

    //Inicializamos objetos para trabajar con ellos.
    Spinner s = null;
    Button b = null;
    EditText desc = null;
    EditText tit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        //Se crea nuestro gestor de la base de datos.
        final NotasBDManager manager = new NotasBDManager(this);
        //Instanciamos los objetos de la app en variables.
        s = (Spinner) findViewById(R.id.spinner);
        b = (Button) findViewById(R.id.buttonAceptar);
        desc = (EditText) findViewById(R.id.editTextInformacion);
        tit = (EditText) findViewById(R.id.editTextTitulo);
        //Inicializamos el Spinner.
        cargarSpinner(s);
        //Según cómo se llame a esta actividad, trabajará de una forma u otra.
        switch(getIntent().getStringExtra("accion")){
            //Si se ha llamado a la actividad para modificar una nota, hará lo siguiente:
            case "modificacion":
                //Cargamos la nota que queremos modificar.
                final Nota n = new Nota(Integer.valueOf(getIntent().getStringExtra("id")),getIntent().getStringExtra("categoria"),getIntent().getStringExtra("titulo"),getIntent().getStringExtra("descripcion"));
                cargarDatosPrimeraActividad(n,s,desc,tit);
                //Si se pulsa 'ACEPTAR' enviará los datos actualizados a la 1a actividad y la acción que se estaba haciendo.
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent();
                        i.putExtra("id", ""+n.getId());
                        i.putExtra("categoria", devolverNombreSpinner(s));
                        i.putExtra("titulo",""+tit.getText());
                        i.putExtra("descripcion",""+desc.getText());
                        i.putExtra("accion","mod");
                        //Damos por correcto el resultado y finalizamos la 2a actividad.
                        setResult(RESULT_OK, i);
                        finish();
                    }
                });
                break;
            //Si se ha llamado a la actividad para dar de alta una nota, hará lo siguiente:
            case "alta":
                //Si se pulsa 'ACEPTAR' enviará los datos a la 1a actividad, la acción que se estaba haciendo y actualizará la base de datos.
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent();
                        int id =manager.devolverIdValido(0);
                        i.putExtra("id", id );
                        i.putExtra("categoria", devolverNombreSpinner(s));
                        i.putExtra("titulo",""+tit.getText());
                        i.putExtra("descripcion",""+desc.getText());
                        i.putExtra("accion","alta");
                        //Actualizamos la base de datos añadiendo un nuevo registro.
                        manager.insertar2(id,devolverNombreSpinner(s),""+tit.getText(),""+desc.getText());
                        //Damos por correcto el resultado y finalizamos la 2a actividad.
                        setResult(RESULT_OK, i);
                        finish();
                    }
                });
                break;
        }
    }

    //Método que carga los datos de la nota recibidos desde la 1a actividad en esta actividad.
    public void cargarDatosPrimeraActividad(Nota n, Spinner s,EditText desc,EditText tit){
        desc.setText(n.getDescripcion());
        tit.setText(n.getTitulo());
        switch (n.getCategoria()){
            case "Cena":
                s.setSelection(0);
                break;
            case "Comida":
                s.setSelection(1);
                break;
            case "Reunion":
                s.setSelection(2);
                break;
            case "Juegos":
                s.setSelection(3);
                break;
            case "Deporte":
                s.setSelection(4);
                break;
            default:
                s.setSelection(0);
                break;
        }
    }

    //Método que inicializa el Spinner.
    public void cargarSpinner(Spinner s){
        String [] array = {"Cena","Comida","Reunion","Juegos","Deporte"};
        s.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array));
    }

    //Método que devuelve un String en función de la opción que se haya escogido en el Spinner.
    public String devolverNombreSpinner(Spinner s){
        switch (s.getSelectedItemPosition()){
            case 0:
                return "Cena";
            case 1:
                return "Comida";
            case 2:
                return "Reunion";
            case 3:
                return "Juegos";
            case 4:
                return "Deporte";
            default:
                return "";
        }
    }
}
