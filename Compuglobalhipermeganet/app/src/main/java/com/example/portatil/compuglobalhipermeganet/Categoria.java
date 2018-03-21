package com.example.portatil.compuglobalhipermeganet;

/**
 * Created by Rachel on 19/03/2018.
 */

public class Categoria {
    private String idCategoria;
    private String nombre;
    private String url;

    public Categoria() {
    }

    public Categoria(String idCategoria, String nombre, String url) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.url = url;
    }

    public Categoria(Categoria value) {
        idCategoria = value.idCategoria;
        nombre = value.nombre;
        url = value.url;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
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

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria='" + idCategoria + '\'' +
                ", nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
