package com.example.mykampustest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mykampustest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    //private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Retrieving and initializing ViewModel
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        initialMessage();

        //produces nullpointerexception
        //viewModel.init();

        //Floating Button to send Mails
        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(this::emailToStaff);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_guides, R.id.nav_common_rooms, R.id.nav_flats, R.id.nav_faq)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    //Implicit Intend SEND
    public void emailToStaff(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"contact@kamtjatka.dk"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Info");
        intent.putExtra(Intent.EXTRA_TEXT, "-- Sent by MyKampus App");
        startActivity(intent);
    }

    //Implicit Intent VIEW
    public void goToWebsite() {
        String action = Intent.ACTION_VIEW;
        Uri uri = Uri.parse("https://kamtjatka.dk/");
        Intent intent = new Intent(action, uri);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main, menu);

        //Select which buttons will be visible for login
        setButtonsMenu(menu);

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_signin:
                startLoginActivity();
                return true;
            case R.id.action_signout:
                signOut();
                return true;
            case R.id.action_web:
                goToWebsite();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Select right buttons for the menu
    private void setButtonsMenu(Menu menu) {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                menu.findItem(R.id.action_signout).setVisible(true);
                menu.findItem(R.id.action_signin).setVisible(false);
            } else {
                menu.findItem(R.id.action_signout).setVisible(false);
                menu.findItem(R.id.action_signin).setVisible(true);
            }
        });
    }

    //Message to user regarding login status
    private void initialMessage() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                String message_log = "Welcome " + user.getDisplayName();
                Toast.makeText(this, message_log, Toast.LENGTH_LONG).show();
            } else {
                String message_not = "Hey, who are you?";
                Toast.makeText(this, message_not, Toast.LENGTH_LONG).show();
            }
        });
    }

    //Login methods
    private void startLoginActivity() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    public void signOut() {
        viewModel.signOut();
    }

    //Navigation
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}