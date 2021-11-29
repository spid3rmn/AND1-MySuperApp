package com.example.mykampustest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentSingleGuideBinding;
import java.util.ArrayList;

public class SingleGuideFragment extends Fragment {
    FragmentSingleGuideBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSingleGuideBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView tvTitle = binding.titleId;
        TextView tvText = binding.textId;

        //Retrieving data from Bundle
        tvTitle.setText(getArguments().getString("Title"));
        tvText.setText(getArguments().getString("Guide"));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
