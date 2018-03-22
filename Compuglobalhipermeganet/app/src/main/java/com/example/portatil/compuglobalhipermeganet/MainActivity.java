package com.example.portatil.compuglobalhipermeganet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button boton;
    DatabaseReference db;
    FirebaseHelper helper;
    AdaptadorCategory adapter;

    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button)findViewById(R.id.button2);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
            }
        });


        gv = (GridView) findViewById(R.id.gridprincipal);

        //INITIALIZE FIREBASE DB
       db = FirebaseDatabase.getInstance().getReference();

      
        //db =  FirebaseDatabase.getInstance().getReference()
          //      .child("categorias");
        helper = new FirebaseHelper(db);

        //ADAPTER
        adapter = new AdaptadorCategory(this, helper.retrieve());
        gv.setAdapter(adapter);

        //Pongo los estilos


        gv.setVerticalSpacing(10);
        gv.setHorizontalSpacing(10);

    }

public void contactar(View view)
{
    Intent in=new Intent(this,ContactoActivity.class);
    this.startActivity(in);
}

}
