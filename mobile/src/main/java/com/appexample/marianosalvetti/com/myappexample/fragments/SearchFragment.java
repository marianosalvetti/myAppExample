package com.appexample.marianosalvetti.com.myappexample.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.appexample.marianosalvetti.com.myappexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariano Salvetti on 11/06/2015.
 *
 */
public class SearchFragment extends ListFragment {

    private String[] valores = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
    private OnArticuloSelectedListener listener;

    public static final String TAG = "search";

    // Implements in the Activity
    public interface OnArticuloSelectedListener {
        void onArticuloSelected(String str);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.searchfragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnArticuloSelectedListener) activity;
        } catch (ClassCastException e) {
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, valores));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        listener.onArticuloSelected(valores[position]);
    }







}
