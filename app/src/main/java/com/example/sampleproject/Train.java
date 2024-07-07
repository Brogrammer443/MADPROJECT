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

public class Train extends AppCompatActivity {
    String[] City = {
            "Islamabad","Karachi","Lahore","Faisalabad","Rawalpindi","Multan","Gujranwala","Peshawar",
            "Quetta","Hyderabad","Abbottabad","Sialkot","Bahawalpur","Sargodha",
            "Sukkur",
            "Larkana",
            "Sheikhupura",
            "Rahim Yar Khan",
            "Jhang",
            "Gujrat",
            "Mardan",
            "Kasur",
            "Rahwali",
            "Sahiwal",
            "Okara",
            "Wah Cantonment",
            "Dera Ghazi Khan",
            "Mingora",
            "Mirpur Khas",
            "Chiniot",
            "Nawabshah",
            "Kamoke",
            "Burewala",
            "Jhelum",
            "Sadiqabad",
            "Kotli",
            "Dera Ismail Khan",
            "Pasrur",
            "Hafizabad",
            "Kohat",
            "Malir Cantonment",
            "Liaquatpur",
            "Muzaffargarh",
            "Khanpur",
            "Gojra",
            "Mandi Bahauddin",
            "Muridke",
            "Abbottabad",
            "Padidan",
            "Pakpattan",
            "Khuzdar",
            "Jaranwala",
            "Chishtian",
            "Daska",
            "Mandi Bahauddin",
            "Ahmedpur East",
            "Kamalia",
            "Vehari",
            "Wazirabad",
            "Nowshera",
            "Khushab",
            "Jalalpur",
            "Chakwal",
            "Mailsi",
            "Charsadda",
            "Mianwali",
            "Tando Allahyar",
            "Kot Addu",
            "Turbat",
            "Shahdadkot",
            "Bhalwal",
            "Bhimber",
            "Bhalwal",
            "Kharian",
            "Haripur",
            "Mehar",
            "Vihari",
            "Dadu",
            "Kambar",
            "Pano Aqil",
            "Kandhkot",
            "Hasilpur",
            "Toba Tek Singh",
            "Swabi",
            "Shikarpur",
            "Lodhran",
            "Nowshera Cantonment",
            "Chak Azam Sahu",
            "Mankera",
            "Haveli Lakha",
            "Lalamusa",
            "Bahawalnagar",
            "Kahror Pakka",
            "Tandlianwala",
            "Zahir Pir",
            "Kulachi",
            "Khurrianwala",
            "Kalar Kahar",
            "Gambat",
            "Mian Channu",
            "Dunyapur",
            "Pir Mahal",
            "Saddar Gogera",
            "Chichawatni",
            "Sambrial",
            "Kabirwala",
            "Renala Khurd",
            "Kunjah",
            "Qadirpur Ran",
            "Dipalpur",
            "Pasni",
            "Chunian",
            "Qila Didar Singh",
            "Fazilpur",
            "Sharqpur",
            "Hala",
            "Talagang",
            "Kot Radha Kishan",
            "Kamar Mushani",
            "Khanewal",
            "Shujaabad",
            "Kot Sultan",
            "Taunsa",
            "Sarai Alamgir",
            "Shahkot",
            "Noorpur Thal",
            "Dinga",
            "Kunjah",
            "Kotli Loharan",
            "Pir Jo Goth",
            "Shahpur",
            "Phalia",
            "Kallar Syedan",
            "Liaqatabad",
            "Shahdadpur",
            "Jamshoro",
            "Kahna",
            "Bhiria City",
            "Sarai Naurang",
            "Usta Muhammad",
            "Kot Samaba"};
    String[] Trains = {
            "Pakistan Railways",
            "Daewoo Pakistan Express",
            "Green Line Express",
            "Karachi Express",
            "Khyber Mail",
            "Awam Express",
            "Tezgam",
            "Mehr Express",
            "Subak Kharam",
            "Bolan Mail",
            "Akbar Express",
            "Allama Iqbal Express",
            "Sukkur Express",
            "Jaffar Express",
            "Khushhal Khan Khattak Express",
            "Badr Express",
            "Millat Express",
            "Karakoram Express",
            "Hazara Express",
            "Sindh Express",
            "Faisalabad Express",
            "Shalimar Express",
            "Pak Business Express",
            "Sialkot Express",
            "Ravi Express",
            "Sakura Express",
            "Shalimar Express",
            "Subak Raftar",
            "Thal Express",
            "Bahauddin Zakariya Express",
            "Babu Express"
    };
    String name, email, ph, arrive, dep, selTrain;
    AutoCompleteTextView DCityList, ACityList, TrainsList;
    ArrayAdapter<String> adapter_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        DCityList = findViewById(R.id.DCityMenu);
        adapter_item = new ArrayAdapter<String>(this, R.layout.activity_my_adapter, City);
        DCityList.setAdapter(adapter_item);
        DCityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dep = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Train.this, "City: " + dep, Toast.LENGTH_SHORT).show();
            }
        });

        ACityList = findViewById(R.id.ACityMenu);
        adapter_item = new ArrayAdapter<String>(this, R.layout.activity_my_adapter, City);
        ACityList.setAdapter(adapter_item);
        ACityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrive = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Train.this, "City: " + arrive, Toast.LENGTH_SHORT).show();
            }
        });

        TrainsList = findViewById(R.id.TrainMenu);
        adapter_item = new ArrayAdapter<String>(this, R.layout.activity_my_adapter, Trains);
        TrainsList.setAdapter(adapter_item);
        TrainsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selTrain = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Train.this, "Train: " + selTrain, Toast.LENGTH_SHORT).show();
            }
        });

        Button Back = findViewById(R.id.TBackBtn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Train.this, HomeActivity.class));
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

                TrainData TD = new TrainData(name, ph, email, dep, arrive, selTrain);

                DatabaseReference database = FirebaseDatabase.getInstance("https://sampleproject-99f07-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Train");
                String trainId = database.push().getKey(); // Generate a unique key
                database.child("Train").child(trainId).setValue(TD).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Train.this, "ReserveBtn pressed inside onComplete", Toast.LENGTH_SHORT).show();

                        if (task.isSuccessful()) {
                            Toast.makeText(Train.this, "Your data is stored", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Train.this, HomeActivity.class));
                        } else {
                            Log.e("firebase", "Error storing data", task.getException());
                            Toast.makeText(Train.this, "Data not stored", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("firebase", "Failure storing data", e);
                        Toast.makeText(Train.this, "Data not stored", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
