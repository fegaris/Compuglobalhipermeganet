package com.example.portatil.compuglobalhipermeganet;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        rv = (RecyclerView)findViewById(R.id.rv);
        //si el tamaño no cambia, esto mejora el desempeño
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

    }

    private List<Producto> productos;


    //String idProducto, String nombre, String descripcionBreve, String detalle, String idFoto, float precio
    private void initializeData(){
        productos = new ArrayList<>();
        productos.add(new Producto("P001", "triciclo r", "triciclo rojo", "triciclo rojo de 50cm para 3 años", "triciclo.png", 55.90f));
        productos.add(new Producto("P002", "triciclo a", "triciclo azul", "triciclo azul de 50cm para 3 años", "triciclo.png", 55.90f));
        productos.add(new Producto("P003", "triciclo v", "triciclo verde", "triciclo verde de 50cm para 3 años", "triciclo.png", 55.90f));

        RVAdapter adapter = new RVAdapter(productos);
        rv.setAdapter(adapter);
    }
}
