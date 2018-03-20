package com.example.portatil.compuglobalhipermeganet;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Rachel on 15/03/2018.
 */

public class AdaptadorCategory extends BaseAdapter {
    Context context;
    ArrayList<Categoria> lis_categ;

    public AdaptadorCategory(Context c, ArrayList<Categoria> lis_categ) {
        this.context = c;
        this.lis_categ = lis_categ;
    }

    @Override
    public int getCount() {
        return lis_categ.size();
    }

    @Override
    public Categoria getItem(int position) {
        return lis_categ.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("raquel", "Estoy en getView");
        Log.d("raquel", "position vale" + position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);
        }

       ImageView imagen_categoria = (ImageView) convertView.findViewById(R.id.imgCategoria);
       TextView nombre =(TextView)convertView.findViewById(R.id.text);


        final Categoria item = getItem(position);


        nombre.setText(item.getNombre());
        Glide.with(imagen_categoria.getContext())
                .load(lis_categ.get(0).getUrl())
                .into(imagen_categoria );

//Cuando hago click en la grilla me lleva a la actividad de detalle
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAIL
                openDetailActivity(item.getNombre());
            }
        });


        return convertView;
    }


    //OPEN DETAIL ACTIVITY

    private void openDetailActivity(String...details)
    {

        Intent i=new Intent(context,DetailActivity.class);

        i.putExtra("categoria",details[0]);

        Log.d("raquel" , "el nombre que paso es " + details[0] );


        context.startActivity(i);
    }

}