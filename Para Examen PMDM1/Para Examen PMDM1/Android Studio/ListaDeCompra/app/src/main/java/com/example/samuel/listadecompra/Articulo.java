package com.example.samuel.listadecompra;

/**
 * Created by Samuel on 30/10/2017.
 */

// Clase que se usa para definir las opciones del ListView
public class Articulo {
    // Cada opción tiene un título y un subtítulo
    private String nombre;
    private boolean comprado;
    public Articulo(String nombre, boolean comprado){
        this.nombre = nombre;
        this.comprado = comprado;
    }
    public  Articulo(String nombre){
        this.nombre = nombre;
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
}