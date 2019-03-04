package com.example.samuel.sqlitenotas;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Samuel on 07/12/2017.
 */

public class NotasBDManager {
    /*
        ATRIBUTOS.
     */
    //String de creación de tabla.
    private NotasBDHelper helper;
    public SQLiteDatabase db;
    public static final String CREATE_TABLE = "create table notas (\n" +
            "_id integer primary key,\n" +
            "categoria text NOT NULL,\n" +
            "titulo text NOT NULL,\n" +
            "descripcion text NOT NULL)";

    /*
        CONSTRUCTORES.
     */

    public NotasBDManager(Context context){
        helper = new NotasBDHelper(context);
        db = helper.getWritableDatabase();
    }

    /*
        MÉTODOS.
     */

    //Método auxiliar de insertar().
    public ContentValues generarContentValues(int _id,String categoria, String titulo, String descripcion){
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("_id",_id);
        nuevoRegistro.put("categoria",categoria);
        nuevoRegistro.put("titulo",titulo);
        nuevoRegistro.put("descripcion",descripcion);
        return nuevoRegistro;
    }

    //Método que inserta en la tabla una fila recibiendo valores para cada una de ellas.
    public void insertar(Context contexto,int _id,String categoria, String titulo, String descripcion){
        long num = db.insert("notas",null,generarContentValues(_id,categoria,titulo,descripcion));
        if(num == -1){
            Toast.makeText(contexto, "ID no válido, ya existente en tabla.", Toast.LENGTH_SHORT).show();
        }
    }

    //Método que inserta en la tabla una fila recibiendo valores para cada una de ellas.
    public void insertar2(int _id,String categoria, String titulo, String descripcion){
        String cadena = "INSERT INTO notas values("+_id+",'"+categoria+"','"+titulo+"','"+descripcion+"')";
        db.execSQL(cadena);
    }

    //Método que borra registros de la base de datos en función del campo(columna a la pertenece el dato índice) y el dato índice(dato que se usa para encontrar la fila que se quiere borrar en la tabla) que reciba por parámetro.
    public void eliminar(Context contexto,String campo, String donde){
        String cadena;
        //En función del valor "campo" se buscará en una u otra columna de la tabla.
        //Se borrarán las filas cuyos valores en la columna "campo" sean iguales a "donde".
        switch(campo){
            case "_id":
                cadena="delete from notas where _id="+donde;
                db.execSQL(cadena);
                break;
            case "categoria":
                cadena="delete from notas where categoria='"+donde+"'";
                db.execSQL(cadena);
                break;
            case "titulo":
                cadena="delete from notas where titulo='"+donde+"'";
                db.execSQL(cadena);
                break;
            case "descripcion":
                cadena="delete from notas where descripcion='"+donde+"'";
                db.execSQL(cadena);
                break;
            default:
                //Si no se introduce un valor de "campo" válido, se muestra un mensaje informativo de tipo Toast.
                Toast.makeText(contexto, "ERROR AL BORRAR.", Toast.LENGTH_SHORT).show();
        }
    }

    //Método que cierra la conexión con la base de datos.
    public void close(){
        db.close();
    }

    //Método que lanza un mensaje Toast en función de si se ha conectado o no a la base de datos correctamente.
    public void conectado(Context contexto){
        if(db != null)
        {
            Toast.makeText(contexto, "Conectado correctamente a la BBDD.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(contexto, "No conectado.", Toast.LENGTH_SHORT).show();
        }
    }

    //Método que muestra valor en 'x' id de la tabla.
    public void mostrarValorEn(Context contexto, String campo, int id){
        switch(campo){
            case "categoria":
                Cursor c = db.rawQuery("SELECT categoria FROM notas WHERE _id="+id, null);
                if (c.moveToFirst()) {
                    String codigo = c.getString(0);
                    Toast.makeText(contexto, codigo, Toast.LENGTH_SHORT).show();
                }
            case "titulo":
                c = db.rawQuery("SELECT titulo FROM notas WHERE _id="+id, null);
                if (c.moveToFirst()) {
                    String codigo = c.getString(0);
                    Toast.makeText(contexto, codigo, Toast.LENGTH_SHORT).show();
                }
                break;
            case "descripcion":
                c = db.rawQuery("SELECT descripcion FROM notas WHERE _id="+id, null);
                if (c.moveToFirst()) {
                    String codigo = c.getString(0);
                    Toast.makeText(contexto, codigo, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                //Si no se introduce un valor de "campo" válido, se muestra un mensaje informativo de tipo Toast.
                Toast.makeText(contexto, "ERROR AL MOSTRAR.", Toast.LENGTH_SHORT).show();
        }
    }

    //Método que devuelve un ArrayList de objetos Nota con los datos de los registros de la tabla notas.
    public ArrayList<Nota> volcarDatosAL(){
        ArrayList<Nota> notas = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM notas", null);
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String id= c.getString(0);
                String categoria = c.getString(1);
                String titulo = c.getString(2);
                String descripcion = c.getString(3);
                notas.add(new Nota(Integer.valueOf(id),categoria,titulo,descripcion));
            } while(c.moveToNext());
        }
        return notas;
    }

    //Método que actualiza una línea de la tabla notas.
    public void actualizar(int id,String categoria,String titulo,String descripcion){
        String cadena = "update notas set categoria='"+categoria+"',titulo='"+titulo+"',descripcion='"+descripcion+"' where _id="+id;
        db.execSQL(cadena);
    }

    //Método que elimina una línea de la tabla notas.
    public void eliminar(int id){
        String cadena = "delete from notas where _id="+id;
        db.execSQL(cadena);
    }

    //Método que devuelve el id menor disponible en la tabla notas.
    public int devolverIdValido(int num){
        Cursor c = db.rawQuery("SELECT _id FROM notas", null);
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros.
            do {
                String id= c.getString(0);
                if(Integer.valueOf(id)==num){
                    num++;
                }
                else{
                    return num;
                }
            } while(c.moveToNext());
        }
        return num++;
    }
}
