package com.example.bcspreparations.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScienceManage extends AppCompatActivity {
    private EditText qNameET,firstOptionET,secondOptionET,thirdOptionET,fourthOptionET;
    private RadioGroup scienceAnswer;
    private DatabaseReference rootRef;
    private DatabaseReference scienceRef;
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_manage);
        qNameET = findViewById(R.id.questionNameS);
        firstOptionET = findViewById(R.id.firstOptionS);
        secondOptionET = findViewById(R.id.secondOptionS);
        thirdOptionET = findViewById(R.id.thirdOptionS);
        fourthOptionET = findViewById(R.id.fourthOptionS);
        scienceAnswer = findViewById(R.id.scienceAnswer);
        rootRef = FirebaseDatabase.getInstance().getReference();
        scienceRef = rootRef.child("Science");
    }
    public void SaveBTN(View view) {
        String question = qNameET.getText().toString();
        String firstOption = firstOptionET.getText().toString();
        String secondOption = secondOptionET.getText().toString();
        String thirdOption = thirdOptionET.getText().toString();
        String fourthOption = fourthOptionET.getText().toString();
        switch (scienceAnswer.getCheckedRadioButtonId()){
            case R.id.scienceRadioA:
                answer = firstOptionET.getText().toString();
                break;
            case R.id.scienceRadioB:
                answer = secondOptionET.getText().toString();
                break;
            case R.id.scienceRadioC:
                answer = thirdOptionET.getText().toString();
                break;
            case R.id.scienceRadioD:
                answer = fourthOptionET.getText().toString();
                break;
        }
        scienceAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //String answer = "";
                switch (checkedId){
                    case R.id.scienceRadioA:
                        answer = firstOptionET.getText().toString();
                        break;
                    case R.id.scienceRadioB:
                        answer = secondOptionET.getText().toString();
                        break;
                    case R.id.scienceRadioC:
                        answer = thirdOptionET.getText().toString();
                        break;
                    case R.id.scienceRadioD:
                        answer = fourthOptionET.getText().toString();
                        break;
                }
            }
        });
        GetPush push = new GetPush(question, firstOption, secondOption, thirdOption, fourthOption, answer);
        scienceRef.push().setValue(push);
        qNameET.setText("");
        firstOptionET.setText("");
        secondOptionET.setText("");
        thirdOptionET.setText("");
        fourthOptionET.setText("");
        scienceAnswer.clearCheck();

        /*Intent intent = new Intent(this, ModelTestSubject.class);
        startActivity(intent);*/
    }
}
