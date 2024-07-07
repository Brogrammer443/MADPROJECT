package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize ViewFlipper
        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.setAutoStart(true);

        // Load the animation
        final Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);

        Button TrainBtn = findViewById(R.id.TrainBtn);
        TrainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                startActivity(new Intent(HomeActivity.this, Train.class));
            }
        });

        Button BusBtn = findViewById(R.id.BusBtn);
        BusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                startActivity(new Intent(HomeActivity.this, Bus.class));
            }
        });

        Button AirlineBtn = findViewById(R.id.AirlineBtn);
        AirlineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                startActivity(new Intent(HomeActivity.this, Airline.class));
            }
        });

        Button MovieBtn = findViewById(R.id.MovieBtn);
        MovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                startActivity(new Intent(HomeActivity.this, Movie.class));
            }
        });

        Button ConcertBtn = findViewById(R.id.ConcertBtn);
        ConcertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                startActivity(new Intent(HomeActivity.this, Concert.class));
            }
        });

        ImageButton LogoutBtn = findViewById(R.id.LogoutBtn);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                startActivity(new Intent(HomeActivity.this, LogIn.class));
            }
        });

        // Navigation Bar
        LinearLayout homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Home button click (e.g., display Home content)
            }
        });

        LinearLayout bookingsButton = findViewById(R.id.bookingsButton);
        bookingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                startActivity(new Intent(HomeActivity.this, BookedTicketsActivity.class));
            }
        });

        LinearLayout notificationsButton = findViewById(R.id.notificationsButton);
        notificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Notifications button click (e.g., start Notifications activity)
            }
        });


        LinearLayout accountButton = findViewById(R.id.accountButton);
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation); // Start animation
                Toast.makeText(HomeActivity.this, "Welcome Back 1.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, UserInfoActivity.class));
            }
        });

    }
}
