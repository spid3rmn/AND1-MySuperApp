package com.example.mykampustest.ui.office_hours;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mykampustest.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Room> mRooms;

    ItemAdapter(ArrayList<Room> rooms){
        mRooms = rooms;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_place, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mainText.setText(mRooms.get(position).getMainText());
        viewHolder.cardImage.setImageResource(mRooms.get(position).getIconId());
    }

    public int getItemCount() {
        return mRooms.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView mainText;

        ViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.imageCard);
            mainText = itemView.findViewById(R.id.catId);
        }
    }
}
