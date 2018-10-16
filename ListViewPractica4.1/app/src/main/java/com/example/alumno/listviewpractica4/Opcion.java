package com.example.alumno.listviewpractica4;

public class Opcion {

    String nombre;
    int icono;
    boolean marcado;

    public Opcion(String nom, int ic, boolean mar){
        nombre=nom;
        icono=ic;
        marcado=mar;
    }

    public String getNombre(){
        return nombre;
    }
    public int getIcono(){
        return icono;
    }
    public boolean getSeleccionado(){
        return marcado;
    }
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setIcono(int ic){
        icono=ic;
    }
    public void setSeleccionado(boolean mar){
        marcado=mar;
    }

}
