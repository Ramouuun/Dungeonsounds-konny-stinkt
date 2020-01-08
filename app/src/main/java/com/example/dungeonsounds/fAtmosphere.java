package com.example.dungeonsounds;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class fAtmosphere extends Fragment {


    public fAtmosphere() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_f_atmosphere, container, false);

        SeekBar swind = (SeekBar) v.findViewById(R.id.swind);

        return v;
    }

}
