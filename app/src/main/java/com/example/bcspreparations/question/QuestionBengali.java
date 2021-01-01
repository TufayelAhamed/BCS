package com.example.bcspreparations.question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.answer.BengaliAnswer;
import com.example.bcspreparations.R;

public class QuestionBengali extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bengali);
        setTitle("বাংলা প্রশ্ন");
        button=(Button)findViewById(R.id.ABangla);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBengaliAnswer();
            }
        });
    }
    public void openBengaliAnswer(){
        Intent intent = new Intent(this, BengaliAnswer.class);
        startActivity(intent);
    }
}
