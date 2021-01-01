package com.example.bcspreparations.secondPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.ModelTestMath;
import com.example.bcspreparations.R;
import com.example.bcspreparations.question.QuestionMath;
import com.example.bcspreparations.questionAnalysis.QuestionAnalysisMath;
import com.example.bcspreparations.subDiscription.SubjectDescriptionMath;
import com.example.bcspreparations.syllabuses.SyllabusMath;

public class MathSecondPage extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_second_page);
        setTitle("গণিত");
        button1 = (Button) findViewById(R.id.math_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSyllabusMath();

            }
        });
        button2 = (Button)findViewById(R.id.math_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionAnalysisMath();
            }
        });
        button3 = (Button)findViewById(R.id.math_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubjectDescriptionMath();
            }
        });
        button4 = (Button) findViewById(R.id.math_button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionMath();
            }
        });
        button5 = (Button)findViewById(R.id.math_button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModelTestMath();
            }
        });
    }
    public void openSyllabusMath(){
        Intent intent = new Intent(this, SyllabusMath.class);
        startActivity(intent);
    }
    public void openQuestionAnalysisMath(){
        Intent intent = new Intent(this, QuestionAnalysisMath.class);
        startActivity(intent);
    }
    public void openSubjectDescriptionMath(){
        Intent intent = new Intent(this, SubjectDescriptionMath.class);
        startActivity(intent);
    }
    public void openQuestionMath(){
        Intent intent = new Intent(this, QuestionMath.class);
        startActivity(intent);
    }
    public void openModelTestMath(){
        Intent intent = new Intent(this, ModelTestMath.class);
        startActivity(intent);
    }
}



