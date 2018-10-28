package  com.example.usuario.menucontextualdemo;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {


    private ListView listadoPrincipal;
    // Definimos el adaptador que va a usar el ListView
    private ArrayAdapter<String> adaptador;
    // Matriz con los datos del adaptador
    private String[] datos = new String[]{"Opción 0 listado","Opción 1  listado","Opción 2  listado",
            "Opción 3  listado","Opción 4  listado"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos las referencias a los componentes

        listadoPrincipal = (ListView)findViewById(R.id.ListadoPrincipal);

        //Rellenamos la lista con datos de ejemplo
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        listadoPrincipal.setAdapter(adaptador);

        //Asociamos los menús contextuales a los componentes
        registerForContextMenu(listadoPrincipal);
    } // end onCreate


    @Override
    // Método donde definimos el menú contextual cuando se despliega
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Inflador del menú contextual
        MenuInflater inflater = getMenuInflater();

        // Si el componente que vamos a dibujar es el ListView usamos
        // el fichero XML correspondiente
        if(v.getId() == R.id.ListadoPrincipal)
        {
            AdapterView.AdapterContextMenuInfo info =
                    (AdapterView.AdapterContextMenuInfo)menuInfo;
            // Definimos la cabecera del menú contextual
            menu.setHeaderTitle(
                    listadoPrincipal.getAdapter().getItem(info.position).toString());
            // Inflamos el menú contextual
            inflater.inflate(R.menu.menu_context_lista, menu);
        }
    }

    @Override
    // Si el usuario selecciona una opción del menú contextual mostramos
    // la opción seleccionada en la etiqueta
    public boolean onContextItemSelected(MenuItem item) {

        AdapterContextMenuInfo info =
                (AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {

            // Se selecciona la opción "Editar texto opción" de menú contextual de la etiqueta
            case R.id.EditTextOp:

                // Cambiamos el contenido de la matriz de datos
                datos[info.position]="Opción "+info.position+" listado  modificado";
                // Reiniciamos el adaptador para que recargue los datos y actualice el ListBox
                adaptador.notifyDataSetChanged();
                return true;
            // Se selecciona la opción "Reiniciar texto opción" de menú contextual de la etiqueta
            case R.id.ReiniciaTextOp:

                datos[info.position]="Opción "+info.position+" listado";
                adaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}