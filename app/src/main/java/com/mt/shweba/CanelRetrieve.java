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

public class CanelRetrieve extends AppCompatActivity {
    EditText towns;
    Button market;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canel_retrieve);

        towns=(EditText)findViewById(R.id.town);
        market=(Button)findViewById(R.id.farmer_market);

        final ListView listView=(ListView)findViewById(R.id.canellistView);
        final ArrayList<String> arrayList=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(CanelRetrieve.this,android.R.layout.simple_list_item_1,arrayList);

//        reff = FirebaseDatabase.getInstance().getReference().child("Department");
//
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String townlocation= towns.getText().toString().trim();
                reff = FirebaseDatabase.getInstance().getReference().child("Department").child(townlocation);
                reff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String topic= snapshot.child("topic").getValue().toString();
                            String department= snapshot.child("department").getValue().toString();
                            String date=snapshot.child("date").getValue().toString();
                            String summary=snapshot.child("summary").getValue().toString();
                            String  all= "\nခေါင်းစဥ် : " +"\t" + topic + "\n"+ "ဌာန : " +"\t" + department + "\n" + "ရက်စွဲ: " + "\t" + date + "\n" + "အကြောင်းအရာ အကျဥ်းချုပ်: " + "\t" + summary + "\n" ;
//ဌာန
//ခေါင်းစဥ်
//ဌာန
//ရက်စွဲ
//အကြောင်းအရာ အကျဥ်းချုပ်
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
