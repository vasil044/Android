package com.example.samuel.ejerciciolistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterDeportes extends ArrayAdapter<Opcion> {

    Activity contexto;

    AdapterDeportes(Activity contexto, Opcion[] datos) {
        //Se llama al constructor de la clase padre y le pasamos el xml que genera la fila, el layout que queremos utilizar y el array.
        super(contexto, R.layout.layoutdeportes, datos);
        this.contexto = contexto;
    }

    //Genera cada elemento del array.
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.layoutdeportes, null);

        //Cargamos cada uno de los objetos del array
        Opcion mielemento=getItem(position);

        ImageView imagen=(ImageView)item.findViewById(R.id.Imagen);
        TextView deporte = (TextView)item.findViewById(R.id.Deporte);
        CheckBox checkBox = (CheckBox)item.findViewById(R.id.checkbox);


        imagen.setImageResource(mielemento.getRef_icono());
        deporte.setText(mielemento.getNombre());
        checkBox.setChecked(mielemento.check);

        // Devolvemos la vista que dibuja la opción.
        return(item);
    }
}