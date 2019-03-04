package com.example.samuel.prueba1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samuel on 13/03/2018.
 */

public class NumerosAdapter extends ArrayAdapter<Numero> {
    Activity contexto;

    NumerosAdapter(Activity contexto, ArrayList<Numero> datos) {
        //Se llama al constructor de la clase padre y le pasamos el xml que genera la fila, el layout que queremos utilizar y el array.
        super(contexto, R.layout.numeros, datos);
        this.contexto = contexto;
    }

    //Genera cada elemento del array.
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.numeros, null);

        //Cargamos cada uno de los objetos del array
        Numero mielemento = getItem(position);

        TextView a = (TextView) item.findViewById(R.id.texto);
        TextView b = (TextView) item.findViewById(R.id.numero);
        ImageView imagen = (ImageView) item.findViewById(R.id.imagen);

        a.setText(mielemento.texto);
        b.setText(""+mielemento.num);
        imagen.setImageResource(mielemento.img_ref);

        // Devolvemos la vista que dibuja la opción.
        return (item);
    }
}
