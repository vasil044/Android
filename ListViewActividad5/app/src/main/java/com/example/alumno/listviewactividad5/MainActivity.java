package com.example.alumno.listviewactividad5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Articulo> listaCompra = new ArrayList<>();

    EditText valor;

    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        valor = (EditText) findViewById(R.id.articuloIntroducido);

        final ListView list = (ListView)findViewById(R.id.miLista);


        listaCompra.add(new Articulo("galletas",false));
        listaCompra.add(new Articulo("pan", false));
        listaCompra.add(new Articulo("lechuga", false));
        listaCompra.add(new Articulo("chuleton", false));

        ArrayAdapter <Articulo> adaptador = new ArrayAdapter<Articulo>(MainActivity.this, android.R.layout.simple_list_item_1, listaCompra);

        list.setAdapter(adaptador);

    }

    public void introducirAlArrayList(View view){
        String nombre;
        nombre= String.valueOf(valor.getText());

        listaCompra.add(new Articulo (nombre,false));
    }




    public void nuevoArticuloLista(View view){
        Intent i = new Intent(this, altaArticuloClase.class);
        startActivity(i);
    }


    /*
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        if(v.getId() == R.id.miLista)
        {
            AdapterView.AdapterContextMenuInfo info =
                    (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle(
                    listaCompra.getAdapter().getItem(info.position).toString());
            inflater.inflate(R.menu.menu_context_lista, menu);
        }
    }
    */

    /*
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {

            case R.id.EditTextOp:

                //falta codigo.

                return true;
            case R.id.BorrarTextOp:

                listaCompra.remove(info.position);
                adaptador.notifyDataSetChanged();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    */

    public boolean onCreateOptionsMenu(Menu miMenu){
        getMenuInflater().inflate(R.menu.menu_activity, miMenu);
        return true;
    }



    public boolean onOptionsItemSeleccted(MenuItem opcMenu){
        int id = opcMenu.getItemId();

        if (id==R.id.nuevoArticulo){
            return true;
            //nuevoArticuloLista(null);
        }

        if (id==R.id.borrarLista){
            return true;
        }

        return super.onOptionsItemSelected(opcMenu);
    }

}
