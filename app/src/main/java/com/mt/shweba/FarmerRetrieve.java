package com.mt.shweba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FarmerRetrieve extends AppCompatActivity {
    EditText towns;
    Button market;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_retrieve);

        towns=(EditText)findViewById(R.id.town);
        market=(Button)findViewById(R.id.farmer_market);

        final ListView listView=(ListView)findViewById(R.id.farmerlistView);
        final ArrayList<String> arrayList=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(FarmerRetrieve.this,android.R.layout.simple_list_item_1,arrayList);

        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String townlocation= towns.getText().toString().trim();
                reff = FirebaseDatabase.getInstance().getReference().child("Farmer").child(townlocation);
//
                reff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String name= snapshot.child("name").getValue().toString();
                            String amount= snapshot.child("amount").getValue().toString();
                            String type=snapshot.child("type").getValue().toString();
                            String date=snapshot.child("date").getValue().toString();
                            String location=snapshot.child("location").getValue().toString();
                            String phoneno=snapshot.child("phoneno").getValue().toString();
                            String  all= "\n\t\t\tအမျိုးအစား : " +"\t" + type + "\n"+ "\t\t\tပမာဏ : " +"\t" + amount + "\n" + "\t\t\tရက်စွဲ : " + "\t" + date + "\n" + "\t\t\tနာမည် : " + "\t" + name + "\n" + "\t\t\tနေရပ် : "+"\t" + location +"\n" + "\t\t\tဖုန်းနံပါတ် : "+"\t" + phoneno +"\n";
//ကုန်ပစ္စည်း
//စျေးနှုန်း
//ရက်စွဲ
//ဆိုင်နာမည်
//တည်နေရာ
//ဖုန်းနံပါတ်
//                    List<String> namesList = Arrays.asList( name, price, goods,date);
//                    arrayList.add("Name: " + name);
//                    arrayList.add("Goods: " + goods);
//                    arrayList.add("Price: " + price);
                            arrayList.add(all);
//                    arrayList.addAll(namesList);
                            listView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
//မင်းကလေးနဲ့ စကားပြောဖြစ်တဲ့ အချိန်အခါတွေတိုင်း :3