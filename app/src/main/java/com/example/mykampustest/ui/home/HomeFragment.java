package com.example.mykampustest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    RecyclerView itemList;
    ItemAdapter itemAdapter;
    private static final int SPAN_COUNT = 2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        itemList = binding.rvHome;
        itemList.hasFixedSize();
        itemList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<Guide> guides = populateGuides();

        itemAdapter = new ItemAdapter(guides);
        itemList.setAdapter(itemAdapter);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(SPAN_COUNT, RecyclerView.VERTICAL);
        itemList.setLayoutManager(layoutManager);

        return root;
    }

    private ArrayList<Guide> populateGuides() {
        ArrayList<Guide> guides = new ArrayList<>();

        guides.add(new Guide("Welcome to Horsens", "What you need to know upon your arrival", R.string.welcome, R.drawable.welcome_p));
        guides.add(new Guide("Arriving in Denmark", "Practical information", R.string.arriving, R.drawable.denmark_p));
        guides.add(new Guide("Cleaning", "How to clean your room", R.string.cleaning, R.drawable.cleaning_p));
        guides.add(new Guide("Room inspection", "Need to know about", R.string.room_inspection, R.drawable.room_p));
        guides.add(new Guide("Maintenance", "How to request intervents", R.string.maintenance, R.drawable.maintenance_p));
        guides.add(new Guide("Keys", "Don't loose them", R.string.keys, R.drawable.keys_p));
        guides.add(new Guide("Checking out", "Information before leaving", R.string.check_out, R.drawable.check_out_p));
        guides.add(new Guide("Bicycles", "Parking and usage", R.string.bikes, R.drawable.bikes));
        guides.add(new Guide("Smoking", "Non-Smoking policy", R.string.smoking, R.drawable.smoking));

        return guides;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}