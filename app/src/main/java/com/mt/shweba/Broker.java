package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Broker extends AppCompatActivity {
    Button post,check,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broker);
        post=(Button)findViewById(R.id.post);
        check=(Button)findViewById(R.id.check);
        view=(Button)findViewById(R.id.view);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Broker.this,Brokerpost.class);
                startActivity(intent);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Broker.this,BrokerRetrieve.class);
                startActivity(intent);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Broker.this,FarmerRetrieve.class);
                startActivity(intent);
            }
        });
    }
}
