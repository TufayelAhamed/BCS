package com.example.bcspreparations.secondPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.ModelTestScience;
import com.example.bcspreparations.R;
import com.example.bcspreparations.admin.BanglaEdit;
import com.example.bcspreparations.question.QuestionScience;
import com.example.bcspreparations.questionAnalysis.QuestionAnalysisScience;
import com.example.bcspreparations.subDiscription.SubjectDescriptionScience;
import com.example.bcspreparations.syllabuses.ScienceSyllabus;

public class ScienceSecondPage extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_second_page);
        setTitle("বিজ্ঞান");
        button1 = (Button)findViewById(R.id.Science_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScienceSyllabus();
            }
        });
        button2=(Button)findViewById(R.id.Science_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionAnalysisScience();

            }
        });
        button3=(Button)findViewById(R.id.Science_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubjectDescriptionScience();
            }
        });
        button4=(Button)findViewById(R.id.Science_button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionScience();
            }
        });
        button5=(Button)findViewById(R.id.Science_button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModelTestScience();
            }
        });
    }
    public void openScienceSyllabus(){
        Intent intent = new Intent(this, ScienceSyllabus.class);
        startActivity(intent);

    }
    public void openQuestionAnalysisScience(){
        Intent intent = new Intent(this, QuestionAnalysisScience.class);
        startActivity(intent);
    }
    public void openSubjectDescriptionScience(){
        Intent intent = new Intent(this, SubjectDescriptionScience.class);
        startActivity(intent);
    }
    public void openQuestionScience(){
        Intent intent = new Intent(this, QuestionScience.class);
        startActivity(intent);

    }
    public void openModelTestScience(){
        Intent intent = new Intent(this, ModelTestScience.class);
        startActivity(intent);
    }
}
