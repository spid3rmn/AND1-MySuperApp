package com.example.mykampustest.ui.feedbacks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mykampustest.databinding.FragmentFeedbacksBinding;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FeedbacksFragment extends Fragment {
    private FragmentFeedbacksBinding binding;
    private final static String WEBSITE = "https://dk.trustpilot.com/review/kamtjatka.dk";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFeedbacksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.button3.setOnClickListener(this::onClickButton);

        return root;
    }

    public void onClickButton(View view) {
        String action = Intent.ACTION_VIEW;
        Uri uri = Uri.parse(WEBSITE);
        Intent intent = new Intent(action, uri);
        startActivity(intent);
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}