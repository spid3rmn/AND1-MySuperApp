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
            args.putString("Text", mGuides.get(position).getSmallDesc());
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_single_guide, args);
        });
    }

    public int getItemCount() {
        return mGuides.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView cardImage;
        TextView mainText;
        TextView descText;

        ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView; //oppure view?
            cardImage = itemView.findViewById(R.id.imageCard);
            mainText = itemView.findViewById(R.id.catId);
            descText = itemView.findViewById(R.id.descId);
        }
    }
}

/*public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    Consumer<Integer> onClickCb;

    ItemAdapter(List<String> all, Consumer<Integer> cb) {
        onClickCb = cb;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.view.setOnClickListener((View view) -> {
            onClickCb.accept(position);
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = view;
        }


    }
}*/
