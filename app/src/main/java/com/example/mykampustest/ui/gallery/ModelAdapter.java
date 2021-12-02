package com.example.mykampustest.ui.gallery;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mykampustest.R;
import com.example.mykampustest.ui.common_rooms.Room;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {
    private ArrayList<Model> models;

    ModelAdapter(ArrayList<Model> models){
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Uri uri = models.get(position).getImage();
        Log.d("d2", uri.toString());
        viewHolder.cardImage.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView cardImage;

        ViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.imageCard);
        }
    }
}
