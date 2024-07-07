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

import com.example.sampleproject.R;
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

public class LogIn extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState1) {
        super.onCreate(savedInstanceState1);
        setContentView(R.layout.activity_log_in);


        viewFlipper = findViewById(R.id.viewFlipper1);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.setAutoStart(true);


        final Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);




            Button signBtn = findViewById(R.id.InBtn);
            signBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText Email = findViewById(R.id.loginemail);
                    EditText Password = findViewById(R.id.loginPass);

                    String email = Email.getText().toString().trim();
                    String pass = Password.getText().toString().trim();

                    authenticateUser(email, pass);

                }
            });


            Button movetosignup = findViewById(R.id.make);
            movetosignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LogIn.this, MainActivity.class));
                }
            });


        }


        private void authenticateUser (String email, String password){
            FirebaseAuth auth;
            auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = auth.getCurrentUser();
                                Log.d("Login", user.getEmail() + " successfully login.");
                                Toast.makeText(LogIn.this, "Welcome Back.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LogIn.this, HomeActivity.class));


                            } else {
                                // If sign in fails, display a message to the user.
                                Log.e("Login", "failure", task.getException());
                                Toast.makeText(LogIn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }

    }
