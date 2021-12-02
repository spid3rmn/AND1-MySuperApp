package com.example.mykampustest.ui.common_rooms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentOfficeHoursBinding;
import java.util.ArrayList;

public class CommonRoomsFragment extends Fragment {
    private FragmentOfficeHoursBinding binding;
    RecyclerView itemList;
    ItemAdapter itemAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentOfficeHoursBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        itemList = binding.rv;
        itemList.hasFixedSize();
        itemList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<Room> rooms = populateRooms();

        itemAdapter = new ItemAdapter(rooms);
        itemList.setAdapter(itemAdapter);

        return root;
    }

    private ArrayList<Room> populateRooms() {
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Office", "Monday and Wednesday 13:30-15:30 Friday 7:30-8:30", "Where you can pay rent, request information, fill papers and ask all your questions", R.drawable.office_p));
        rooms.add(new Room("Common Room", "Sunday – Thursday 12pm – 6am", "The perfect place to enjoy campus life: board games, music and international dinners", R.drawable.common_p));
        rooms.add(new Room("Gym", "Always open", "All you need to get fit", R.drawable.gym_p));
        rooms.add(new Room("Gaming Room", "Sunday – Thursday 12pm – 6am", "The room to have fun. You can watch netflix or disney+, listen to spotify, play to PS4, table soccer and ping pong", R.drawable.gaming_p));
        rooms.add(new Room("Laundry room", "Always open", "Washing machines and dryers", R.drawable.laundry_p));

        return rooms;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
