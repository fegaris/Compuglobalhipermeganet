package com.example.portatil.compuglobalhipermeganet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button boton;

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
    }

    public void mostrarProductos(View view)
    {
        // Start the next activity
        Intent in = new Intent().setClass(
                MainActivity.this, ListaActivity.class);
        in.putExtra("categoria","cat_1");
        startActivity(in);
    }
}
