package com.example.bcspreparations.secondPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.bangla.ModelTestBangla;
import com.example.bcspreparations.questionAnalysis.QuestionAnalysisBangla;
import com.example.bcspreparations.question.QuestionBengali;
import com.example.bcspreparations.R;
import com.example.bcspreparations.subDiscription.SubjectDescriptionBangla;
import com.example.bcspreparations.syllabuses.SyllabusBangla;

public class BanglaSecondPage extends AppCompatActivity {

private Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla_second_page);
        setTitle("বাংলা");
        button1 = (Button) findViewById(R.id.bangla_bbutton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSyllabusBangla();
            }
        });
        button2 = (Button)findViewById(R.id.bangla_bbutton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionAnalysisBangla();
            }
        });
        button3=(Button)findViewById(R.id.bangla_bbutton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubjectDescriptionBangla();
            }
        });
        button4=(Button)findViewById(R.id.bangla_bbutton4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionBangla();
            }
        });
        button5=(Button)findViewById(R.id.bangla_bbutton5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModelTestBangla();
            }
        });
    }
    public void openSyllabusBangla(){

        Intent intent = new Intent( this, SyllabusBangla.class);
        startActivity(intent);

    }
    public void openQuestionAnalysisBangla(){
        Intent intent = new Intent(this, QuestionAnalysisBangla.class);
        startActivity(intent);
    }
    public void openSubjectDescriptionBangla(){
        Intent intent = new Intent(this, SubjectDescriptionBangla.class);
        startActivity(intent);
    }
    public void openQuestionBangla(){
        Intent intent = new Intent(this, QuestionBengali.class);
        startActivity(intent);
    }
    public void openModelTestBangla(){
        Intent intent = new Intent(this, ModelTestBangla.class);
        startActivity(intent);


}

 }
