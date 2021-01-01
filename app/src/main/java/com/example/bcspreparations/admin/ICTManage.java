package com.example.bcspreparations.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ICTManage extends AppCompatActivity {
    private EditText qNameET,firstOptionET,secondOptionET,thirdOptionET,fourthOptionET;
    private RadioGroup ictAnswer;
    private DatabaseReference rootRef;
    private DatabaseReference ictRef;
    private String answer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ictmanage);
        qNameET = findViewById(R.id.questionNameICT);
        firstOptionET = findViewById(R.id.firstOptionICT);
        secondOptionET = findViewById(R.id.secondOptionICT);
        thirdOptionET = findViewById(R.id.thirdOptionICT);
        fourthOptionET = findViewById(R.id.fourthOptionICT);
        ictAnswer = findViewById(R.id.ictAnswer);
        rootRef = FirebaseDatabase.getInstance().getReference();
        ictRef = rootRef.child("ICT");
    }

    public void SaveBTN(View view) {
        String question = qNameET.getText().toString();
        String firstOption = firstOptionET.getText().toString();
        String secondOption = secondOptionET.getText().toString();
        String thirdOption = thirdOptionET.getText().toString();
        String fourthOption = fourthOptionET.getText().toString();
        switch (ictAnswer.getCheckedRadioButtonId()){
            case R.id.ictRadioA:
                answer = firstOptionET.getText().toString();
                break;
            case R.id.ictRadioB:
                answer = secondOptionET.getText().toString();
                break;
            case R.id.ictRadioC:
                answer = thirdOptionET.getText().toString();
                break;
            case R.id.ictRadioD:
                answer = fourthOptionET.getText().toString();
                break;
        }
        ictAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //String answer = "";
                switch (checkedId){
                    case R.id.ictRadioA:
                        answer = firstOptionET.getText().toString();
                        break;
                    case R.id.ictRadioB:
                        answer = secondOptionET.getText().toString();
                        break;
                    case R.id.ictRadioC:
                        answer = thirdOptionET.getText().toString();
                        break;
                    case R.id.ictRadioD:
                        answer = fourthOptionET.getText().toString();
                        break;
                }
            }
        });
        GetPush push = new GetPush(question, firstOption, secondOption, thirdOption, fourthOption, answer);
        ictRef.push().setValue(push);
        qNameET.setText("");
        firstOptionET.setText("");
        secondOptionET.setText("");
        thirdOptionET.setText("");
        fourthOptionET.setText("");
        ictAnswer.clearCheck();

        /*Intent intent = new Intent(this, ModelTestSubject.class);
        startActivity(intent);*/
    }
}
