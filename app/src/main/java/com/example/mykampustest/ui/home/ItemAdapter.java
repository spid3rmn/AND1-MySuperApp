package com.example.mykampustest.ui.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mykampustest.R;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Guide> mGuides;

    ItemAdapter(ArrayList<Guide> guides){
        mGuides = guides;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_guide, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.cardImage.setImageResource(mGuides.get(position).getIconId());
        viewHolder.mainText.setText(mGuides.get(position).getName());
        viewHolder.descText.setText(mGuides.get(position).getSmallDesc());
    }

    public int getItemCount() {
        return mGuides.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView mainText;
        TextView descText;

        ViewHolder(View itemView) {
            super(itemView);
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
