package com.example.bcspreparations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BCS প্রস্তুতি");
        button = (Button) findViewById(R.id.main_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecond_Page();
            }
        });
    }
    public void openSecond_Page(){
        Intent intent = new Intent(this,SecondPage.class);
        startActivity(intent);


    }
}
