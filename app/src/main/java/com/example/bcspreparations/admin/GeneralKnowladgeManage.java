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

public class GeneralKnowladgeManage extends AppCompatActivity {
    private EditText qNameET,firstOptionET,secondOptionET,thirdOptionET,fourthOptionET;
    private RadioGroup gkAnswer;
    private DatabaseReference rootRef;
    private DatabaseReference gkRef;
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowladge_manage);

        qNameET = findViewById(R.id.questionNameGK);
        firstOptionET = findViewById(R.id.firstOptionGK);
        secondOptionET = findViewById(R.id.secondOptionGK);
        thirdOptionET = findViewById(R.id.thirdOptionGK);
        fourthOptionET = findViewById(R.id.fourthOptionGK);
        gkAnswer = findViewById(R.id.gkAnswer);
        rootRef = FirebaseDatabase.getInstance().getReference();
        gkRef = rootRef.child("GeneralKnowledge");
    }

    public void SaveBTN(View view) {
        String question = qNameET.getText().toString();
        String firstOption = firstOptionET.getText().toString();
        String secondOption = secondOptionET.getText().toString();
        String thirdOption = thirdOptionET.getText().toString();
        String fourthOption = fourthOptionET.getText().toString();
        switch (gkAnswer.getCheckedRadioButtonId()){
            case R.id.gkRadioA:
                answer = firstOptionET.getText().toString();
                break;
            case R.id.gkRadioB:
                answer = secondOptionET.getText().toString();
                break;
            case R.id.gkRadioC:
                answer = thirdOptionET.getText().toString();
                break;
            case R.id.gkRadioD:
                answer = fourthOptionET.getText().toString();
                break;
        }
        gkAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
        gkRef.push().setValue(push);

        qNameET.setText("");
        firstOptionET.setText("");
        secondOptionET.setText("");
        thirdOptionET.setText("");
        fourthOptionET.setText("");
        gkAnswer.clearCheck();

        /*Intent intent = new Intent(this, ModelTestSubject.class);
        startActivity(intent);*/
    }
}
