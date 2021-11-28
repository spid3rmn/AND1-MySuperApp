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

        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),SPAN_COUNT);
        itemList.setLayoutManager(layoutManager);

        return root;
    }

    private ArrayList<Guide> populateGuides() {
        ArrayList<Guide> guides = new ArrayList<>();

        guides.add(new Guide("Waste", "how to", R.drawable.gym));
        guides.add(new Guide("Laundry", "how to", R.drawable.gym));
        guides.add(new Guide("Residency", "how to", R.drawable.gym));
        guides.add(new Guide("Inventary", "how to", R.drawable.gym));

        return guides;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}