package com.appexample.marianosalvetti.com.myappexample.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appexample.marianosalvetti.com.myappexample.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SaludoActivityFragment extends Fragment {

    public SaludoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saludo, container, false);
    }
}
