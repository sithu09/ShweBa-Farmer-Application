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
EditText goods,prices,dates,names;
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

               if(good.length()==0 || price.length()==0 || date.length()==0 || name.length()==0){
                   Toast.makeText(Brokerpost.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
               }
               else {
                   binsert.setGoods(good);
                   binsert.setPrice(price);
                   binsert.setName(name);
                   binsert.setDate(date);
                   reff.child(name).setValue(binsert);
                   Toast.makeText(Brokerpost.this,"ဖြည့်စွက်မှုအောင်မြင်ပါသည်",Toast.LENGTH_LONG).show();
               }
           }
       });


            }
        }
