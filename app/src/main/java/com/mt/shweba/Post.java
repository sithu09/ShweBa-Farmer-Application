package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Post extends AppCompatActivity {
Button cost,sell,carry,buy,medical,canel,information,weather,technical,feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        cost=(Button)findViewById(R.id.cost);
        sell=(Button)findViewById(R.id.sell);
        buy=(Button)findViewById(R.id.buy);
        medical=(Button)findViewById(R.id.medical);
        carry=(Button)findViewById(R.id.carry);
        canel=(Button)findViewById(R.id.canel);
        information=(Button)findViewById(R.id.information);
        weather=(Button)findViewById(R.id.weather);
        technical=(Button)findViewById(R.id.technical);
        feedback=(Button)findViewById(R.id.feedback);


        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,BrokerRetrieve.class);
                startActivity(intent);
            }
        });
        carry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,CarryRetrieve.class);
                startActivity(intent);
            }
        });
        canel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,CanelRetrieve.class);
                startActivity(intent);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,ShoperRetrieve.class);
                startActivity(intent);
            }
        });
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,MShoperRetrieve.class);
                startActivity(intent);
            }
        });
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,FarmerInsert.class);
                startActivity(intent);
            }
        });
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,WeatherRetrieve.class);
                startActivity(intent);
            }
        });
        technical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,TechnicalRetrieve.class);
                startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,Feedback.class);
                startActivity(intent);
            }
        });
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Post.this,FarmerNews.class);
                startActivity(intent);
            }
        });
    }
}
