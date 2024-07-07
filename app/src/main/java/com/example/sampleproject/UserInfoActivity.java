package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        // Retrieve user information
        String userName = "John Doe"; // Replace with actual user name
        String userEmail = "john.doe@example.com"; // Replace with actual user email

        // Display user information
        TextView nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText("Name: " + userName);

        TextView emailTextView = findViewById(R.id.emailTextView);
        emailTextView.setText("Email: " + userEmail);

        // Sign out button
        Button signOutButton = findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform sign-out operation (e.g., navigate to login screen)
                // For now, just finish the activity
                finish();
            }
        });
    }
}
