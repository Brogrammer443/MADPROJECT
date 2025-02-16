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

import androidx.annotation.NonNull;


public class Bus extends AppCompatActivity
{
    String[] City = {"Islamabad","Karachi","Lahore","Faisalabad","Rawalpindi","Multan",
            "Gujranwala","Peshawar","Quetta","Hyderabad","Abbottabad","Sialkot","Bahawalpur",
            "Sargodha","Sukkur","Larkana","Sheikhupura","Rahim Yar Khan","Jhang","Gujrat",
            "Mardan","Kasur","Rahwali","Sahiwal","Okara","Wah Cantonment","Dera Ghazi Khan",
            "Mingora","Mirpur Khas","Chiniot","Nawabshah","Kamoke","Burewala","Jhelum",
            "Sadiqabad","Kotli","Dera Ismail Khan","Pasrur","Hafizabad","Kohat","Malir Cantonment",
            "Liaquatpur","Muzaffargarh","Khanpur","Gojra","Mandi Bahauddin","Muridke",
            "Abbottabad","Padidan","Pakpattan","Khuzdar","Jaranwala","Chishtian","Daska",
            "Mandi Bahauddin","Ahmedpur East","Kamalia","Vehari","Wazirabad","Nowshera",
            "Khushab","Jalalpur","Chakwal","Mailsi","Charsadda","Mianwali","Tando Allahyar",
            "Kot Addu","Turbat","Shahdadkot","Bhalwal","Bhimber","Bhalwal","Kharian",
            "Haripur","Mehar","Vihari","Dadu","Kambar","Pano Aqil","Kandhkot","Hasilpur",
            "Toba Tek Singh","Swabi","Shikarpur","Lodhran",
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
    String[] Buses= {
            "Daewoo Express",
            "Faisal Movers",
            "Niazi Express",
            "Bilal Travels",
            "Skyways",
            "Kohistan Bus Service",
            "Q-Connect",
            "Sialkot-Lahore Bus Service (SLBS)",
            "Fazal e Haq Dera Express",
            "NATCO"
    };

    String name, email, ph, arrive, dep, selBus;

    AutoCompleteTextView DCityList,ACityList,BusesList;
    ArrayAdapter<String> adpter_item;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);


        DCityList=findViewById(R.id.DCityMenu);
        adpter_item=new ArrayAdapter<String>(this,R.layout.activity_my_adapter,City);
        DCityList.setAdapter(adpter_item);
        DCityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dep=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Bus.this, "City: "+ dep, Toast.LENGTH_SHORT).show();
            }
        });


        ACityList=findViewById(R.id.ACityMenu);
        adpter_item=new ArrayAdapter<String>(this,R.layout.activity_my_adapter,City);
        ACityList.setAdapter(adpter_item);
        ACityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrive=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Bus.this, "City: "+ arrive, Toast.LENGTH_SHORT).show();
            }
        });



        BusesList=findViewById(R.id.BusMenu);
        adpter_item=new ArrayAdapter<String>(this,R.layout.activity_my_adapter,Buses);
        BusesList.setAdapter(adpter_item);
        BusesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selBus=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Bus.this, "Bus: "+ selBus, Toast.LENGTH_SHORT).show();
            }
        });





        Button Back=findViewById(R.id.BackBtn);
        Back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Bus.this,HomeActivity.class));
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

                BusData BD = new BusData(name, ph, email, dep, arrive, selBus);

                DatabaseReference database = FirebaseDatabase.getInstance("https://sampleproject-99f07-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Bus");
                String BusId = database.push().getKey(); // Generate a unique key
                database.child("Bus").child(BusId).setValue(BD).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Bus.this, "Your data is stored", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Bus.this, HomeActivity.class));
                        } else {
                            Log.e("firebase", "Error storing data", task.getException());
                            Toast.makeText(Bus.this, "Data not stored", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("firebase", "Failure storing data", e);
                        Toast.makeText(Bus.this, "Data not stored", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
};

