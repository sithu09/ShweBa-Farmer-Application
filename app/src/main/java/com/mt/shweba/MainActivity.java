package com.mt.shweba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
Button btn;
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      btn=(Button)findViewById(R.id.button5);
        reff= FirebaseDatabase.getInstance().getReference().child("Member").child("1");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
reff.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String name=dataSnapshot.child("name").getValue().toString();
        Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
            }
        });
    }
}
