package com.example.bcspreparations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MarkSheet extends AppCompatActivity {
    private TextView total, attend, wrong, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_sheet);
        setTitle("Mark Sheet");
        Intent intent = getIntent();
        total = findViewById(R.id.markSheetTotal);
        attend = findViewById(R.id.markSheetAttend);
        wrong = findViewById(R.id.markSheetWrong);
        score = findViewById(R.id.markSheetScore);

        total.setText("Numbers of Question: "+intent.getStringExtra("Total"));
        attend.setText("You have Attend: "+intent.getStringExtra("Attend"));
        wrong.setText("Wrong Answer: "+intent.getStringExtra("Wrong"));
        score.setText("Your Score: "+intent.getStringExtra("Correct"));

    }

    public void Done(View view) {
        Intent intent = new Intent(MarkSheet.this, SecondPage.class);
        startActivity(intent);
    }
}
