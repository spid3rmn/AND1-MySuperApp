package com.example.mykampustest.ui.personal_information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentSlideshowBinding;
import com.example.mykampustest.ui.personal_information.ItemAdapter;
import com.example.mykampustest.ui.office_hours.Room;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    //private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;
    RecyclerView itemList;
    ItemAdapter itemAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);*/

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        itemList = binding.rvFlat;
        itemList.hasFixedSize();
        itemList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<Flat> flats = new ArrayList<>();
        flats.add(new Flat("A1", R.drawable.gym));
        flats.add(new Flat("A2", R.drawable.gym));
        flats.add(new Flat("B1", R.drawable.gym));
        flats.add(new Flat("B2", R.drawable.gym));
        flats.add(new Flat("C1", R.drawable.gym));

        itemAdapter = new ItemAdapter(flats);
        itemList.setAdapter(itemAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}