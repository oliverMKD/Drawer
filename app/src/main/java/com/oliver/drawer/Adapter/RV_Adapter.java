package com.oliver.drawer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oliver.drawer.Models.PhotoModel;
import com.oliver.drawer.Photo;
import com.oliver.drawer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Oliver on 1/18/2018.
 */

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.ViewHolder> {

    PhotoModel model = new PhotoModel();
    Context context;

    public void setItems(ArrayList<Photo> photos) {
        model.photos = photos;
    }

    public RV_Adapter(PhotoModel model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public RV_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RV_Adapter.ViewHolder holder, final int position) {
//
         Photo photos = model.photos.get(position);

        Picasso.with(context).load(photos.getImage_url()).fit().into(holder.slika);

    }

    @Override
    public int getItemCount() {
        return model.photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.slika)
        ImageView slika;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
