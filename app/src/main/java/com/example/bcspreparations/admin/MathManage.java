package com.example.bcspreparations.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MathManage extends AppCompatActivity {
    private EditText qNameET,firstOptionET,secondOptionET,thirdOptionET,fourthOptionET;
    private RadioGroup mathAnswer;
    private DatabaseReference rootRef;
    private DatabaseReference mathRef;
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_manage);

        qNameET = findViewById(R.id.questionNameM);
        firstOptionET = findViewById(R.id.firstOptionM);
        secondOptionET = findViewById(R.id.secondOptionM);
        thirdOptionET = findViewById(R.id.thirdOptionM);
        fourthOptionET = findViewById(R.id.fourthOptionM);
        mathAnswer = findViewById(R.id.mathAnswer);
        rootRef = FirebaseDatabase.getInstance().getReference();
        mathRef = rootRef.child("Math");
    }

    public void SaveBTN(View view) {
        String question = qNameET.getText().toString();
        String firstOption = firstOptionET.getText().toString();
        String secondOption = secondOptionET.getText().toString();
        String thirdOption = thirdOptionET.getText().toString();
        String fourthOption = fourthOptionET.getText().toString();
        switch (mathAnswer.getCheckedRadioButtonId()){
            case R.id.mathRadioA:
                answer = firstOptionET.getText().toString();
                break;
            case R.id.mathRadioB:
                answer = secondOptionET.getText().toString();
                break;
            case R.id.mathRadioC:
                answer = thirdOptionET.getText().toString();
                break;
            case R.id.mathRadioD:
                answer = fourthOptionET.getText().toString();
                break;
        }
        mathAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //String answer = "";
                switch (checkedId){
                    case R.id.englishRadioA:
                        answer = firstOptionET.getText().toString();
                        break;
                    case R.id.englishRadioB:
                        answer = secondOptionET.getText().toString();
                        break;
                    case R.id.englishRadioC:
                        answer = thirdOptionET.getText().toString();
                        break;
                    case R.id.englishRadioD:
                        answer = fourthOptionET.getText().toString();
                        break;
                }
            }
        });
        GetPush push = new GetPush(question, firstOption, secondOption, thirdOption, fourthOption, answer);
        mathRef.push().setValue(push);

        qNameET.setText("");
        firstOptionET.setText("");
        secondOptionET.setText("");
        thirdOptionET.setText("");
        fourthOptionET.setText("");
        mathAnswer.clearCheck();

        /*Intent intent = new Intent(this, ModelTestSubject.class);
        startActivity(intent);*/
    }
}
