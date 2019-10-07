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
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      l_btn=(Button)findViewById(R.id.login);
      s_btn=(Button)findViewById(R.id.signup);
      uname=(EditText) findViewById(R.id.editText);
      upassword=(EditText)findViewById(R.id.editText2);
        reff= FirebaseDatabase.getInstance().getReference().child("Member");


        ConnectivityManager cManager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo=cManager.getActiveNetworkInfo();

        if(nInfo!=null && nInfo.isConnected()){
            l_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String user_name = uname.getText().toString().trim();
                            String user_password = upassword.getText().toString().trim();
                            String name = dataSnapshot.child("name").getValue().toString();
                            String age = dataSnapshot.child("age").getValue().toString();

                            if (uname.getText().toString().equals(name) && upassword.getText().toString().equals(age)) {
                                Intent intent = new Intent(MainActivity.this, Post.class);
                                startActivity(intent);
                            } else if (uname.length() == 0 || upassword.length() == 0) {
                                Toast.makeText(MainActivity.this, "Fill your name and password", Toast.LENGTH_LONG).show();
                            } else if(name != user_name || age != user_password) {
                                Toast.makeText(MainActivity.this, "User name of password wrong", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            });
s_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String i_name= uname.getText().toString().trim();
        String i_password = upassword.getText().toString().trim();
Member member=new Member();
        member.setName(i_name);
member.setPassword(i_password);
                reff.child(i_name).setValue(member);

        Toast.makeText(MainActivity.this,"PP",Toast.LENGTH_LONG).show();
    }
});
        }
        else{
            Toast.makeText(MainActivity.this,"Open Internet",Toast.LENGTH_LONG).show();
        }
    }
}
