package com.example.samuel.sqlitenotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samuel on 07/12/2017.
 */

public class NotasBDAdapter extends ArrayAdapter<Nota> {

    Activity contexto;

    NotasBDAdapter(Activity contexto, ArrayList<Nota> datos) {
        // Llamamos al constructor de la clase superior
        //se le pasa el xml que genera la fila y el array de objetos
        super(contexto, R.layout.layout_listv_notas, datos);
        this.contexto = contexto;
    }


    //Esto es lo que se invoca cada vez que haya que mostrar un elemento de la lista

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.layout_listv_notas, null);

        //Mediante getItem cargamos cada uno de los objetos del array
        Nota mielemento = getItem(position);

        //ImageView imagen = (ImageView) item.findViewById(R.id.imageView);
        TextView tvl1 = (TextView) item.findViewById(R.id.textViewList1);
        TextView tvl2 = (TextView) item.findViewById(R.id.textViewList2);

        tvl2.setText(mielemento.getTitulo());
        tvl1.setText(mielemento.getCategoria());

        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return (item);
    }
}
