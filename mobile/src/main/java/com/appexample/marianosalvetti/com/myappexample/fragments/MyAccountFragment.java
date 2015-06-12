package com.appexample.marianosalvetti.com.myappexample.fragments;

import android.support.v4.app.Fragment;
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
public class MyAccountFragment extends Fragment {

    public static final String TAG = "myaccount";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.myaccountfragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
