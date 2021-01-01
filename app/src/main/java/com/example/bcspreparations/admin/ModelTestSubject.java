package com.example.bcspreparations.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bcspreparations.R;

public class ModelTestSubject extends AppCompatActivity {

    private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modeltest_subject);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            value = extras.getString("edit");
        }
    }

    public void English(View view) {
        if (value.equals("insert")){
            startActivity(new Intent(ModelTestSubject.this, EnglishManage.class));
        }else if (value.equals("delete")){
            startActivity(new Intent(ModelTestSubject.this, EnglishEdit.class));
        }
    }

    public void Bangla(View view) {
        if (value.equals("insert")){
            startActivity(new Intent(ModelTestSubject.this, BanglaManage.class));
        }else if (value.equals("delete")){
            startActivity(new Intent(ModelTestSubject.this, BanglaEdit.class));
        }
    }

    public void Math(View view) {
        if (value.equals("insert")){
            startActivity(new Intent(ModelTestSubject.this, MathManage.class));
        }else if (value.equals("delete")){
            startActivity(new Intent(ModelTestSubject.this, MathEdit.class));
        }
    }

    public void GeneralKnowladge(View view) {
        if (value.equals("insert")){
            startActivity(new Intent(ModelTestSubject.this, GeneralKnowladgeManage.class));
        }else if (value.equals("delete")){
            startActivity(new Intent(ModelTestSubject.this, GeneralKnowledgeEdit.class));
        }
    }

    public void Science(View view) {
        if (value.equals("insert")){
            startActivity(new Intent(ModelTestSubject.this, ScienceManage.class));
        }else if (value.equals("delete")){
            startActivity(new Intent(ModelTestSubject.this, ScienceEdit.class));
        }
    }

    public void ICT(View view) {
        if (value.equals("insert")){
            startActivity(new Intent(ModelTestSubject.this, ICTManage.class));
        }else if (value.equals("delete")){
            startActivity(new Intent(ModelTestSubject.this, ICTEdit.class));
        }
    }
}
