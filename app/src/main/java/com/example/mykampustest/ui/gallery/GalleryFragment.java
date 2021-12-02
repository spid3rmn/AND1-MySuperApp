package com.example.mykampustest.ui.gallery;

import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private static final String TAG = "GalleryFragment";
    private FragmentGalleryBinding binding;
    RecyclerView modelsList;
    ModelAdapter modelAdapter;
    ArrayList<Model> models = new ArrayList<>();
    private final int SPAN_COUNT = 3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Reference to an image file in Cloud Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference listRef = storageReference.child("images");

        listRef.listAll()
                .addOnSuccessListener(listResult -> {
                    for (StorageReference prefix : listResult.getPrefixes()) {
                        // All the prefixes under listRef.
                        // You may call listAll() recursively on them.
                    }

                          for (StorageReference item : listResult.getItems()) {
                              Log.d("d1", item.getPath());
                              listRef.getDownloadUrl().addOnSuccessListener(url -> models.add(new Model(url)))
                                      .addOnFailureListener(err -> Log.e(TAG, err.getMessage()));
                          }

                    listResult.getItems().forEach(sr -> sr.getDownloadUrl().addOnSuccessListener(successValue -> {
                        models.add(new Model(successValue));
                    }));
                })
                .addOnFailureListener(err -> Log.e(TAG, err.getMessage()));

        modelsList = binding.rvGallery;
        modelsList.hasFixedSize();
        modelsList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        modelAdapter = new ModelAdapter(models);
        modelsList.setAdapter(modelAdapter);

        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),SPAN_COUNT);
        modelsList.setLayoutManager(layoutManager);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}