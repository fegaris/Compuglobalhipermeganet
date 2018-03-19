package com.example.portatil.compuglobalhipermeganet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
