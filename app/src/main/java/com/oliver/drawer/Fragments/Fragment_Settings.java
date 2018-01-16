package com.oliver.drawer.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oliver.drawer.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Oliver on 1/11/2018.
 */

public class Fragment_Settings extends Fragment {
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,null);
        mUnbinder = ButterKnife.bind(this, view);

        return view;


    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mUnbinder.unbind();
    }
}
