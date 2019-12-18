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

import java.util.ArrayList;

public class CarryRetrieve extends AppCompatActivity {
    EditText towns;
    Button market;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carry_retrieve);

        towns=(EditText)findViewById(R.id.town);
        market=(Button)findViewById(R.id.farmer_market);

        final ListView listView=(ListView)findViewById(R.id.carrylistView);
        final ArrayList<String> arrayList=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(CarryRetrieve.this,android.R.layout.simple_list_item_1,arrayList);

//        reff = FirebaseDatabase.getInstance().getReference().child("Carry");
        final BrokerInsert insert=new BrokerInsert();
//
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String townlocation= towns.getText().toString().trim();
                reff = FirebaseDatabase.getInstance().getReference().child("Carry").child(townlocation);
                reff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String name= snapshot.child("name").getValue().toString();
                            String type= snapshot.child("type").getValue().toString();
                            String location=snapshot.child("location").getValue().toString();
                            String phoneno=snapshot.child("phone").getValue().toString();
                            String  all= "\n\t\t\tနာမည် : " +"\t" + name + "\n"+ "\t\t\tနေရပ် : " +"\t" + location + "\n" + "\t\t\tဖုန်းနံပါတ် : " + "\t" + phoneno+ "\n" + "\t\t\tယာဥ်အမျိုးအစား: " + "\t" + type + "\n" ;
//နေရပ်
//ယာဥ်အမျိုးအစား
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
        });


    }
}
