package com.example.rcc.pruebas_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference db;
    private ValueEventListener eventListener;
   private ArrayList<Categoria> list_categ =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         db =  FirebaseDatabase.getInstance().getReference()
                        .child("categorias");



        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                TextView nombre= (TextView)findViewById(R.id.tvnombre);
                TextView url= (TextView)findViewById(R.id.tvurl);

                list_categ.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Categoria categ =ds.getValue(Categoria.class);
                    list_categ.add(categ);
                }

                //TEngo que crear array list
               // list_categ = dataSnapshot.getValue(Categoria.class);
                nombre.setText(list_categ.get(0).getNombre());
                url.setText(list_categ.get(0).getUrl());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Raquel", "Error!", databaseError.toException());
            }
        };

        db.addValueEventListener(eventListener);
    }


}
