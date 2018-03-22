package com.example.portatil.compuglobalhipermeganet;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by portatil on 16/03/2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProductoViewHolder>{

    List<Producto> listadoProd;

    RVAdapter(List<Producto> productos){
        this.listadoProd = productos;
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView productoNombre;
        TextView productoDescripBreve;
        ImageView productoIdFoto;
        TextView productoPrecio;

        ProductoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            productoNombre = (TextView)itemView.findViewById(R.id.nombre);
            productoDescripBreve = (TextView)itemView.findViewById(R.id.descripcionBreve);
            productoIdFoto = (ImageView)itemView.findViewById(R.id.idFoto);
            productoPrecio = (TextView)itemView.findViewById(R.id.precio);
        }
    }

    @Override
    public int getItemCount() {
        return listadoProd.size();
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_productos, parent, false);
        ProductoViewHolder pvh = new ProductoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
        holder.productoNombre.setText(listadoProd.get(position).getNombre());
        //holder.productoDescripBreve.setText(listadoProd.get(position).getDescripcionBreve());
        //  Glide.with(mContext).load(mDataset.get(position).getImageUrl()).into(holder.mImgtView);
        //Glide.with(mContext).load("http://goo.gl/gEgYUd").into(holder.mImgtView);
        //holder.productoIdFoto.setImageResource(listadoProd.get(position).getIdFoto());
      //  holder.productoPrecio.setText(listadoProd.get(position).precio);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
