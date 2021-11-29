package com.example.mykampustest.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mykampustest.R;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<Guide> mGuides;

    ItemAdapter(ArrayList<Guide> guides){
        mGuides = guides;
    }
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_guide, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.cardImage.setImageResource(mGuides.get(position).getIconId());
        viewHolder.mainText.setText(mGuides.get(position).getName());
        viewHolder.descText.setText(mGuides.get(position).getSmallDesc());

        viewHolder.view.setOnClickListener((View view) -> {
            Bundle args = new Bundle();

            args.putString("Title", mGuides.get(position).getName());
            args.putString("Guide", mGuides.get(position).getGuide());

            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_single_guide, args);
        });
    }

    public int getItemCount() {
        return mGuides.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        TextView mainText;
        TextView descText;
        ImageView cardImage;

        ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            cardImage = itemView.findViewById(R.id.imageCard);
            mainText = itemView.findViewById(R.id.catId);
            descText = itemView.findViewById(R.id.smallDescId);
        }
    }
}