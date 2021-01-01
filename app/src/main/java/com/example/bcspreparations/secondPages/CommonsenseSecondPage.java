package com.example.bcspreparations.secondPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.ModelTestGK;
import com.example.bcspreparations.R;
import com.example.bcspreparations.question.QuestionCommonsens;
import com.example.bcspreparations.questionAnalysis.QuestionAnalysisCommonsense;
import com.example.bcspreparations.subDiscription.SubjectDescriptionCommonsense;
import com.example.bcspreparations.syllabuses.CommonsenseSyllabus;

public class CommonsenseSecondPage extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonsense_second_page);
        setTitle("সাধারণ জ্ঞান");
        button1 = (Button)findViewById(R.id.CSbutton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommonsenseSyllabus();

            }
        });
        button2 = (Button)findViewById(R.id.CSutton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionAnalysisCommonsense();
            }
        });
        button3 = (Button)findViewById(R.id.CSutton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubjectDescriptionCommonsense();
            }
        });
        button4 = (Button)findViewById(R.id.CSbutton4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionCommonsens();
            }
        });
        button5 = (Button)findViewById(R.id.CSbutton5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModelTestCommonsense();
            }
        });
    }
    public void openCommonsenseSyllabus(){
        Intent intent = new Intent(this, CommonsenseSyllabus.class);
        startActivity(intent);

    }
    public void openQuestionAnalysisCommonsense(){
        Intent intent = new Intent(this, QuestionAnalysisCommonsense.class);
        startActivity(intent);
    }
    public void openSubjectDescriptionCommonsense(){
        Intent intent = new Intent(this, SubjectDescriptionCommonsense.class);
        startActivity(intent);
    }
    public void openQuestionCommonsens(){
        Intent intent = new Intent(this, QuestionCommonsens.class);
        startActivity(intent);
    }
    public void openModelTestCommonsense(){
        Intent intent = new Intent(this, ModelTestGK.class);
        startActivity(intent);
    }
}
