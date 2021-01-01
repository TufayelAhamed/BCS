package com.example.bcspreparations.question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.answer.EnglishAnswer;
import com.example.bcspreparations.R;

public class QuestionEnglish extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_english);
        setTitle("ইংরেজী প্রশ্ন");
        button=(Button)findViewById(R.id.EAns);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnglishAnswer();
            }
        });
    }
    public void openEnglishAnswer(){
        Intent intent = new Intent(this, EnglishAnswer.class);
        startActivity(intent);
    }
}
