package com.example.alumno.listviewpractica4;

import android.app.Activity;
import android.widget.ArrayAdapter;

public class Deportes extends ArrayAdapter<Opcion> {

    Activity activity;

    Deportes(Activity act, Opcion[]dat){
        super(activity, R.layout.opcion, dat);
        activity=act;
    }

    //Quieren jugar conmigo, pero se tiran llevando dos ases
    //tus criticas con como el tabaco, me las fumo y se convierten en ceniza.


    //




}
