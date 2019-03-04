package com.example.samuel.pruebaexam;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.samuel.pruebaexam.R;

import java.util.ArrayList;

/**
 * Created by Samuel on 14/03/2018.
 */

public class CityAdapter extends ArrayAdapter<City> {

    Activity contexto;

    CityAdapter(Activity contexto, ArrayList<City> datos) {
        // Llamamos al constructor de la clase superior
        //se le pasa el xml que genera la fila y el array de objetos
        super(contexto, R.layout.cities, datos);
        this.contexto = contexto;
    }


    //Esto es lo que se invoca cada vez que haya que mostrar un elemento de la lista

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.cities, null);

        //Mediante getItem cargamos cada uno de los objetos del array
        City mielemento = getItem(position);
        //ImageView imagen = (ImageView) item.findViewById(R.id.imageView);
        TextView name = (TextView) item.findViewById(R.id.nameLayout);
        TextView district = (TextView) item.findViewById(R.id.districtLayout);
        TextView cc = (TextView) item.findViewById(R.id.CountryCodeLayout);
        TextView id = (TextView)  item.findViewById(R.id.idLayout);
        TextView population = (TextView)  item.findViewById(R.id.populationLayout);

        name.setText(mielemento.nombre);
        district.setText(mielemento.district);
        cc.setText(mielemento.cc);
        id.setText(mielemento.id+"");
        population.setText(mielemento.population+"");

        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return (item);
    }
}
