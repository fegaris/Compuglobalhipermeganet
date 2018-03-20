package com.example.rcc.pruebas_firebase;

/**
 * Created by portatil on 19/03/2018.
 */

public class Categoria {
    private String nombre;
    private String url;

    public Categoria() {
    }

    public Categoria(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
