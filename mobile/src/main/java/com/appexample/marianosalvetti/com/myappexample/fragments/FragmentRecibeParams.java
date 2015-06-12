package com.appexample.marianosalvetti.com.myappexample.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appexample.marianosalvetti.com.myappexample.R;
import com.appexample.marianosalvetti.com.myappexample.utils.LoggingUtility;

/**
 * Created by Mariano Salvetti on 12/06/2015.
 *
 */
public class FragmentRecibeParams extends Fragment {
    public static final String TAG = "recibe_param";
    private static final String LOG_TAG = "RecibeParams";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recibe_params, container, false);

        Bundle bundle = getArguments();
        String recuperada = bundle.getString("str");

        TextView texto = (TextView) view.findViewById(R.id.texto_param);
        texto.setText("Ha seleccionado la opcion:" + "\n\n" + recuperada);

        LoggingUtility.d(LOG_TAG, "Ha seleccionado la opcion: " + recuperada);
        return view;
    }

}