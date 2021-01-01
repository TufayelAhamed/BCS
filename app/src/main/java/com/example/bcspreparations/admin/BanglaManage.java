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

public class BanglaManage extends AppCompatActivity {
    private EditText qNameET,firstOptionET,secondOptionET,thirdOptionET,fourthOptionET;
    private RadioGroup banglaAnswer;
    private static final String TAG = "BanglaManage";
    private DatabaseReference rootRef;
    private DatabaseReference banglaRef;
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla_manage);

        qNameET = findViewById(R.id.questionNameB);
        firstOptionET = findViewById(R.id.firstOptionB);
        secondOptionET = findViewById(R.id.secondOptionB);
        thirdOptionET = findViewById(R.id.thirdOptionB);
        fourthOptionET = findViewById(R.id.fourthOptionB);
        banglaAnswer = findViewById(R.id.banglaAnswer);
        rootRef = FirebaseDatabase.getInstance().getReference();
        banglaRef = rootRef.child("Bangla");
    }

    public void SaveBTN(View view) {
        String question = qNameET.getText().toString();
        String firstOption = firstOptionET.getText().toString();
        String secondOption = secondOptionET.getText().toString();
        String thirdOption = thirdOptionET.getText().toString();
        String fourthOption = fourthOptionET.getText().toString();
        switch (banglaAnswer.getCheckedRadioButtonId()){
            case R.id.banglaRadioA:
                answer = firstOptionET.getText().toString();
                Log.i(TAG,"option: "+answer);
                break;
            case R.id.banglaRadioB:
                answer = secondOptionET.getText().toString();
                Log.i(TAG,"option: "+answer);
                break;
            case R.id.banglaRadioC:
                answer = thirdOptionET.getText().toString();
                Log.i(TAG,"option: "+answer);
                break;
            case R.id.banglaRadioD:
                answer = fourthOptionET.getText().toString();
                Log.i(TAG,"option: "+answer);
                break;
        }
        banglaAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
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
        Log.i(TAG, "Test"+push);
        banglaRef.push().setValue(push);

        qNameET.setText("");
        firstOptionET.setText("");
        secondOptionET.setText("");
        thirdOptionET.setText("");
        fourthOptionET.setText("");
        banglaAnswer.clearCheck();
        /*Intent intent = new Intent(this, ModelTestSubject.class);
        startActivity(intent);*/
    }
}
