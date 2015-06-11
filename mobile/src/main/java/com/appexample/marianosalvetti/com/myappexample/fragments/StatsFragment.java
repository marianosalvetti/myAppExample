package com.appexample.marianosalvetti.com.myappexample.fragments;

import android.app.Fragment;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class StatsFragment extends Fragment {

    public static final String TAG = "stats";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statsfragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> content = new ArrayList<>();
        content.add("list 1");
        content.add("list 2");
        content.add("list 3");
        content.add("list 4");
        content.add("list 5");
        content.add("list 6");
        content.add("list 7");
        ListView listView = (ListView) getActivity().findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, content));
    }
}
