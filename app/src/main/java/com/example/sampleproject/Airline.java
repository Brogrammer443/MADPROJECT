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

public class Airline extends AppCompatActivity
{
    String[] Country = {"Pakistan", "India", "United States", "China", "United Kingdom", "Canada", "Australia", "Germany", "France", "Japan"};

    String[] Airline = {
            "Airline 1",
            "Airline 2",
            "Airline 3",
            "Airline 4",
            "Airline 5",
            "Airline 6",
            "Airline 7",
            "Airline 8",
            "Airline 9",
            "Airline 10"
    };

    String name, email, ph, arrive, dep, selAirline;

    AutoCompleteTextView DCountryList,ACountryList,AirlineList;
    ArrayAdapter<String> adpter_item;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airline);


        DCountryList=findViewById(R.id.DCountryMenu);
        adpter_item=new ArrayAdapter<String>(this,R.layout.activity_my_adapter,Country);
        DCountryList.setAdapter(adpter_item);
        DCountryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dep=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Airline.this, "Country: "+ dep, Toast.LENGTH_SHORT).show();
            }
        });


        ACountryList=findViewById(R.id.ACountryMenu);
        adpter_item=new ArrayAdapter<String>(this,R.layout.activity_my_adapter,Country);
        ACountryList.setAdapter(adpter_item);
        ACountryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrive=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Airline.this, "Country: "+ arrive, Toast.LENGTH_SHORT).show();
            }
        });



        AirlineList=findViewById(R.id.AirlineMenu);
        adpter_item=new ArrayAdapter<String>(this,R.layout.activity_my_adapter,Airline);
        AirlineList.setAdapter(adpter_item);
        AirlineList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selAirline=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Airline.this, "Airline: "+ selAirline, Toast.LENGTH_SHORT).show();
            }
        });





        Button Back=findViewById(R.id.BackBtn);
        Back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Airline.this,HomeActivity.class));
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

                AirlineData AD = new AirlineData(name, ph, email, dep, arrive, selAirline);

                DatabaseReference database = FirebaseDatabase.getInstance("https://sampleproject-99f07-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Airline");
                String AirlineId = database.push().getKey(); // Generate a unique key
                database.child("Airline").child(AirlineId).setValue(AD).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Airline.this, "Your data is stored", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Airline.this, HomeActivity.class));
                        } else {
                            Log.e("firebase", "Error storing data", task.getException());
                            Toast.makeText(Airline.this, "Data not stored", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("firebase", "Failure storing data", e);
                        Toast.makeText(Airline.this, "Data not stored", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
};

