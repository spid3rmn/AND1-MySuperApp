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

import com.example.mykampustest.databinding.FragmentOfficeHoursBinding;

public class OfficeHoursFragment extends Fragment {

    private OfficeHoursViewModel officeHoursViewModel;
    private FragmentOfficeHoursBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        officeHoursViewModel =
                new ViewModelProvider(this).get(OfficeHoursViewModel.class);

        binding = FragmentOfficeHoursBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textOfficeHours;
        officeHoursViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
