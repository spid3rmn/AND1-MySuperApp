package com.example.mykampustest.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentGalleryBinding;
import com.example.mykampustest.ui.home.Guide;
import com.example.mykampustest.ui.home.ItemAdapter;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding binding;
    RecyclerView modelsList;
    //ModelAdapter modelAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*// Reference to an image file in Cloud Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();

        // ImageView in your Activity
        ImageView imageView = findViewById(R.id.imageView);

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        Glide.with(getContext())
                .load(storageReference)
                .into(imageView);

        Glide.with(getContext)
                .load*/

        /*modelsList = binding.rvGallery;
        modelsList.hasFixedSize();
        modelsList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        modelAdapter = new Adapter(guides);
        itemList.setAdapter(itemAdapter);

        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),SPAN_COUNT);
        itemList.setLayoutManager(layoutManager);

        fetchData();*/

        return root;
    }

    private void fetchData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}