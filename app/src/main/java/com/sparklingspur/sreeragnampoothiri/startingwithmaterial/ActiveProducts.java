package com.sparklingspur.sreeragnampoothiri.startingwithmaterial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sreerag.nampoothiri on 17-Jul-15.
 */
public class ActiveProducts extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View android = inflater.inflate(R.layout.active_products, container, false);
        return android;
    }
}
