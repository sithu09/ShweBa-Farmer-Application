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

public class MShoperRetrieve extends AppCompatActivity {
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mshoper_retrieve);
        final ListView listView=(ListView)findViewById(R.id.mshoperlistView);
        final ArrayList<String> arrayList=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(MShoperRetrieve.this,android.R.layout.simple_list_item_1,arrayList);

        reff = FirebaseDatabase.getInstance().getReference().child("Medical Shoper");
        final BrokerInsert insert=new BrokerInsert();
//
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String type=snapshot.child("type").getValue().toString();
                    String name= snapshot.child("name").getValue().toString();
                    String location= snapshot.child("location").getValue().toString();
                    String price=snapshot.child("price").getValue().toString();
                    String  all= "\n\t\t\tအမျိုးအစား : " +"\t" + type + "\n"+ "\t\t\tစျေးနှုန်း : " +"\t" + price + "\n" + "\t\t\tဆိုင်နာမည် : " + "\t" + name+ "\n" + "\t\t\tတည်နေရာ : " + "\t" + location+ "\n" ;
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
}
