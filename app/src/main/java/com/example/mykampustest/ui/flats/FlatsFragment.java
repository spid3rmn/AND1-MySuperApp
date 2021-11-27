package com.example.mykampustest.ui.flats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mykampustest.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;

public class FlatsFragment extends Fragment {
    private FragmentSlideshowBinding binding;
    RecyclerView itemList;
    ItemAdapter itemAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        itemList = binding.rvFlat;
        itemList.hasFixedSize();
        itemList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<Flat> flats = populateFlats();

        itemAdapter = new ItemAdapter(flats, getContext());
        itemList.setAdapter(itemAdapter);

        return root;
    }

    private ArrayList<Flat> populateFlats() {
        ArrayList<Flat> flats = new ArrayList<>();

        flats.add(new Flat("Category A1", "One-storey flat for 2 persons – " +
                "2 private rooms, shared bathroom and kitchen/living room.",
                "Rent: 2.700 DKK\n" +
                        "+ consumption (550 DKK)\n" +
                        "Deposit: 5.900 DKK", "a/"));
        flats.add(new Flat("Category A2", "One-storey flat for 2 persons – " +
                "2 private rooms, shared bathroom and kitchen/living room.",
                "Rent: 2.500 DKK\n" +
                        "+ consumption (600 DKK)\n" +
                        "Deposit: 5.900 DKK", "a-2/"));
        flats.add(new Flat("Category B", "One-storey flat for 3 persons – 3 private rooms, " +
                "shared bathroom and kitchen/living room.",
                "Rent: 2.400 DKK\n" +
                        "+ consumption (600 DKK)\n" +
                        "Deposit: 5.900 DKK", "b/"));
        flats.add(new Flat("Category C", "One-storey flat for 1 person – 1 room with " +
                "kitchen and shared bathroom.",
                "Rent: 3.097 DKK\n" +
                        "+ consumption (600 DKK)\n" +
                        "Deposit: 6.200 DKK", "c/"));
        flats.add(new Flat("Category D", "One-story flat for 1 person – 1 room with " +
                "sleeping area, living room, kitchen and bathroom.",
                "Rent: 3.313 DKK\n" +
                        "+ consumption (600 DKK)\n" +
                        "Deposit: 6.700 DKK", "d/"));
        flats.add(new Flat("Category E", "One-story flat for 1 person – 1 bedroom, 1 " +
                "living room with kitchen and bathroom.",
                "Rent: 3.500 DKK\n" +
                        "+ consumption (600 DKK)\n" +
                        "Deposit: 7.500 DKK", "e/"));
        flats.add(new Flat("Category F", "Two-story flat for 1 person – 1 room with kitchen " +
                "and bathroom, access to first floor with sleeping area.",
                "Rent: 4.200 DKK\n" +
                        "+ consumption (800 DKK)\n" +
                        "Deposit: 9.000 DKK", "f/"));

        return flats;
    }

    public void onButtonClick(View v) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}