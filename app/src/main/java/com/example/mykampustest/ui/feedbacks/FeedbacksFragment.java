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
    private final static String WEBSITE_TRUSTPILOT = "https://dk.trustpilot.com/review/kamtjatka.dk";
    private final static String WEBSITE_GOOGLE = "https://www.google.com/search?q=student+village+kamtjatka&oq=student&aqs=chrome.1.69i57j69i59l3j0i433j46i433j0i131i433j0l3.5269j0j15&sourceid=chrome&ie=UTF-8";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFeedbacksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.button4.setOnClickListener(this::onClickGoogle);;
        binding.button3.setOnClickListener(this::onClickTrustpilot);

        return root;
    }

    public void onClickGoogle(View view) {
        String action = Intent.ACTION_VIEW;
        Uri uri = Uri.parse(WEBSITE_GOOGLE);
        Intent intent = new Intent(action, uri);
        startActivity(intent);
    }

    public void onClickTrustpilot(View view) {
        String action = Intent.ACTION_VIEW;
        Uri uri = Uri.parse(WEBSITE_TRUSTPILOT);
        Intent intent = new Intent(action, uri);
        startActivity(intent);
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}