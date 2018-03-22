package com.example.portatil.compuglobalhipermeganet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.portatil.compuglobalhipermeganet.Producto;
import com.example.portatil.compuglobalhipermeganet.R;
import com.example.portatil.compuglobalhipermeganet.RVAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ListaActivity extends AppCompatActivity {

    RecyclerView rv;
    private ArrayList<Producto> productos;
    DatabaseReference dbProductos;
    //Query consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true); //si el tamaño no cambia, esto mejora el desempeño
        rv.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=this.getIntent();
        final String valorCategoria =intent.getStringExtra("categoria");
        Log.d("pruebas", "laura "+ valorCategoria);

        dbProductos = FirebaseDatabase.getInstance().getReference();
        // dbProductos.child("productos").child("categoria").startAt("cat_1").endAt("cat_1");



        //.orderByChild("categorias").equalTo(valorCategoria));

        RVAdapter adapter = new RVAdapter(this.retrieve());
        rv.setAdapter(adapter);
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
Log.d("pruebas", "revisando dato" + dataSnapshot.getValue().toString());
        if(dataSnapshot.getKey().toString().equals("productos")){

            for (DataSnapshot ds : dataSnapshot.getChildren())
            {
                //ds.getValue(Categoria.class
                Producto prod=new Producto();

                prod.setIdproducto(ds.child("idproducto").getValue(String.class));
                prod.setIdcategoria(ds.child("categoria").getKey());
                prod.setNombre(ds.child("nombre").getValue(String.class));
                prod.setCorta(ds.child("corta").getValue(String.class));
                prod.setIdfoto(ds.child("idfoto").getValue(String.class));
                prod.setLarga(ds.child("larga").getValue(String.class));
                prod.setPrecio(ds.child("precio").getValue(String.class));
                productos.add(prod);

                Log.d("pruebas", productos.toString() );
            }}}

    public ArrayList<Producto> retrieve() {
        Log.d("po", "retrieve");
        final ChildEventListener childEventListener = dbProductos.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return productos;
    }


}
