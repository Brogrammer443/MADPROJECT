package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Concert extends AppCompatActivity
{
    String[] Singer = {
            "Atif Aslam",
            "Rahat Fateh Ali Khan",
            "Ali Zafar",
            "Aima Baig",
            "Neha Kakkar",
            "Atif Aslam",
            "Abida Parveen",
            "Shafqat Amanat Ali",
            "Ali Azmat",
            "Arijit Singh",
            "Momina Mustehsan",
            "Arif Lohar",
            "Farhan Saeed",
            "Shreya Ghoshal",
            "Bilal Saeed",
            "Nusrat Fateh Ali Khan",
            "Adnan Sami",
            "Sunidhi Chauhan",
            "Rahim Shah",
            "Naseebo Lal"
    };

    String name, email, ph,singer;

    AutoCompleteTextView singerList;
    ArrayAdapter<String> adpter_item;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert);


        singerList=findViewById(R.id.SingerList);
        adpter_item=new ArrayAdapter<String>(this,R.layout.activity_my_adapter,Singer);
        singerList.setAdapter(adpter_item);
        singerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                singer=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Concert.this, "Singer: "+ singer, Toast.LENGTH_SHORT).show();
            }
        });

        Button Back=findViewById(R.id.BackBtn);
        Back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Concert.this,HomeActivity.class));
            }
        });



        Button ReserveBtn = findViewById(R.id.ReserveBtn);
        ReserveBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText nameEt = findViewById(R.id.userName);
                EditText emailEt = findViewById(R.id.userEmail);
                EditText phEt = findViewById(R.id.userPhone);
                name = nameEt.getText().toString();
                email = emailEt.getText().toString();
                ph = phEt.getText().toString();

                concertData CD = new concertData(name, ph, email,singer);

                DatabaseReference database = FirebaseDatabase.getInstance("https://sampleproject-99f07-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Concert");
                String ConcertId = database.push().getKey(); // Generate a unique key
                database.child("Concert").child(ConcertId).setValue(CD).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Concert.this, "Your data is stored", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Concert.this, HomeActivity.class));
                        } else {
                            Log.e("firebase", "Error storing data", task.getException());
                            Toast.makeText(Concert.this, "Data not stored", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("firebase", "Failure storing data", e);
                        Toast.makeText(Concert.this, "Data not stored", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
};

