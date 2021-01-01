package com.example.bcspreparations.question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.answer.CommonsensAnswer;
import com.example.bcspreparations.R;

public class QuestionComputer extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_computer);
        setTitle("কম্পিউটার ও তথ্যপ্রযুক্তি প্রশ্ন");
        button = (Button)findViewById(R.id.CAns);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openComputerAnswer();
            }
        });
    }
    public void openComputerAnswer(){
        Intent intent = new Intent(this, CommonsensAnswer.class);
        startActivity(intent);
    }
}
