package com.example.alumno.listviewpractica4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class Deportes extends ArrayAdapter<Opcion> {

    Activity activity;

    Deportes(Activity act, Opcion[]dat){
        super(act, R.layout.opcion, dat);
        this.activity=act;
    }

    public View getView(int posicion, View convertView, ViewGroup parent){

        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.opcion, null);

        Opcion mielemento = getItem(posicion);

        ImageView imagen = (ImageView)item.findViewById(R.id.Imagen);
        TextView deporte = (TextView)item.findViewById(R.id.Deporte);
        CheckBox checkBox = (CheckBox)item.findViewById(R.id.checkbox);

        imagen.setImageResource(mielemento.getIcono());
        deporte.setText(mielemento.getNombre());
        checkBox.setChecked(mielemento.marcado);

        return (item);
    }

    //Quieren jugar conmigo, pero se tiran llevando dos ases
    //tus criticas con como el tabaco, me las fumo y se convierten en ceniza.

}
