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

        guides.add(new Guide("Welcome to Horsens", "What you need to know upon your arrival",
                "Do you have any questions about the Danish way of life? Would you like to know more \n" +
                        "places to socialize in Horsens? Or do you want to make a career for yourself at one of the \n" +
                        "\n" +
                        "many interesting companies in the Horsens area? Our welcome guide is your helping hand \n" +
                        "\n" +
                        "when settling in Horsens. Please contact BusinessHorsens to learn more.\n" +
                        "BusinessHorsens can also arrange for you to talk to one of our welcome ambassadors – \n" +
                        "a group of knowledgeable and friendly volunteer international citizens who are eager to \n" +
                        "\n" +
                        "answer any practical questions you might have about settling and living in Horsens.\n" +
                        "BusinessHorsens\n" +
                        "Vitus Bering Innovation Park\n" +
                        "\n" +
                        "Chr. M. Østergaards Vej 4a\n" +
                        "\n" +
                        "DK-8700 Horsens\n" +
                        "Phone: +45 7561 1888\n" +
                        "E-mail: mail@businesshorsens.dk\n" +
                        "\n" +
                        "Opening hours: Monday - Thursday: 8.00 am - 3.00 pm and Friday 8.00 am - 2.00 pm",R.drawable.welcome));
        guides.add(new Guide("Arriving in Denmark", "Practical information",
                "To make sure that you have all the right papers and registrations you need in order to be able \n" +
                        "to work and live in Denmark, we have collected some information for you about the official \n" +
                        "\n" +
                        "matters to take care of when moving to Denmark. \n" +
                        "International Citizen Service – all the services you need in one place\n" +
                        "The International Citizen Service (ICS) makes dealing with Danish authorities as easy as pos-\n" +
                        "sible – for you, your partner, and for Danish companies that employ foreign workers. \n" +
                        "\n" +
                        "You will find an International Citizen Service office in each of the four largest cities in Den-\n" +
                        "\n" +
                        "mark: Copenhagen, Aarhus, Odense and Aalborg. The Municipality of Horsens works with ICS \n" +
                        "\n" +
                        "Aarhus to ensure that you get off to a good start in Denmark and Horsens.\n" +
                        "All the public authorities you typically need to deal with are represented at ICS Aarhus. In most \n" +
                        "cases, you will only need to talk to your ICS office to take care of your paperwork and find \n" +
                        "\n" +
                        "answers to your questions. ", R.drawable.denmark));
        guides.add(new Guide("Residency", "how to", "guide", R.drawable.gym));
        guides.add(new Guide("Inventary", "how to", "guide", R.drawable.gym));

        return guides;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}