package com.example.mykampustest.ui.office_hours;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentOfficeHoursBinding;

import java.util.ArrayList;

public class OfficeHoursFragment extends Fragment {

    //private OfficeHoursViewModel officeHoursViewModel;
    private FragmentOfficeHoursBinding binding;
    RecyclerView itemList;
    ItemAdapter itemAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*officeHoursViewModel =
                new ViewModelProvider(this).get(OfficeHoursViewModel.class);*/

        binding = FragmentOfficeHoursBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*final TextView textView = binding.textOfficeHours;
        officeHoursViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        itemList = binding.rv;
        itemList.hasFixedSize();
        itemList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Office", R.drawable.gym));
        rooms.add(new Room("Gym", R.drawable.gym));
        rooms.add(new Room("Common Room", R.drawable.gym));
        rooms.add(new Room("Gaming Room", R.drawable.gym));
        rooms.add(new Room("Laundry room", R.drawable.gym));

        itemAdapter = new ItemAdapter(rooms);
        itemList.setAdapter(itemAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
