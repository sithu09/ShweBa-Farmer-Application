package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Canel extends AppCompatActivity {
    EditText topic,department,date,summary,nos,mtown;
    Button posts;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canel);
        topic=(EditText)findViewById(R.id.topic);
        department=(EditText)findViewById(R.id.department);
        mtown=(EditText)findViewById(R.id.mtown);
        nos=(EditText)findViewById(R.id.no);
        date=(EditText)findViewById(R.id.date);
        summary=(EditText)findViewById(R.id.summary);
        posts=(Button)findViewById(R.id.post);

        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff= FirebaseDatabase.getInstance().getReference("Department");
                CanelInsert cinsert=new CanelInsert();
                String topics=topic.getText().toString().trim();
                String departments=department.getText().toString().trim();
                String mtowns=mtown.getText().toString().trim();
                String dates=date.getText().toString().trim();
                String no=nos.getText().toString().trim();
                String summmaries=summary.getText().toString().trim();
                String code="G-9660";

                if(topics.length()==0 || departments.length()==0 || dates.length()==0 || summmaries.length()==0 || !no.equals("G-9660") || mtowns.length()==0){
                    Toast.makeText(Canel.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                }//စစ်ဆေးချက်တွေ လိုနေပါသေးတယ် :3
                //လိုတော့ ယီးဖြစ်လား

//                else if(no!="G-9660" ){
//                    Toast.makeText(Canel.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
//                }
                else{
                    cinsert.setDate(dates);
                    cinsert.setDepartment(departments);
                    cinsert.setMtown(mtowns);
                    cinsert.setSummary(summmaries);
                    cinsert.setTopic(topics);
                    reff.child(mtowns).child(topics).setValue(cinsert);
                    Toast.makeText(Canel.this,"ဖြည့်စွက်မှုအောင်မြင်ပါသည်",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
