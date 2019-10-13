package com.mt.shweba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {
    EditText topic,summary;
    Button posts;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        topic=(EditText)findViewById(R.id.topic);
        summary=(EditText)findViewById(R.id.summary);
        posts=(Button)findViewById(R.id.post);

        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff= FirebaseDatabase.getInstance().getReference("Feedback");
                FeedBackPost finsert=new FeedBackPost();
                String topics=topic.getText().toString().trim();
                String summmaries=summary.getText().toString().trim();

                if(topics.length()==0 || summmaries.length()==0 ){
                    Toast.makeText(Feedback.this,"ပြည့်စုံစွာ ဖြည့်စွက်ပေးပါ",Toast.LENGTH_LONG).show();
                }
                else{
                    finsert.setAbstrat(summmaries);
                    finsert.setTitle(topics);
                    reff.child(topics).setValue(finsert);
                    Toast.makeText(Feedback.this,"သင်၏အကြံပြုချက်ကို လက်ခံရရှိပါသည်။အကြံပြုချက်အတွက် ကျေးဇူးတင်ပါသည်။",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
//သင်၏အကြံပြုချက်ကို လက်ခံရရှိပါသည်။အကြံပြုချက်အတွက် ကျေးဇူးတင်ပါသည်။