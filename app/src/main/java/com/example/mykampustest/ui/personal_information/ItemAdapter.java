package com.example.mykampustest.ui.personal_information;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mykampustest.R;
import com.example.mykampustest.ui.personal_information.Flat;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Flat> mFlats;

    ItemAdapter(ArrayList<Flat> flats){
        mFlats = flats;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.flats_card, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mainText.setText(mFlats.get(position).getMainText());
        viewHolder.cardImage.setImageResource(mFlats.get(position).getIconId());
    }

    public int getItemCount() {
        return mFlats.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView mainText;

        ViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.imageCard);
            mainText = itemView.findViewById(R.id.mainText);
        }
    }
}
