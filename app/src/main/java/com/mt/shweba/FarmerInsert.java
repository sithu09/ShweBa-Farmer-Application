package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FarmerInsert extends AppCompatActivity {
EditText type,amount,codeno,name,location,phoneno,date,locations,ftown;
Button post;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_insert);

     type=(EditText)findViewById(R.id.type);
     amount=(EditText)findViewById(R.id.amount);
     codeno=(EditText)findViewById(R.id.codeno);
     date=(EditText)findViewById(R.id.date);
     name=(EditText)findViewById(R.id.name);
     location=(EditText)findViewById(R.id.location);
     phoneno=(EditText)findViewById(R.id.phoneno);
     ftown=(EditText)findViewById(R.id.ftown);
     post=(Button) findViewById(R.id.post);


     post.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             reff= FirebaseDatabase.getInstance().getReference("Farmer");
             FarmerI farmer=new FarmerI();

             String dates=date.getText().toString().trim();
             String names=name.getText().toString().trim();
             String locations=location.getText().toString().trim();
             String phonenos=phoneno.getText().toString().trim();
             String codenos=codeno.getText().toString().trim();
             String types=type.getText().toString().trim();
             String amounts=amount.getText().toString().trim();
             String ftowns=ftown.getText().toString().trim();

             if(dates.length()==0 || names.length()==0 || locations.length()==0 || phonenos.length()==0 || codenos.length()<6 || types.length()==0 || amounts.length()==0){
                 Toast.makeText(FarmerInsert.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
             }
             else {
                 farmer.setAmount(amounts);
                 farmer.setDate(dates);
                 farmer.setName(names);
                 farmer.setLocation(locations);
                 farmer.setPhoneno(phonenos);
                 farmer.setType(types);
                 farmer.setFtown(ftowns);
                 reff.child(ftowns).child(codenos).setValue(farmer);
                 Toast.makeText(FarmerInsert.this,"သင်၏ရောင်းကုန်ပစ္စည်းအား စျေးကွက်သို့ တင်ပါိ့ပြီးပါပြီ။ အခြားကုန်များ ထပ်မံတင်လိုပါက ကုတ်နံပါတ် ပြောင်းပေးပါ။ ",Toast.LENGTH_LONG).show();
             }

         }
     });
//  သင်၏ရောင်းကုန်ပစ္စည်းအား စျေးကွက်သို့ တင်ပါိ့ပြီးပါပြီ။ အခြားကုန်များ ထပ်မံတင်လိုပါက ကုတ်နံပါတ် ပြောင်းပေးပါ။
    }
}
