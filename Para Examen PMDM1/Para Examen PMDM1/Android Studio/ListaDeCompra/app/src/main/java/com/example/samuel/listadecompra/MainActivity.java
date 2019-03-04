package com.example.samuel.listadecompra;


import android.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogoAltas.EditNameDialogListener,DialogoModificaciones.EditNameDialogListenerM{

    //ArrayList auxiliares para cuando se gire la pantalla.
    private final static String STATE_NOMBRES = "als";
    ArrayList<String> als = new ArrayList<>();
    private final static String STATE_BOOL = "ali";
    ArrayList<Integer> ali = new ArrayList<>();
    ListView list;//Objeto ListView para trabajar con la ListView del main.
    AdapterProductos adaptador;//Adaptador para modificar el contenido de ListView.
    ArrayList<Articulo> productos = new ArrayList<>();//ArrayList para almacenar objetos de tipo Articulo.
    FragmentManager fm = getSupportFragmentManager();//Objeto para llamar DialogFragment.
    int indice=0;//Variable auxiliar para almacenar un entero.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.miLista);
        if(savedInstanceState != null)//Carga los valores al girar la pantalla.
        {
            productos.clear();//Se resetea el ArrayList "productos".
            als= savedInstanceState.getStringArrayList(STATE_NOMBRES);
            ali=savedInstanceState.getIntegerArrayList(STATE_BOOL);
            for(int i=0;i<als.size();i++){
                boolean b;
                if(ali.get(i)==1){
                    b=true;
                }else{
                    b=false;
                }
                productos.add(new Articulo(als.get(i),b));
            }
        }
        else{
            //Inicializamos el ArrayList que contiene objetos de tipo Articulo.
            productos.add(new Articulo("Pan",true));
            productos.add(new Articulo("Leche",false));
            productos.add(new Articulo("Periódico",true));
            productos.add(new Articulo("Fruta",false));
            productos.add(new Articulo("Carne",true));
        }
        //Creamos un adaptador al que aplicamos el ArrayList anterior.
        adaptador = new AdapterProductos(this,productos);
        list.setAdapter(adaptador);
        registerForContextMenu(list);//Aplica el menú contextual a los items del ArrayList.
        //Si se pulsa alguno de los items del ListView:
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast1;
                /*
                    -Se cambia la variable de tipo boolean asociada al objeto Artículo del adaptador.
                    -Se muestra un mensaje informativo de tipo Toast.
                    -Se vuelve a asignar el adaptador, ya modificado, al ListView.
                 */
                if(adaptador.getItem(i).isComprado()){
                    adaptador.getItem(i).setComprado(false);//Se cambia la variable de tipo boolean asociada al objeto Artículo del adaptador.
                    //Mensaje informativo.
                    toast1 = Toast.makeText(getApplicationContext(),"Has dejado de comprar '"+adaptador.getItem(i).getNombre()+"'.", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                else{
                    adaptador.getItem(i).setComprado(true);//Se cambia la variable de tipo boolean asociada al objeto Artículo del adaptador.
                    //Mensaje informativo.
                    toast1 = Toast.makeText(getApplicationContext(),"Has comprado '"+adaptador.getItem(i).getNombre()+"'.", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                //Se vuelve a asignar el adaptador.
                list.setAdapter(adaptador);
            }
        });
    }

    //Asigna el menú ActionBar.
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    //Actúa según lo elegido en la ActionBar.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ItemOpcionCruz:
                //Si se pulsa la cruz, mostrará un diálogo para añadir un Artículo.
                DialogoAltas dialogo = new DialogoAltas();
                dialogo.show(fm, "Dialog Fragment");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    //Asigna el menú contextual a un objeto.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId() == R.id.miLista)//Lo asigna al ListView.
        {
            AdapterContextMenuInfo info =
                    (AdapterContextMenuInfo)menuInfo;
            // Definimos la cabecera del menú contextual
            menu.setHeaderTitle("Operaciones sobre "+productos.get(info.position).getNombre());//Asigna el título del menú contextual.
            // Inflamos el menú contextual
            inflater.inflate(R.menu.menu_contextual, menu);//Define el esquema xml que sigue el menú contextual.
        }
    }

    //Asigna acciones a las diferentes opciones que nos ofrece el menú contextual.
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Objeto que ayuda a conseguir información de la opción escogida.
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            //Si se selecciona la opción de borrar:
            case R.id.borrar:
                //Borra el producto del ArrayList, reinicia el adaptador y vuelve a asignar al ListView el adaptador reiniciado.
                productos.remove(info.position);
                adaptador = new AdapterProductos(this,productos);
                list.setAdapter(adaptador);
                return true;
            //Si se selecciona la opción de editar:
            case R.id.editar:
                /*
                    -Se utiliza la variable auxiliar "indice" para guardar la posición en la que se encuentra el elemento del ListView.
                    -Se llama al diálogo respectivo y éste actúa en relación a la opción escogida por el usuario.
                 */
                indice=info.position;//Utilizamos la variable auxiliar.
                DialogoModificaciones dialogo = new DialogoModificaciones();//Se llama al diálogo de modificaciones.
                dialogo.show(fm, "Dialog Fragment");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //Método que asigna las acciones respectivas a pulsar la "opción positiva" de DialogoAltas o DialogoModificaciones.
    @Override
    public void onDialogPositiveClick(android.support.v4.app.DialogFragment dialog, String name) {
        /*
            -Se comprueba qué diálogo ha sido llamado.
            -Se actúa en consecuencia.
         */
        //Comprobamos cuál de los dos diálogos ha llamado al método.
        if(dialog.getClass().toString().equals("class com.example.samuel.listadecompra.DialogoModificaciones")){
            //Si DialogoModificaciones ha sido el que ha llamado al método:
            /*
                -Guardamos el valor booleano asociado al elemento de tipo Articulo en el ListView, en la posición referenciada por la variable auxiliar "indice".
                -Se elimina el Articulo que ocupaba la posición "indice" del ArrayList "productos".
                -Se añade un nuevo Articulo a "productos" en la posición "indice".
                -Se reinicia el adaptador con "productos" actualizado.
                -Se asigna el adaptador actualizado al ListView.
             */
            boolean comprado = productos.get(indice).isComprado(); //Guarda valor booleano.
            productos.remove(indice);//Borra el Articulo en "indice".
            productos.add(indice,new Articulo(name,comprado));//Añade el nuevo Articulo.
            adaptador = new AdapterProductos(this,productos);//Reinicia el adaptador.
            list.setAdapter(adaptador);//Asigna el adaptador al ListView.
        }
        else{
            //Si DialogoAltas ha sido el que ha llamado al método:
            adaptador.add(new Articulo(name,false));//Se añade un nuevo elemento al ListView.
        }
    }

    //Método que asigna las acciones respectivas a pulsar la "opción negativa" de DialogoAltas o DialogoModificaciones.
    @Override
    public void onDialogNegativeClick(android.support.v4.app.DialogFragment dialog) {
        //En ambas situaciones se muestra un mensaje informativo de tipo Toast.
    }

    public void onSaveInstanceState(Bundle outInstance)//Permite guardar valores para que cuando se gire la pantalla no se resetee.
    {
        super.onSaveInstanceState(outInstance);
        //Se resetean los ArrayList auxiliares.
        ali.clear();
        als.clear();
        for(int i=0;i<productos.size();i++){
            als.add(productos.get(i).getNombre());
            if(productos.get(i).isComprado()){
                ali.add(1);
            }else{
                ali.add(0);
            }
        }
        outInstance.putIntegerArrayList(STATE_BOOL,ali);
        outInstance.putStringArrayList(STATE_NOMBRES,als);
    }
}
