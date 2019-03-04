package com.example.samuel.pruebaexam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Samuel on 14/03/2018.
 */

public class BDManager {
    private BDHelper helper;
    public SQLiteDatabase db;

    //***************CONSTRUCTORES***************.
    public BDManager(Context context){
        helper = new BDHelper(context);
        db = helper.getWritableDatabase();
    }

    //***************Métodos***************.
    public void insertar2(){

    }
    public void eliminar(Context contexto,String campo, String donde){
    }

    public void close(){
        db.close();
    }
    public void conectado(Context contexto){
        if(db != null)
        {
            Toast.makeText(contexto, "Conectado correctamente a la BBDD.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(contexto, "No conectado.", Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrarValorEn(){
    }
    public ArrayList<City> volcarDatosAL(String nombre){
        ArrayList<City> cities = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM city", null);
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String nom= c.getString(1);
                String cc = c.getString(2);
                String district = c.getString(3);
                int population = c.getInt(4);
                //Valido si el nombre es válido.
                String nom2=nom.substring(0,nombre.length());
                if(nombre.equals(nom2)){
                    cities.add(new City(id,nom,cc,district,population));
                }
            } while(c.moveToNext());
        }
        return cities;
    }
    public void actualizar(){
    }
    public void eliminar(int id){
    }
    public int devolverIdValido(int num){
        return 0;
    }
}

