package com.example.bcspreparations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcspreparations.secondPages.BanglaSecondPage;
import com.example.bcspreparations.secondPages.CommonsenseSecondPage;
import com.example.bcspreparations.secondPages.EnglishSecondPage;
import com.example.bcspreparations.secondPages.MathSecondPage;
import com.example.bcspreparations.secondPages.ScienceSecondPage;
import com.example.bcspreparations.secondPages.computerSecondPage;

public class SecondPage extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        setTitle("বিষয়");
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBanglaSecondPage();

            }
        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnglishSecondPage();
            }
        });
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMathSecondPage();
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommonsenseSecondPage();
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScienceSecondPage();
            }
        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencomputerSecondPage();
            }
        });

    }
    public void openBanglaSecondPage(){

        Intent intent = new Intent(this, BanglaSecondPage.class);
        startActivity(intent);
    }
    public void openEnglishSecondPage(){
        Intent intent=new Intent(this, EnglishSecondPage.class);
        startActivity(intent);
    }
    public void openMathSecondPage(){

        Intent intent = new Intent(this, MathSecondPage.class);
        startActivity(intent);
    }
    public void openCommonsenseSecondPage(){
        Intent intent = new Intent(this, CommonsenseSecondPage.class);
        startActivity(intent);
    }
    public void openScienceSecondPage(){
        Intent intent = new Intent(this, ScienceSecondPage.class);
        startActivity(intent);
    }
    public void opencomputerSecondPage(){
        Intent intent = new Intent(this, computerSecondPage.class);
        startActivity(intent);
    }
}
