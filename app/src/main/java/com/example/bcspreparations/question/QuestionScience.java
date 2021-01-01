package com.example.bcspreparations.question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.R;
import com.example.bcspreparations.answer.ScienceAnswer;

public class QuestionScience extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_science);
        setTitle("বিজ্ঞান প্রশ্ন");
        button = (Button)findViewById(R.id.SAns);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScienceAnswer();
            }
        });
    }
    public void openScienceAnswer(){
        Intent intent = new Intent(this, ScienceAnswer.class);
        startActivity(intent);
    }
}
