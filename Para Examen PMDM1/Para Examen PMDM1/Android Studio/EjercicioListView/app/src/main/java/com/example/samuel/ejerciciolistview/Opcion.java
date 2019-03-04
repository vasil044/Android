package com.example.samuel.ejerciciolistview;

/**
 * Created by Samuel on 23/10/2017.
 */

public class Opcion {
    //Atributos.
    String nombre;
    int ref_icono;
    boolean check;


    //Constructores.
    public Opcion(String nombre, int ref_icono, boolean check)
    {
        this.nombre=nombre;
        this.ref_icono=ref_icono;
        this.check=check;
    }

    //Métodos.
    //Getters&Setters.
    public String getNombre() {
        return nombre;
    }

    public int getRef_icono() {
        return ref_icono;
    }

    public boolean isCheck() {
        return check;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRef_icono(int ref_icono) {
        this.ref_icono = ref_icono;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
