package com.example.mykampustest.ui.faq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mykampustest.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Faq> faqs;

    ItemAdapter(ArrayList<Faq> faqs){
        this.faqs = faqs;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_faq, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.question.setText(faqs.get(position).getQuestion());
        viewHolder.answer.setText(faqs.get(position).getAnswer());
    }

    public int getItemCount() {
        return faqs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        TextView answer;

        ViewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.catId);
            answer = itemView.findViewById(R.id.answ);
        }
    }
}
