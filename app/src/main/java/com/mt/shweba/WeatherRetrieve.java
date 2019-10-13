package com.mt.shweba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WeatherRetrieve extends AppCompatActivity {
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_retrieve);
        final ListView listView=(ListView)findViewById(R.id.weatherlistView);
        final ArrayList<String> arrayList=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(WeatherRetrieve.this,android.R.layout.simple_list_item_1,arrayList);

        reff = FirebaseDatabase.getInstance().getReference().child("Weather");
//        final BrokerInsert insert=new BrokerInsert();
//
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String title=snapshot.child("title").getValue().toString();
                    String detail= snapshot.child("detail").getValue().toString();

                    String  all= "\nထုတ်ပြန်ချိန် : " +"\t" + title + "\n\n"+ "ခန့်မှန်းချက် : " +"\t" + detail + "\n" ;
//နေရပ်
//ယာဥ်အမျိုးအစား ထုတ်ပြန်ချိန်
//ခန့်မှန်းချက်
//ပို့ဆောင်ရေး
                    arrayList.add(all);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
