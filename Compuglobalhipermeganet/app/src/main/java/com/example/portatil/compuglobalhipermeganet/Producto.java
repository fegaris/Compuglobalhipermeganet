package com.example.portatil.compuglobalhipermeganet;

/**
 * Created by portatil on 15/03/2018.
 */

public class Producto {

        private String idProducto;
        private String nombre;
        private String descripcionBreve;
        private String detalle;
        private String idFoto;
        private float precio;

    public Producto(String idProducto, String nombre, String descripcionBreve, String detalle, String idFoto, float precio) {
            this.idProducto = idProducto;
            this.nombre = nombre;
            this.descripcionBreve = descripcionBreve;
            this.detalle = detalle;
            this.idFoto = idFoto;
            this.precio = precio;
        }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}







