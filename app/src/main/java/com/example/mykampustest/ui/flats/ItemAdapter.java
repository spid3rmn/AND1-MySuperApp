package com.example.mykampustest.ui.flats;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mykampustest.R;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<Flat> mFlats;
    private Context context;

    ItemAdapter(ArrayList<Flat> flats, Context context){
        mFlats = flats;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.flats_card, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.catText.setText(mFlats.get(position).getCategory());
        viewHolder.descText.setText(mFlats.get(position).getDescription());
        viewHolder.rentText.setText(mFlats.get(position).getRent());

        //Every flat has a different Url for booking
        viewHolder.bookButt.setOnClickListener(v -> {
            String action = Intent.ACTION_VIEW;
            Uri uri = Uri.parse(mFlats.get(position).getUrl());
            Intent intent = new Intent(action, uri);
            context.startActivity(intent);
        });
    }

    public int getItemCount() {
        return mFlats.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView catText;
        TextView descText;
        TextView rentText;
        Button bookButt;

        ViewHolder(View itemView) {
            super(itemView);
            catText = itemView.findViewById(R.id.catId);
            descText = itemView.findViewById(R.id.descId);
            rentText = itemView.findViewById(R.id.rentId);
            bookButt = itemView.findViewById(R.id.bookButtId);
        }
    }
}
