package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class BookedTicketsActivity extends AppCompatActivity {

    private ListView ticketsListView;
    private ArrayAdapter<String> adapter;
    private List<String> bookedTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_tickets);

        ticketsListView = findViewById(R.id.ticketsListView);
        bookedTickets = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookedTickets);
        ticketsListView.setAdapter(adapter);

        // Fetch booked tickets from Firebase Realtime Database
        fetchBookedTickets();
    }

    private void fetchBookedTickets() {
        // Assuming you have a Firebase Realtime Database reference for booked tickets
        Query query = FirebaseDatabase.getInstance("YOUR_DATABASE_URL")
                .getReference("BookedTickets")
                .orderByChild("userEmail") // Assuming user's email is used as a key
                .equalTo("user@example.com"); // Replace with the actual user's email

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bookedTickets.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MovieData ticket = snapshot.getValue(MovieData.class);
                    if (ticket != null) {
                        String ticketInfo = "Movie: " + ticket.getMovie() +
                                "\nSeat: " + ticket.getSeatNo();
                        bookedTickets.add(ticketInfo);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }
}
