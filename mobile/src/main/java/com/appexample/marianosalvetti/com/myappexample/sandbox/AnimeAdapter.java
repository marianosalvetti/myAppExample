package com.appexample.marianosalvetti.com.myappexample.sandbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appexample.marianosalvetti.com.myappexample.R;

import java.util.List;

/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private List<Anime> items;

    public AnimeAdapter(List items) {
        this.items = items;
    }

    public class AnimeViewHolder extends RecyclerView.ViewHolder {

        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;

        public AnimeViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);

        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder viewHolder, int position) {
        //Here you can fill your row view
        viewHolder.imagen.setImageResource(items.get(position).getImagen());
        viewHolder.nombre.setText(items.get(position).getNombre());
        viewHolder.visitas.setText("Visitas:"+String.valueOf(items.get(position).getVisitas()));

    }



}
