package com.example.samuel.sqlitenotas;

/**
 * Created by Samuel on 09/12/2017.
 */

public class Nota {
    /*
        ATRIBUTOS.
     */
    int id;
    String titulo;
    String categoria;
    String descripcion;

    /*
        CONSTRUCTORES.
     */

    public Nota(int id, String titulo, String categoria, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    /*
        MÉTODOS.
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
