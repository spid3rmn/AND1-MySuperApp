package com.example.mykampustest.ui.common_rooms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mykampustest.R;
import com.facebook.drawee.view.SimpleDraweeView;

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
        viewHolder.cardImage.setActualImageResource(mRooms.get(position).getIconId());
        viewHolder.mainText.setText(mRooms.get(position).getMainText());
        viewHolder.hoursText.setText(mRooms.get(position).getHoursText());
        viewHolder.descText.setText(mRooms.get(position).getDescText());
    }

    public int getItemCount() {
        return mRooms.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView cardImage;
        TextView mainText;
        TextView descText;
        TextView hoursText;

        ViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.imageCard);
            mainText = itemView.findViewById(R.id.catId);
            hoursText = itemView.findViewById(R.id.smallDescId);
            descText = itemView.findViewById(R.id.descId);
        }
    }
}
