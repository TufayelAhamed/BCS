package com.example.bcspreparations.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bcspreparations.Mood;
import com.example.bcspreparations.R;

public class PageSwitch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_switch);
        setTitle("Administrative Mode");
    }

    public void Insart(View view) {
        String value = "insert";
        Intent i = new Intent(PageSwitch.this, ModelTestSubject.class);
        i.putExtra("edit",value);
        startActivity(i);
    }

    /*public void Delete(View view) {
        String value = "delete";
        Intent i = new Intent(PageSwitch.this, ModelTestSubject.class);
        i.putExtra("edit",value);
        startActivity(i);
    }*/
}
