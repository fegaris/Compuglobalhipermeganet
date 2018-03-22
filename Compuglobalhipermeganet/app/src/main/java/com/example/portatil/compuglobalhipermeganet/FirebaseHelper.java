package com.example.portatil.compuglobalhipermeganet;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Rachel on 19/03/2018.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved=null;
    ArrayList<Categoria> list_categ=new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
    //WRITE IF NOT NULL
    public Boolean save(Categoria categ)
    {
        if(categ==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Spacecraft").push().setValue(categ);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        if(dataSnapshot.getKey().toString().equals("categorias")){

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            //ds.getValue(Categoria.class
            Categoria categ=new Categoria();

            //categ.setNombre(ds.getChildren().toString());

            categ.setIdCategoria(ds.getKey());
            categ.setNombre(ds.child("nombre").getValue(String.class));
           categ.setUrl(ds.child("url").getValue(String.class));

            Log.d("Categoria", categ.toString());
            list_categ.add(categ);
        }}
    }
    //READ BY HOOKING ONTO DATABASE OPERATION CALLBACKS
    public ArrayList<Categoria> retrieve() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
                Log.d("categ", list_categ.size()+"");
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

        return list_categ;
    }

}
