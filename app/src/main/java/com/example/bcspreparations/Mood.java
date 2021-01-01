package com.example.bcspreparations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bcspreparations.admin.ModelTestSubject;
import com.example.bcspreparations.admin.PageSwitch;

public class Mood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        setTitle("Administrative Mode");
    }

    public void UserMoodBTN(View view) {

        startActivity(new Intent(Mood.this,MainActivity.class));
    }

    public void AdminMoodBTN(View view) {

        startActivity(new Intent(Mood.this, PageSwitch.class));
    }
}
