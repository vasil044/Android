package com.example.samuel.faunamarina;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samuel on 20/11/2017.
 */

public class AdapterFMarina extends ArrayAdapter<FMarina> {

    Activity contexto;

    AdapterFMarina(Activity contexto, ArrayList<FMarina> datos) {
        // Llamamos al constructor de la clase superior
        //se le pasa el xml que genera la fila y el array de objetos
        super(contexto, R.layout.layout_list, datos);
        this.contexto = contexto;
    }


    //Esto es lo que se invoca cada vez que haya que mostrar un elemento de la lista

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.layout_list, null);

        //Mediante getItem cargamos cada uno de los objetos del array
        FMarina mielemento = getItem(position);

        ImageView imagen = (ImageView) item.findViewById(R.id.imageView);
        TextView principal = (TextView) item.findViewById(R.id.textPrincipal);
        TextView latin = (TextView) item.findViewById(R.id.textLatinajo);
        TextView tam = (TextView) item.findViewById(R.id.textTam);
        TextView habitat = (TextView) item.findViewById(R.id.textHabitat);

        imagen.setImageResource(mielemento.getRef());
        principal.setText(mielemento.getNombre());
        latin.setText(mielemento.getLatin());
        tam.setText(mielemento.getTamano());
        habitat.setText(mielemento.getTamano());

        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return (item);
    }
}
