package com.example.samuel.listadecompra;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Samuel on 30/10/2017.
 */

public class AdapterProductos extends ArrayAdapter<Articulo> {

    Activity contexto;

    AdapterProductos(Activity contexto, ArrayList<Articulo> datos) {
        //Se llama al constructor de la clase padre y le pasamos el xml que genera la fila, el layout que queremos utilizar y el array.
        super(contexto, R.layout.layout_productos, datos);
        this.contexto = contexto;
    }

    //Genera cada elemento del array.
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.layout_productos, null);

        //Cargamos cada uno de los objetos del array
        Articulo mielemento = getItem(position);

        TextView b = (TextView) item.findViewById(R.id.textoArticulo);
        //EditText b = (EditText) item.findViewById(R.id.textoArticulo);

        b.setText(mielemento.getNombre());

        if (mielemento.isComprado()) {
            b.setPaintFlags(b.getPaintFlags() |
                    Paint.STRIKE_THRU_TEXT_FLAG);
            b.setTextColor(Color.parseColor("#00FF00"));
        } else {
            b.setPaintFlags(b.getPaintFlags()
                    & ~Paint.STRIKE_THRU_TEXT_FLAG);
            b.setTextColor(Color.parseColor("#FF0000"));
        }
        // Devolvemos la vista que dibuja la opción.
        return (item);
    }
}
