package com.example.bcspreparations.secondPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.R;
import com.example.bcspreparations.ict.ModelTestICT;
import com.example.bcspreparations.question.QuestionComputer;
import com.example.bcspreparations.questionAnalysis.QuestionAnalysisComputer;
import com.example.bcspreparations.subDiscription.SubjectDescriptionComputer;
import com.example.bcspreparations.syllabuses.SyllabuesComputer;

public class computerSecondPage extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_second_page);
        setTitle("কম্পিউটার ও তথ্যপ্রযুক্তি");
        //Computer Button Start
        button1=(Button)findViewById(R.id.ComputerButton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSyllabuesComputer();

            }
        });
        button2 = (Button)findViewById(R.id.ComputerButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionAnalysisComputer();

            }
        });
        button3 = (Button)findViewById(R.id.ComputerButton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubjectDescriptionComputer();

            }
        });
        button4 = (Button)findViewById(R.id.ComputerButton4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionComputer();

            }
        });
        button5 = (Button)findViewById(R.id.ComputerButton5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModelTestComputer();

            }
        });
        //startActivity*****
    }
    public void openSyllabuesComputer(){
        Intent intent = new Intent(this, SyllabuesComputer.class);
        startActivity(intent);
    }
    public void openQuestionAnalysisComputer(){
        Intent intent = new Intent(this, QuestionAnalysisComputer.class);
        startActivity(intent);
    }
    public void openSubjectDescriptionComputer(){
        Intent intent = new Intent(this, SubjectDescriptionComputer.class);
        startActivity(intent);
    }
    public void openQuestionComputer(){
        Intent intent= new Intent(this, QuestionComputer.class);
        startActivity(intent);
    }
    public void openModelTestComputer(){
        Intent intent = new Intent(this, ModelTestICT.class);
        startActivity(intent);

    }
}
