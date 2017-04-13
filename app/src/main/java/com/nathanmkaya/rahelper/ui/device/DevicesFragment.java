package com.nathanmkaya.rahelper.ui.device;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nathanmkaya.rahelper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DevicesFragment extends Fragment {


    public DevicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devices, container, false);
    }

}
