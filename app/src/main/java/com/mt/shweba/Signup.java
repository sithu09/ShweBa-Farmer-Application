package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
RadioButton fbutton,cbutton,dbutton,ibutton,sbutton,fields;
Button login,signup;
EditText name,password;
DatabaseReference reff;
RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            name = (EditText) findViewById(R.id.name);
            password = (EditText) findViewById(R.id.password);



            login = (Button) findViewById(R.id.login);
            signup = (Button) findViewById(R.id.signup);



        radioGroup=(RadioGroup)findViewById(R.id.radio) ;


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Signup.this, MainActivity.class);
                    startActivity(intent);
                }
            });


            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String user_name = name.getText().toString().trim();
                    String user_password = password.getText().toString().trim();
//                    အရူး မလိုဘူး String user_location=location.getText().toString().trim();
                    int selectfield=radioGroup.getCheckedRadioButtonId();
                    fields=findViewById(selectfield);
                    String field=fields.getText().toString();
                    if(user_name.length()==0  || field.length()==0 || user_password.length()==0){
                        Toast.makeText(Signup.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                    }
                    else {
                        reff = FirebaseDatabase.getInstance().getReference("User");
                 Member member=new Member();
                    member.setName(user_name);
                    member.setPassword(user_password);
                    member.setField(field);
                    reff.child(user_name).setValue(member);
                        Toast.makeText(Signup.this,"အကောင့်ဖွင့်ပြီးပါပြီ",Toast.LENGTH_LONG).show();
                    }
//
                }
            });

    }
}

//ဝေးကွာခြင်းမှာ နေသားကျဖို့ ထပ်ပြီးဝေးပေးလိုက်ရခြင်းဟာ ရင်နာစရာပါပဲ သက်ထားရေ