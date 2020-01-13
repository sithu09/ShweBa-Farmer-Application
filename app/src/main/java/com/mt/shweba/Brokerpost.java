package com.mt.shweba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Brokerpost extends AppCompatActivity {
    EditText goods,prices,dates,names,locations,phonenos,codenos,btowns;
    Button posts;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brokerpost);

        goods=(EditText)findViewById(R.id.goods);
        prices=(EditText)findViewById(R.id.price);
        dates=(EditText)findViewById(R.id.date);
        names=(EditText)findViewById(R.id.name);
        locations=(EditText)findViewById(R.id.location);
        phonenos=(EditText) findViewById(R.id.phoneno);
        codenos=(EditText) findViewById(R.id.codeno);
        btowns=(EditText)findViewById(R.id.btown);

        posts=(Button) findViewById(R.id.post);

        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff= FirebaseDatabase.getInstance().getReference("Broker");
                BrokerInsert binsert=new BrokerInsert();
                String good=goods.getText().toString().trim();
                String price=prices.getText().toString().trim();
                String date=dates.getText().toString().trim();
                String name=names.getText().toString().trim();
                String location=locations.getText().toString().trim();
                String phoneno=phonenos.getText().toString().trim();
                String codeno=codenos.getText().toString().trim();
                String btown=btowns.getText().toString().trim();

                if(good.length()==0 || price.length()==0 || date.length()==0 || name.length()==0 || location.length()==0 || phoneno.length()==0 || codeno.length()<6 || btown.length()==0){
                    Toast.makeText(Brokerpost.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                }
                else {
                    binsert.setGoods(good);
                    binsert.setPrice(price);
                    binsert.setName(name);
                    binsert.setLocation(location);
                    binsert.setPhoneno(phoneno);
                    binsert.setDate(date);
                    binsert.setBtown(btown);
                    reff.child(btown).child(codeno).setValue(binsert);
                    Toast.makeText(Brokerpost.this,"သင်၏ စျေးနှုန်းသတ်မှတ်ချက် အောင်မြင်ပါသည်။ကုတ််နံပါတ်ပြောင်း၍ အခြားသီးနှံစျေးနှုန်းများ သတ်မှတ်နိုင်သည်။ ",Toast.LENGTH_LONG).show();
                }
            }
        });

//သင်၏ စျေးနှုန်းသတ်မှတ်ချက် အောင်မြင်ပါသည်။ကုတ််နံပါတ်ပြောင်း၍ အခြားသီးနှံစျေးနှုန်းများ သတ်မှတ်နိုင်သည်။
//
//စျေးကွက်
    }
}
//ကုန်ပစ္စည်းတစ်ကြိမ်တင်လျှင် ကုတ်နံပါတ်တစ်ခါ ပြောင်းပါ။
//
//လေးလုံး