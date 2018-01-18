package com.oliver.drawer.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.oliver.drawer.Adapter.RV_Adapter;
import com.oliver.drawer.Models.PhotoModel;
import com.oliver.drawer.Photo;
import com.oliver.drawer.R;
import com.oliver.drawer.api.RestApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Oliver on 1/11/2018.
 */

public class Fragment_Photos extends Fragment {
    RestApi api = new RestApi(getContext());
    private Unbinder mUnbinder;
    PhotoModel photosModel = new PhotoModel();
    RV_Adapter mAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar1)
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos,null);
        mUnbinder = ButterKnife.bind(this, view);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));


        Call<PhotoModel> call = api.getPhotos("fresh_today");
        call.enqueue(new Callback<PhotoModel>() {

            @Override
            public void onResponse(Call<PhotoModel> call, Response<PhotoModel> response) {
                if (response.code() == 200) {
                    photosModel = response.body();
                    mAdapter = new RV_Adapter(photosModel, getActivity());
                    mRecyclerView.setAdapter(mAdapter);

                    progressBar.setVisibility(View.INVISIBLE);
                } else if (response.code() == 401) {
                    Toast.makeText(getContext(), "OUPS!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PhotoModel> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }





    @Override
    public void onDestroy(){
        super.onDestroy();
        mUnbinder.unbind();
    }
}
