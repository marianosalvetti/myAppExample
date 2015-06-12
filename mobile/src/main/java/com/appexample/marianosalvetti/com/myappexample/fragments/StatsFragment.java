package com.appexample.marianosalvetti.com.myappexample.fragments;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.appexample.marianosalvetti.com.myappexample.R;
import com.appexample.marianosalvetti.com.myappexample.sandbox.Anime;
import com.appexample.marianosalvetti.com.myappexample.sandbox.AnimeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariano Salvetti on 11/06/2015.
 *
 * Un RecyclerView es un contenedor de elementos en forma de lista al igual que la clase ListView.
 * Aunque ambos tienen la misma función, este nuevo elemento permite “reciclar” los ítems que
 * ya no son visibles por el usuario debido al scrolling. Por lo que es ideal para proyectos que
 * manejan grandes volúmenes de items que se actualizan constantemente, limitando
 * la visibilidad de elemento
 *
 */
public class StatsFragment extends Fragment {

    public static final String TAG = "stats";

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statsfragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     /*   List<String> content = new ArrayList<>();
        content.add("list 1");
        content.add("list 2");
        content.add("list 3");
        content.add("list 4");
        content.add("list 5");
        content.add("list 6");
        content.add("list 7");
        ListView listView = (ListView) getActivity().findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, content));
    */

        // Inicializar Animes
        List items = new ArrayList();

        items.add(new Anime(R.drawable.avatar, "Angel Beats", 230));
        items.add(new Anime(R.drawable.imag_1, "Death Note", 456));
        items.add(new Anime(R.drawable.img_2, "Fate Stay Night", 342));
        items.add(new Anime(R.drawable.lnb_splash_screen_v, "Welcome to the NHK", 645));
        items.add(new Anime(R.drawable.presupuesto_lnb_1, "Suzumiya Haruhi", 459));
        items.add(new Anime(R.drawable.presupuesto_lnb_2, "Ultimo Elemento", 452));

// Obtener el Recycler
        recycler = (RecyclerView) getActivity().findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new AnimeAdapter(items);
        recycler.setAdapter(adapter);
    }
}
