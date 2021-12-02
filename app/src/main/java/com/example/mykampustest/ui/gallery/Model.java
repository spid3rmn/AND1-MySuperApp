package com.example.mykampustest.ui.gallery;

import android.net.Uri;

public class Model {
    private Uri image;

    Model(Uri image) {
        this.image = image;
    }

    public Uri getImage() {
        return image;
    }
}
