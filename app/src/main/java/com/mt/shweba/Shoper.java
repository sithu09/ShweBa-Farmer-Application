package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Shoper extends AppCompatActivity {
    EditText type,price,name,location,codenos,stown;
    Button post,spost;
    DatabaseReference reff,reffs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoper);

        type=(EditText)findViewById(R.id.type);
        price=(EditText)findViewById(R.id.price);
        name=(EditText)findViewById(R.id.name);
        location=(EditText)findViewById(R.id.location);
        codenos=(EditText)findViewById(R.id.codeno);
        stown=(EditText) findViewById(R.id.stown);
        post=(Button)findViewById(R.id.post);
        spost=(Button)findViewById(R.id.spost);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String types=type.getText().toString().trim();
                String prices=price.getText().toString().trim();
                String names=name.getText().toString().trim();
                String locations=location.getText().toString().trim();
                String codeno=codenos.getText().toString().trim();
                String towns=stown.getText().toString().trim();
//                int selectfield=radioGroup.getCheckedRadioButtonId();
//                fields=findViewById(selectfield);
//                String field=fields.getText().toString();

                if(types.length()==0 || prices.length()==0 || name.length()==0 || locations.length()==0 || codeno.length()<6){
                    Toast.makeText(Shoper.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                }
                else{
                    reff = FirebaseDatabase.getInstance().getReference("Tool Shoper");
                    Shoperpost shoperpost=new Shoperpost();
                    shoperpost.setLocation(locations);
                    shoperpost.setName(names);
                    shoperpost.setPrice(prices);
                    shoperpost.setType(types);
                    shoperpost.setStown(towns);
                    reff.child(towns).child(codeno).setValue(shoperpost);
                    Toast.makeText(Shoper.this,"သင့်ကုန်ပစ္စည်းများအား အရောင်းပို့သို့ တင်ပြီးပါပြီ\n" +"အခြားကုန်ပစ္စည်းများ တင်လိုပါက ထပ်မံ ဖြည့်စွက်ပါ။",Toast.LENGTH_LONG).show();
                }
            }
        });
        spost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String types=type.getText().toString().trim();
                String prices=price.getText().toString().trim();
                String names=name.getText().toString().trim();
                String locations=location.getText().toString().trim();
                String codeno=codenos.getText().toString().trim();
                String towns=stown.getText().toString().trim();
//                int selectfield=radioGroup.getCheckedRadioButtonId();
//                fields=findViewById(selectfield);
//                String field=fields.getText().toString();

                if(types.length()==0 || prices.length()==0 || name.length()==0 || locations.length()==0 || codeno.length()<6){
                    Toast.makeText(Shoper.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                }
                else{
                    reffs = FirebaseDatabase.getInstance().getReference("Medical Shoper");
                    Shoperpost shoperpost=new Shoperpost();
                    shoperpost.setLocation(locations);
                    shoperpost.setName(names);
                    shoperpost.setPrice(prices);
                    shoperpost.setType(types);
                    shoperpost.setStown(towns);
                    reffs.child(towns).child(codeno).setValue(shoperpost);
                    Toast.makeText(Shoper.this,"သင့်ကုန်ပစ္စည်းများအား အရောင်းပို့သို့ တင်ပြီးပါပြီ\n" +"အခြားကုန်ပစ္စည်းများ တင်လိုပါက ထပ်မံ ဖြည့်စွက်ပါ။",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
//တစ်ခါတစ်လေတော့လည်း အဝေးဆုံးကို ထွက်ပြေးသွားချင်နေမိတယ်