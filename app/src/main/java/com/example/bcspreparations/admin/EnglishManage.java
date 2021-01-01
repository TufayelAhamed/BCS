package com.example.bcspreparations.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnglishManage extends AppCompatActivity {
    private EditText qNameET,firstOptionET,secondOptionET,thirdOptionET,fourthOptionET;
    private RadioGroup englishAnswer;
    private static final String TAG = "EnglishManage";
    private DatabaseReference rootRef;
    private DatabaseReference englishRef;
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_manage);

        qNameET = findViewById(R.id.questionNameE);
        firstOptionET = findViewById(R.id.firstOptionE);
        secondOptionET = findViewById(R.id.secondOptionE);
        thirdOptionET = findViewById(R.id.thirdOptionE);
        fourthOptionET = findViewById(R.id.fourthOptionE);
        englishAnswer = findViewById(R.id.englishAnswer);
        rootRef = FirebaseDatabase.getInstance().getReference();
        englishRef = rootRef.child("English");

    }

    public void SaveBTN(View view) {
        Log.i(TAG, "Question: " + qNameET.getText().toString() + "\n A. "+ firstOptionET.getText().toString() );

        //String id = englishRef.push().getKey();
        String question = qNameET.getText().toString();
        String firstOption = firstOptionET.getText().toString();
        String secondOption = secondOptionET.getText().toString();
        String thirdOption = thirdOptionET.getText().toString();
        String fourthOption = fourthOptionET.getText().toString();

        switch (englishAnswer.getCheckedRadioButtonId()){
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
        englishAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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

       GetPush e = new GetPush(question,firstOption,secondOption,thirdOption, fourthOption,answer);
       //englishRef.child(id).setValue(e);
        englishRef.push().setValue(e);

        qNameET.setText("");
        firstOptionET.setText("");
        secondOptionET.setText("");
        thirdOptionET.setText("");
        fourthOptionET.setText("");
        englishAnswer.clearCheck();

        /*Intent intent = new Intent(this, ModelTestSubject.class);
        startActivity(intent);*/
    }
}
