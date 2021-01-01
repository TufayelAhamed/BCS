package com.example.bcspreparations.secondPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.english.ModelTestEnglish;
import com.example.bcspreparations.questionAnalysis.QuestionAnalysisEnglish;
import com.example.bcspreparations.question.QuestionEnglish;
import com.example.bcspreparations.R;
import com.example.bcspreparations.subDiscription.SubjectDescriptionEnglish;
import com.example.bcspreparations.syllabuses.SyllabusEnglish;

public class EnglishSecondPage extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_second_page);
        setTitle("ইংরেজী");
        button1 = (Button)findViewById(R.id.english_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSyllabusEnglish();

            }
        });
        button2 = (Button)findViewById(R.id.english_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionAnalysisEnglish();

            }
        });
        button3 = (Button)findViewById(R.id.english_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubjectDescriptionEnglish();
            }
        });
        button4 = (Button)findViewById(R.id.english_button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionEnglish();
            }
        });
        button5 = (Button)findViewById(R.id.english_button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModelTestEnglish();
            }
        });
    }
    public void openSyllabusEnglish(){
        Intent intent = new Intent(this, SyllabusEnglish.class);
        startActivity(intent);
    }
    public void openQuestionAnalysisEnglish(){
        Intent intent = new Intent(this, QuestionAnalysisEnglish.class);
        startActivity(intent);
    }
    public void openSubjectDescriptionEnglish(){
        Intent intent = new Intent(this, SubjectDescriptionEnglish.class);
        startActivity(intent);
    }
    public void openQuestionEnglish(){
        Intent intent = new Intent(this, QuestionEnglish.class);
        startActivity(intent);

    }
    public void openModelTestEnglish(){
        Intent intent = new Intent(this, ModelTestEnglish.class);
        startActivity(intent);
    }
}
