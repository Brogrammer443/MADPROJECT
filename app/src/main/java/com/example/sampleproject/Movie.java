package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

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

import androidx.annotation.NonNull;


public class Movie extends AppCompatActivity {
    String[] SeatNo = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
    };
    String[] Movies = {
            "The Shawshank Redemption",
            "The Godfather",
            "The Dark Knight",
            "Pulp Fiction",
            "Fight Club",
            "Forrest Gump",
            "The Matrix",
            "Goodfellas",
            "The Lord of the Rings: The Fellowship of the Ring",
            "Inception",
            "Star Wars: Episode V - The Empire Strikes Back",
            "The Avengers",
            "Interstellar",
            "The Lion King",
            "Gladiator",
            "The Silence of the Lambs",
            "The Departed",
            "Saving Private Ryan",
            "Back to the Future",
            "Titanic",
            "Jurassic Park",
            "Inglourious Basterds",
            "The Pianist",
            "The Social Network",
            "Avatar",
            "Gone with the Wind",
            "The Revenant",
            "Schindler's List",
            "Casablanca",
            "The Great Gatsby"
    };

    String name, email, ph, movie, seat;
    AutoCompleteTextView movieList, seatList;
    ArrayAdapter<String> adpter_item;

    private ViewPager2 imageSlider;
    private int[] images = {
            R.drawable.godfather,
            R.drawable.fightclub,
            R.drawable.goodfellas,
            R.drawable.theavengers
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        movieList = findViewById(R.id.MovieMenu);
        adpter_item = new ArrayAdapter<>(this, R.layout.activity_my_adapter, Movies);
        movieList.setAdapter(adpter_item);
        movieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                movie = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Movie.this, "Movie: " + movie, Toast.LENGTH_SHORT).show();
            }
        });

        seatList = findViewById(R.id.Seat);
        adpter_item = new ArrayAdapter<>(this, R.layout.activity_my_adapter, SeatNo);
        seatList.setAdapter(adpter_item);
        seatList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                seat = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Movie.this, "Seat: " + seat, Toast.LENGTH_SHORT).show();
            }
        });

        Button Back = findViewById(R.id.BackBtn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Movie.this, HomeActivity.class));
            }
        });

        Button ReserveBtn = findViewById(R.id.ReserveBtn);
        ReserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameEt = findViewById(R.id.userName);
                EditText emailEt = findViewById(R.id.userEmail);
                EditText phEt = findViewById(R.id.userPhone);
                name = nameEt.getText().toString();
                email = emailEt.getText().toString();
                ph = phEt.getText().toString();

                MovieData MD = new MovieData(name, ph, email, movie, seat);

                DatabaseReference database = FirebaseDatabase.getInstance("https://sampleproject-99f07-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Movie");
                String MovieId = database.push().getKey(); // Generate a unique key
                database.child("Movie").child(MovieId).setValue(MD).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Movie.this, "Your data is stored", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Movie.this, HomeActivity.class));
                        } else {
                            Log.e("firebase", "Error storing data", task.getException());
                            Toast.makeText(Movie.this, "Data not stored", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("firebase", "Failure storing data", e);
                        Toast.makeText(Movie.this, "Data not stored", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        imageSlider = findViewById(R.id.imageSlider);
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, images);
        imageSlider.setAdapter(adapter);
    }
}
