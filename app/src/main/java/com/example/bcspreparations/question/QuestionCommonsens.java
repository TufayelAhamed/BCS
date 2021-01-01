package com.example.bcspreparations.question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.answer.CommonsensAnswer;
import com.example.bcspreparations.R;

public class QuestionCommonsens extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_commonsens);
        setTitle("সাধারণ জ্ঞান প্রশ্ন");
        button=(Button)findViewById(R.id.GAns);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommonsensAnswer();
            }
        });
    }
    public void openCommonsensAnswer(){
        Intent intent = new Intent(this, CommonsensAnswer.class);
        startActivity(intent);
    }
}
