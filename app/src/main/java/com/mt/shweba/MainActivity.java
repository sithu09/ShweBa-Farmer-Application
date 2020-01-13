package com.mt.shweba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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


public class MainActivity extends AppCompatActivity {
Button l_btn,s_btn;
EditText uname,upassword;
DatabaseReference reff,up_reff;
String farmer,canel,carry,broker,shoper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l_btn = (Button) findViewById(R.id.login);
        s_btn = (Button) findViewById(R.id.signup);
        uname = (EditText) findViewById(R.id.editText);
        upassword = (EditText) findViewById(R.id.editText2);

        ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();

        if (nInfo != null && nInfo.isConnected()) {
            l_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    final String user_name = uname.getText().toString().trim();
                    final String user_password = upassword.getText().toString().trim();
                    reff = FirebaseDatabase.getInstance().getReference().child("User").child(user_name);
                    if(user_name.length() == 0 || user_password.length() == 0){
                        Toast.makeText(MainActivity.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                    }
                    else{
                    reff.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            farmer="တောင်သူ";
                            canel="သမဝါယမ/ဆည်မြောင်းဌာန";
                            carry="ကယ်ရီ";
                            broker="ပွဲရုံ";
                            shoper="စျေးဆိုင်";
                            String d_password= dataSnapshot.child("password").getValue().toString();
                            String d_name= dataSnapshot.child("name").getValue().toString();
                            String field=dataSnapshot.child("field").getValue().toString();

                           if (uname.getText().toString().equals(d_name) && upassword.getText().toString().equals(d_password)&& field.equals(farmer))
                            {

                                    Intent intent = new Intent(MainActivity.this, Post.class);
                                    startActivity(intent);
//                                Toast.makeText(MainActivity.this,field,Toast.LENGTH_LONG).show();



                            }
                            else if (uname.getText().toString().equals(d_name) && upassword.getText().toString().equals(d_password)&&field.equals(canel)){
                                Intent intent = new Intent(MainActivity.this, Canel.class);
                                startActivity(intent);
                            }
                            else if (uname.getText().toString().equals(d_name) && upassword.getText().toString().equals(d_password)&&field.equals(carry)){
                                Intent intent = new Intent(MainActivity.this, Carry.class);
                                startActivity(intent);
                            }
                            else if (uname.getText().toString().equals(d_name) && upassword.getText().toString().equals(d_password)&&field.equals(broker)){
                                Intent intent = new Intent(MainActivity.this, Broker.class);
                                startActivity(intent);
                            }
                            else {
                                Intent intent = new Intent(MainActivity.this, Shoper.class);
                                startActivity(intent);
                            }
//     I know this case must checked                       if(user_name.length() == 0 || user_password.length() == 0) {
//   But my app is testing app and  idea  checking app                        Toast.makeText(MainActivity.this, "Fill your name and password", Toast.LENGTH_LONG).show();
//                            }
//                            if(user_name != d_name || user_password!= d_password) {
//                                Toast.makeText(MainActivity.this, "User name of password wrong", Toast.LENGTH_LONG).show();
//                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });}
//
                }
            });

            s_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this, "အင်တာနက်ဖွင့်ထားပါ", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, Signup.class);
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "အင်တာနက်ဖွင့်ထားပါ", Toast.LENGTH_LONG).show();
        }
    }
}
