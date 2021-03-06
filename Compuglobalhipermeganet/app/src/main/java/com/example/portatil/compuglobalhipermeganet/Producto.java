package com.example.portatil.compuglobalhipermeganet;

/**
 * Created by portatil on 15/03/2018.
 */

public class Producto {

    private String idproducto;
    private String idcategoria;
    private String nombre;
    private String corta;
    private String larga;
    private String idfoto;
    private String precio;


    public Producto(){
        this.idproducto="";
        this.idcategoria="";
        this.nombre="";
        this.corta="";
        this.larga="";
        this.idfoto="";
        this.precio="";
    }

    public Producto(String idproducto, String idcategoria, String nombre, String corta, String larga, String idfoto, String precio) {
        this.idproducto = idproducto;
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.corta = corta;
        this.larga = larga;
        this.idfoto = idfoto;
        this.precio = precio;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorta() {
        return corta;
    }

    public void setCorta(String corta) {
        this.corta = corta;
    }

    public String getLarga() {
        return larga;
    }

    public void setLarga(String larga) {
        this.larga = larga;
    }

    public String getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(String idfoto) {
        this.idfoto = idfoto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }




}


