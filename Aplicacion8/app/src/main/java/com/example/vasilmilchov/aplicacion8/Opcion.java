package com.example.vasilmilchov.aplicacion8;

public class Opcion {

    String nombre;
    String nomLatin;
    String longitud;
    String lugar;
    int icono;

    public Opcion (String nombre, String nomLatin, String longitud, String lugar, int icono){
        this.nombre=nombre;
        this.nomLatin=nomLatin;
        this.longitud=longitud;
        this.lugar=lugar;
        this.icono=icono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNomLatin() {
        return nomLatin;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLugar() {
        return lugar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNomLatin(String nomLatin) {
        this.nomLatin = nomLatin;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
