package com.example.bcspreparations.question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.answer.MathAnswer;
import com.example.bcspreparations.R;

public class QuestionMath extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_math);
        setTitle("গণিত প্রশ্ন");
        button = (Button)findViewById(R.id.MAns);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMathAnswer();
            }
        });
    }
    public void openMathAnswer(){
        Intent intent = new Intent(this, MathAnswer.class);
        startActivity(intent);
    }
}
