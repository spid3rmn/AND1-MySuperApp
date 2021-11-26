package com.example.mykampustest.ui.faq;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentFaqBinding;

import com.example.mykampustest.databinding.FragmentOfficeHoursBinding;
import com.example.mykampustest.ui.faq.ItemAdapter;
import com.example.mykampustest.ui.office_hours.Room;

import java.util.ArrayList;

public class FaqFragment extends Fragment {
        private FragmentFaqBinding binding;
        RecyclerView itemList;
        ItemAdapter itemAdapter;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {

            binding = FragmentFaqBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            itemList = binding.rvFaq;
            itemList.hasFixedSize();
            itemList.setLayoutManager(new LinearLayoutManager(this.getContext()));

            ArrayList<Faq> faqs = new ArrayList<>();
            faqs.add(new Faq("Hey", "fuck"));
            faqs.add(new Faq("Gym", "hh"));
            faqs.add(new Faq("Common Room", "hfh"));
            faqs.add(new Faq("Gaming Room", "hhf"));
            faqs.add(new Faq("Laundry room", "hdh"));

            itemAdapter = new ItemAdapter(faqs);
            itemList.setAdapter(itemAdapter);

            return root;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
}