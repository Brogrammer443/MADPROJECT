package com.example.sampleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState1) {
        super.onCreate(savedInstanceState1);
        setContentView(R.layout.activity_main);

        // Initialize ViewFlipper
        viewFlipper = findViewById(R.id.viewFlipper2);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.setAutoStart(true);

        // Load the animation
        final Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);
        Button signBtn = findViewById(R.id.SignupBtn);

        signBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                EditText Email = findViewById(R.id.signupEmail);
                EditText Password = findViewById(R.id.signupPassword);

                String email = Email.getText().toString().trim();
                String pass = Password.getText().toString().trim();


                registerUser(email, pass);


            }
        });


        Button movetologin = findViewById(R.id.account);

        movetologin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, LogIn.class));

            }
        });


    }


    private void registerUser(String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = auth.getCurrentUser();
                            Log.d("Registration", user.getEmail() + " successfully Registered.");
                            Toast.makeText(MainActivity.this, "Registration successful.", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e("Registration", "failure", task.getException());
                            Toast.makeText(MainActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
