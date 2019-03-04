package com.example.samuel.sqlitenotas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class NotasActivity extends AppCompatActivity {

    //Definimos algunos objetos imprescindibles para el funcionamiento de la app.
    NotasBDAdapter adaptador = null;
    ListView list = null;
    NotasBDManager manager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializamos objetos para trabajar con BBDD.
        manager = new NotasBDManager(this);
        list = (ListView) findViewById(R.id.listViewPrincipal);
        //Se comprueba si la conexión ha sido correcta.
        manager.conectado(this);
        //Volcamos los datos de la tabla notas en el ListView.
        adaptador = new NotasBDAdapter(this,manager.volcarDatosAL());
        list.setAdapter(adaptador);
        //Aplica el menú contextual a los items del ArrayList.
        registerForContextMenu(list);
        //Si se pulsa en algún item del ListView:
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int indice, long l) {
                //Se llama a la 2a actividad, enviándole los datos de la nota que se va a modificar y la operación que se quiere hacer con ellos.
                Intent i = new Intent(NotasActivity.this,GestionarNota.class);
                i.putExtra("accion","modificacion");
                i.putExtra("id", ""+adaptador.getItem(indice).getId());
                i.putExtra("categoria", ""+adaptador.getItem(indice).getCategoria());
                i.putExtra("titulo", ""+adaptador.getItem(indice).getTitulo());
                i.putExtra("descripcion",""+adaptador.getItem(indice).getDescripcion());
                startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
            }
        });
        //Cerramos conexión con base de datos.
        manager.close();
    }

    //Establece la menú bar de la app.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Define lo que ocurre al pulsar cada elemento o item de la menú bar.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ItemOpcionCruz) {
            Intent i = new Intent(NotasActivity.this,GestionarNota.class);
            i.putExtra("accion","alta");
            startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Definimos el esquema del menú contextual.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId() == R.id.listViewPrincipal)//Lo asigna al ListView.
        {
            // Inflamos el menú contextual
            inflater.inflate(R.menu.menu_contextual, menu);//Define el esquema xml que sigue el menú contextual.
        }
    }

    //Asigna acciones a las diferentes opciones que nos ofrece el menú contextual.
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Objeto que ayuda a conseguir información de la opción escogida.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            //Si se selecciona la opción de borrar:
            case R.id.itemBorrar:
                //Borra el producto del ArrayList, reinicia el adaptador y vuelve a asignar al ListView el adaptador reiniciado.
                int pos = info.position;
                int id = adaptador.getItem(pos).getId();
                manager = new NotasBDManager(this);
                manager.eliminar(id);
                adaptador = new NotasBDAdapter(this,manager.volcarDatosAL());
                list.setAdapter(adaptador);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //Gestiona el movimiento entre actividades.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String respuesta="";

        //Si se cancela la operación de la actividad secundaria se mostrará un mensaje informativo de tipo Toast.
        if (resultCode == RESULT_CANCELED){
            respuesta = "Saliste de la actividad sin pulsar 'Aceptar', cambios descartados.";
            Toast.makeText(getApplicationContext(),respuesta, Toast.LENGTH_SHORT).show();
        }
        //Si se ha salido de forma que no se haya cancelado la operación, se hará lo siguiente:
        else {
            //Si la operación ha sido de modificado:
            if(data.getStringExtra("accion").equals("mod")) {
                //Se muestra mensaje informativo.
                Toast.makeText(this, "Cambios aplicados.", Toast.LENGTH_SHORT).show();
                //Utilizamos el gestor de la base de datos para realizar la actualización, una vez devueltos los datos modificados de la nota.
                manager = new NotasBDManager(this);
                manager.actualizar(Integer.valueOf(data.getStringExtra("id")), data.getStringExtra("categoria"), data.getStringExtra("titulo"), data.getStringExtra("descripcion"));
                //Actualizamos el ListView.
                adaptador = new NotasBDAdapter(this, manager.volcarDatosAL());
                list.setAdapter(adaptador);
            }else{//Si la operación ha sido de alta.
                //Se muestra mensaje informativo.
                Toast.makeText(this, "Nota dada de alta.", Toast.LENGTH_SHORT).show();
                //Se actualiza el ListView.
                manager = new NotasBDManager(this);
                adaptador = new NotasBDAdapter(this, manager.volcarDatosAL());
                list.setAdapter(adaptador);
            }
        }
    }
    private static final int SECONDARY_ACTIVITY_TAG = 1;
}
