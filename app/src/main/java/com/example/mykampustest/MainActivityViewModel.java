package com.example.mykampustest;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mykampustest.data.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    //private final MessageRepository messageRepository;

    public MainActivityViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);
        //messageRepository = MessageRepository.getInstance();
    }

    //only for message no need
    /*public void init() {
        String userId = userRepository.getCurrentUser().getValue().getUid();
        messageRepository.init(userId);
    }*/

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }

    /*public void saveMessage(String message) {
        messageRepository.saveMessage(message);
    }*/

    /*public LiveData<Message> getMessage() {
        return messageRepository.getMessage();
    }*/

    public void signOut() {
        userRepository.signOut();
    }
}
