package com.example.samuel.pruebaexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Samuel on 14/03/2018.
 */

public class BDHelper extends SQLiteOpenHelper{

    //Declaramos el nombre de la base de datos y la versión del esquema que se va a usar.
    private static final String DB_NAME = "pruebaexam";
    private static final int DB_SCHEME_VERSION = 1;
    Context contexto;

    //Constructor.
    public BDHelper(Context contexto){
        super(contexto, DB_NAME, null, DB_SCHEME_VERSION);
        this.contexto=contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creaci?n de la tabla
        try
        {
            String linea;
            InputStream fraw = contexto.getResources().openRawResource(R.raw.worldsqliterelacional);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            linea = brin.readLine();
            while(linea!=null) {
                db.execSQL(linea);
                linea = brin.readLine();
            };
            fraw.close();

        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS city");
        try
        {
            String linea;
            InputStream fraw = contexto.getResources().openRawResource(R.raw.worldsqliterelacional);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            linea = brin.readLine();
            while(linea!=null) {
                db.execSQL(linea);
                linea = brin.readLine();
            };
            fraw.close();

        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }
    }
}

