package com.example.alumno.listviewactividad5;

public class Articulo {

    private String nombre;
    private boolean comprado;

    public Articulo(String nombre, boolean comprado){
        this.nombre = nombre;
        this.comprado = comprado;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isComprado() {
        return comprado;
    }
    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
    public String toString(){
        return nombre;
    }


}
