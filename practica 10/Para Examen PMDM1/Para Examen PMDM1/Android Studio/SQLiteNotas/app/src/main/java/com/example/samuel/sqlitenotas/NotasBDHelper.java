package com.example.samuel.sqlitenotas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by Samuel on 07/12/2017.
 */

public class NotasBDHelper extends SQLiteOpenHelper{

    //Declaramos el nombre de la base de datos y la versión del esquema que se va a usar.
    private static final String DB_NAME = "practica11";
    private static final int DB_SCHEME_VERSION = 1;

    //Constructor.
    public NotasBDHelper(Context contexto){
        super(contexto, DB_NAME, null, DB_SCHEME_VERSION);
    }

    //Cuando se crea este objeto, se crea la base de datos.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotasBDManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS notas");
        db.execSQL(NotasBDManager.CREATE_TABLE);
    }
}
