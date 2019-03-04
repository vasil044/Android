package com.example.samuel.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    NumerosAdapter adaptador;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instancio los objetos de la app.
        list = (ListView) findViewById(R.id.Lista);
        Button b = (Button) findViewById(R.id.button);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        final EditText text = (EditText) findViewById(R.id.cajaTexto);
        final Activity act = this;
        //Establezco el menú contextual.
        registerForContextMenu(list);
        //Si pulso botón.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = text.getText().toString();
                //Checkeamos que el texto, que  no esté vacío.
                if (cadena.equals("")) {
                    Toast.makeText(MainActivity.this, "Introduce una cadena en la caja de texto de arriba.", Toast.LENGTH_SHORT).show();
                } else {
                    //Dependiendo de la opción seleccionada de los radio buttons, se creará el ListView con una información u otra.
                    if (r1.isChecked()) {
                        int num = 2;
                        ArrayList<Integer> nums = new ArrayList<Integer>();
                        for (int i = 1; i <= 5; i++) {
                            nums.add(num);
                            num = num + 2;
                        }
                        //Generamos el ArrayList de Numero para el ArrayList.
                        ArrayList<Numero> numeros = new ArrayList<Numero>();
                        for (int i = 0; i < 5; i++) {
                            if (i == 0) {
                                numeros.add(new Numero(nums.get(i), R.drawable.i1, cadena));
                            }
                            if (i == 1) {
                                numeros.add(new Numero(nums.get(i), R.drawable.i2, cadena));
                            }
                            if (i == 2) {
                                numeros.add(new Numero(nums.get(i), R.drawable.i3, cadena));
                            }
                            if (i == 3) {
                                numeros.add(new Numero(nums.get(i), R.drawable.i4, cadena));
                            }
                            if (i == 4) {
                                numeros.add(new Numero(nums.get(i), R.drawable.i5, cadena));
                            }
                        }
                        //Creamos un adaptador al que aplicamos el ArrayList anterior.
                        adaptador = new NumerosAdapter(act, numeros);
                        list.setAdapter(adaptador);
                    } else {
                        if (r2.isChecked()) {
                            int num = 2;
                            ArrayList<Integer> nums = new ArrayList<Integer>();
                            for (int i = 1; i <= 5; i++) {
                                nums.add(num);
                                num = num * num;
                            }
                            //Generamos el ArrayList de Numero para el ArrayList.
                            ArrayList<Numero> numeros = new ArrayList<Numero>();
                            for (int i = 0; i < 5; i++) {
                                if (i == 0) {
                                    numeros.add(new Numero(nums.get(i), R.drawable.i1, cadena));
                                }
                                if (i == 1) {
                                    numeros.add(new Numero(nums.get(i), R.drawable.i2, cadena));
                                }
                                if (i == 2) {
                                    numeros.add(new Numero(nums.get(i), R.drawable.i3, cadena));
                                }
                                if (i == 3) {
                                    numeros.add(new Numero(nums.get(i), R.drawable.i4, cadena));
                                }
                                if (i == 4) {
                                    numeros.add(new Numero(nums.get(i), R.drawable.i5, cadena));
                                }
                            }
                            //Creamos un adaptador al que aplicamos el ArrayList anterior.
                            adaptador = new NumerosAdapter(act, numeros);
                            list.setAdapter(adaptador);
                        } else {
                            Toast.makeText(MainActivity.this, "Pulsa una de las opciones.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Se llamará a una segunda actividad, a la que se enviará la referencia numérica de la imagen del item del ListView.
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("ref",adaptador.getItem(i).img_ref);
                startActivityForResult(intent,SECONDARY_ACTIVITY_TAG);
            }
        });
    }

    //Asigna el menú ActionBar.
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId() == R.id.Lista)//Lo asigna al ListView.
        {
            // Inflamos el menú contextual
            inflater.inflate(R.menu.contextual, menu);//Define el esquema xml que sigue el menú contextual.
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        //Objeto que ayuda a conseguir información de la opción escogida.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            //Si se selecciona la opción de borrar:
            case R.id.borrarMC:
                //Borra el producto del ArrayList, reinicia el adaptador y vuelve a asignar al ListView el adaptador reiniciado.
                int pos = info.position;
                Numero num = adaptador.getItem(pos);
                adaptador.remove(num);
                list.setAdapter(adaptador);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.ItemOpcionPunto:
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("ref",R.drawable.puntonegro);
                startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
                return true;
            default:
                Toast.makeText(this, "Opción no disponible", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String respuesta="Has salido sin hacer nada";
        //Si se cancela la operación de la actividad secundaria se mostrará un mensaje informativo de tipo Toast.
        if (resultCode == RESULT_CANCELED){
            Toast toast1 = Toast.makeText(getApplicationContext(),respuesta, Toast.LENGTH_SHORT);
            toast1.show();
        }
        else {
            respuesta = data.getStringExtra("vuelta");
            Toast toast1 = Toast.makeText(getApplicationContext(),respuesta, Toast.LENGTH_SHORT);
            toast1.show();
        }
    }
    private static final int SECONDARY_ACTIVITY_TAG = 1;
}

