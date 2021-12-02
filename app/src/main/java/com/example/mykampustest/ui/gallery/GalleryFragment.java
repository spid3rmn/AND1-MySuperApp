package com.example.mykampustest.ui.gallery;

import android.net.Uri;
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

//import com.bumptech.glide.Glide;
import com.example.mykampustest.R;
import com.example.mykampustest.databinding.FragmentGalleryBinding;
import com.example.mykampustest.ui.home.Guide;
import com.example.mykampustest.ui.home.ItemAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.lang.ref.Reference;
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

        //Firebase Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference listRef = storageReference.child("images");

        //This should work but it doesn't
        /*listRef.listAll()
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
                .addOnFailureListener(err -> Log.e(TAG, err.getMessage()));*/

        //Test
        //StorageReference listRef = storageReference.child("ananas.png");
        /*listRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                models.add(new Model(uri));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });*/

        //this works but hardcoded
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141418.jpg?alt=media&token=056d8838-dc0f-4d1f-9648-c4b7437274fa")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141428.jpg?alt=media&token=6305c8fb-06b6-40b1-b8bb-04fdd0c7b556")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141436.jpg?alt=media&token=da6b699e-0cae-4b34-bc55-554b76406c8d")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141447.jpg?alt=media&token=fb3a9d18-4bac-423a-9f00-6e767c39f40b")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141511.jpg?alt=media&token=922a1f0d-06b6-46ec-9696-ee84941b29a9")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141513.jpg?alt=media&token=088bb0fa-e4d6-419b-81ad-f29a027bd4bb")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141540.jpg?alt=media&token=e536dcba-a877-47a5-b2bc-1ba80893a9e8")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141641.jpg?alt=media&token=fd9b0fdc-b47a-4b1a-b73b-87e6cfa00ef6")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141748.jpg?alt=media&token=91f28c91-c9e9-4b20-ae70-0ffc35b44a11")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F20211129_141819.jpg?alt=media&token=f379d710-e634-4bd3-9f99-03728ee3b45e")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F1948025_345423718991105_1585323833504294498_n.jpg?alt=media&token=6830837b-32b2-4a04-bdf9-1a81576b20a0")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F13517_345423722324438_4555619786831052294_n.jpg?alt=media&token=d5031f28-daf2-4331-8201-b6767b959b26")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F11081436_345424022324408_5979515502950890736_n.jpg?alt=media&token=1d92658c-392e-4ff7-875e-8c7e658652f8")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F11058414_345424042324406_250201756802854378_n.jpg?alt=media&token=5310fb5b-7e25-4bfa-be80-329f8a99ed59")));
        models.add(new Model(Uri.parse("https://firebasestorage.googleapis.com/v0/b/and1-app.appspot.com/o/images%2F10408536_345424118991065_1098307381691501929_n.jpg?alt=media&token=121cfc70-b880-47d2-8659-6815234c7d85")));

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