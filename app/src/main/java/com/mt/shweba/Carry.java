package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Carry extends AppCompatActivity {
EditText name,location,phoneno,type,ctown;
Button posts;
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carry);
        name=(EditText)findViewById(R.id.name);
        location=(EditText)findViewById(R.id.location);
        phoneno=(EditText)findViewById(R.id.phoneno);
        type=(EditText)findViewById(R.id.type);
        ctown=(EditText) findViewById(R.id.ctown);
        posts=(Button)findViewById(R.id.post);

        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reff= FirebaseDatabase.getInstance().getReference("Carry");
                CarryInsert cinsert=new CarryInsert();

                String names=name.getText().toString().trim();
                String locations=location.getText().toString().trim();
                String phonenos=phoneno.getText().toString().trim();
                String types=type.getText().toString().trim();
                String ctowns=ctown.getText().toString().trim();

                if(names.length()==0 || locations.length()==0 || phonenos.length()==0 || types.length()==0 || ctowns.length()==0){
                    Toast.makeText(Carry.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                }
                else {
                   cinsert.setName(names);
                   cinsert.setLocation(locations);
                   cinsert.setPhone(phonenos);
                   cinsert.setType(types);
                   cinsert.setCtown(ctowns);
                    reff.child(ctowns).child(phonenos).setValue(cinsert);
                    Toast.makeText(Carry.this,"ဖြည့်စွက်မှုအောင်မြင်ပါသည်",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
