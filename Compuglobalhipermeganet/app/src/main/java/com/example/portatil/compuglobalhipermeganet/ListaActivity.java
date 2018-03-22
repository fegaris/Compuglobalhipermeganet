package com.example.portatil.compuglobalhipermeganet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView rv;
    private List<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true); //si el tamaño no cambia, esto mejora el desempeño
        rv.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=this.getIntent();
        String valorCategoria =intent.getStringExtra("categoria");

        final DatabaseReference dbProductos = FirebaseDatabase.getInstance().getReference().child("productos");
        Log.d("pruebas", "laura- "+valorCategoria);
        Log.d("pruebas", "laura- "+dbProductos.getKey());
        Log.d("pruebas", "laura- "+dbProductos.getDatabase());
                //.orderByChild("categorias").equalTo(valorCategoria));

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idCategoria = dataSnapshot.getValue(String.class);

                /* dinosaursRef.child("stegosaurus").child("height").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot stegoHeightSnapshot) {
        Integer favoriteDinoHeight = stegoHeightSnapshot.getValue(Integer.class);
        Query query = dinosaursRef.orderByChild("height").endAt(favoriteDinoHeight).limitToLast(2);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Data is ordered by increasing height, so we want the first entry
                DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                System.out.println("The dinosaur just shorter than the stegosaurus is: " + firstChild.getKey());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // ...
    }
});*/

                //aquí, a través del objeto dataSnapshot, puedes acceder mediate childs a sus nodos hijos, que son las categorias
                //puedes recorrer las categorías y de cada una acceder a sus hijos nombre y url y con los métodos getValue() de estos recuperar sus valores
                Query categoriaEscogida = dataSnapshot.orderByChild("categorias").equalTo("cat_1");
                Log.d("pruebas", qu.toString());

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String idCategoria = ds.getKey();
                    Log.d("pruebas", "idCategoria" + idCategoria);

                    String name = ds.child("nombre").getValue(String.class);
                    Log.d("pruebas", "name" + name);

                    String dir = ds.child("url").getValue(String.class);
                    Log.d("pruebas", "dir " + dir);

                    Categoria categ=ds.getValue(Categoria.class);

                    Log.d("pruebas", "categ " + categ.toString());
                    // list_categ.add(categ);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("pruebas", "Error!", databaseError.toException());
            }
        };

        dbProductos.addValueEventListener(eventListener);


    }




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
