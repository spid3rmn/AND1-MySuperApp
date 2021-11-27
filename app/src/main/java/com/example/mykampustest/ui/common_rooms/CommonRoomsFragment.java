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

        //TODO Change photos hours and description
        rooms.add(new Room("Office", "Monday / Wednesday / Friday 10am - 2 pm", "", R.drawable.gym));
        rooms.add(new Room("Common Room", "Sunday – Thursday 12pm – 6am", "", R.drawable.common));
        rooms.add(new Room("Gym", "Always open", "", R.drawable.gym));
        rooms.add(new Room("Gaming Room", "Sunday – Thursday 12pm – 6am", "", R.drawable.gym));
        rooms.add(new Room("Laundry room", "Always open", "", R.drawable.gym));

        return rooms;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
