package com.example.samuel.ejerciciolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicalizamos las variables para operar con los elementos de la aplicación.
        final ListView list = (ListView)findViewById(R.id.miLista);
        Button boton = (Button) findViewById(R.id.botonAceptar);

        //Declaramos enteros que apunten a las imágenes de drawable.
        int atletismo = R.drawable.atletismo;
        int baloncesto = R.drawable.baloncesto;
        int futbol = R.drawable.futbol;
        int golf = R.drawable.golf;
        int pingpong = R.drawable.pingpong;
        int motociclismo = R.drawable.motociclismo;
        int natacion = R.drawable.natacion;

        //Inicializamos un array que contenga objetos de tipo Opcion.
        final Opcion [] opciones = new Opcion[7];
        opciones[0]=(new Opcion("Baloncesto",baloncesto,false));
        opciones[1]=(new Opcion("Fútbol",futbol,false));
        opciones[2]=(new Opcion("Motociclismo",motociclismo,false));
        opciones[3]=(new Opcion("Natación",natacion,false));
        opciones[4]=(new Opcion("Golf",golf,false));
        opciones[5]=(new Opcion("Atletismo",atletismo,false));
        opciones[6]=(new Opcion("Ping Pong",pingpong,false));

        //Creamos un adaptador al que aplicamos el array anterior.
        final AdapterDeportes adaptador = new AdapterDeportes(this,opciones);

        //Se establece el adaptador anterior como el de nuestro ListView.
        list.setAdapter(adaptador);

        //Si se selecciona algún item del ListView:
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*
                -Si su checkbox estaba sin marcar, se modifica el adaptador marcando el checkbox en la misma posición.
                -Si su checkbox estaba marcado, se modifica el adaptador desmarcando el checkbox en la misma posición.
                -Se vuelve a establecer el adaptador modificado como el de nuestro ListView.
                 */
                Toast toast1 = Toast.makeText(getApplicationContext(),"seleccionado", Toast.LENGTH_SHORT);
                toast1.show();
                if(adaptador.getItem(i).isCheck())
                {
                    adaptador.getItem(i).setCheck(false);
                    list.setAdapter(adaptador);
                }
                else
                {
                    adaptador.getItem(i).setCheck(true);
                    list.setAdapter(adaptador);
                }
            }
        });

        //Cuando se pulsa el botón de aceptar:
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkeado=false;//Se crea una variable booleana para controlar si se ha seleccionado o no algún item del ListView.
                String gustos="Te gusta ";//Se crea un String, que si se ha seleccionado algún elemento, será la cadena que devuelva un objeto Toast.
                /*
                    -Vamos recorriendo el adaptador, comprobando si está seleccionado algún elemento.
                    -A la vez que comprobamos, vamos modificando el String "gustos" según el item que esté seleccionado.
                 */
                for(int i=0;i<7;i++)
                {
                    if(adaptador.getItem(i).isCheck())//Comprueba si el elemento está seleccionado.
                    {
                        checkeado=true;
                        if(i!=3)
                        {
                            gustos=gustos+"el "+adaptador.getItem(i).getNombre()+",";
                        }
                        else
                        {
                            gustos=gustos+"la "+adaptador.getItem(i).getNombre()+",";
                        }
                    }
                }
                Toast toast1;//Declaramos un objeto tipo Toast para devolver un mensaje una vez hayamos terminado de modificar el String "gustos".
                if(checkeado)//Si algo ha sido seleccionado, comenzaremos a modificar "gustos".
                {
                    String [] splitter = gustos.split(",");//Eliminamos las comas, que se habían utilizado como separador, del String "gustos" para crear un array de String con su contenido dividido.
                    /*
                        -"gustos" volverá a ser nuestra variable de almacenamiento del String que se devolverá al final.
                        -Destruimos el contenido que ya tenía "gustos" y le asignamos uno nuevo.
                        -Según la posición y tamaño del array declarado unas líneas atrás se irá concatenando "gustos" con el contenido del array de String "splitter".
                     */
                    for(int i=0;i<splitter.length;i++)
                    {
                        if(i==0)
                        {
                            gustos=splitter[i];
                            if(splitter.length==1)
                            {
                                gustos=gustos+".";
                            }
                        }
                        if(splitter.length!=1) {
                            if(i!=0){
                                gustos=gustos+splitter[i];
                            }
                            if(i==splitter.length-2)
                            {
                                gustos = gustos + " y ";
                            }
                            else
                            {
                                if(i==splitter.length-1)
                                {
                                    gustos = gustos + ".";
                                }
                                else
                                {
                                    gustos = gustos + " ,";
                                }
                            }
                        }
                    }
                    //Finalmente se lanzá el mensaje de tipo Toast con el contenido de "gustos".
                    toast1 = Toast.makeText(getApplicationContext(), gustos, Toast.LENGTH_SHORT);
                    toast1.show();
                }
                else//Si no hubiera sido seleccionado ningún elemento del ListView, se lanza el siguiente mensaje de tipo Toast.
                {
                    toast1 = Toast.makeText(getApplicationContext(),"No has seleccionado ninguna opción.", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });
    }
}
