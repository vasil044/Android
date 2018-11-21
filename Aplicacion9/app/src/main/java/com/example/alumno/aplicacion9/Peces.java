package com.example.alumno.aplicacion9;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Peces extends ArrayAdapter<Opcion> {

    Activity activity;

    Peces(Activity act, Opcion[]dat){
        super(act, R.layout.informacion, dat);
        this.activity=act;
    }

    public View getView(int posicion, View convertView, ViewGroup parent){

        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.informacion, null);

        Opcion mielemento = getItem(posicion);

        ImageView imagen = (ImageView)item.findViewById(R.id.imageViewPez);
        TextView nom = (TextView)item.findViewById(R.id.textViewNombre);
        TextView nomLat = (TextView)item.findViewById(R.id.textViewNomLatin);
        TextView longi = (TextView)item.findViewById(R.id.textViewLongitud);
        TextView habit = (TextView)item.findViewById(R.id.textViewHabitad);

        imagen.setImageResource(mielemento.getIcono());
        nom.setText(mielemento.getNombre());
        nomLat.setText(mielemento.getNomLatin());
        longi.setText(mielemento.getLongitud());
        habit.setText(mielemento.getLugar());

        return (item);
    }
}
