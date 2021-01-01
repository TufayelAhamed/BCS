package com.example.bcspreparations.bangla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.MarkSheet;
import com.example.bcspreparations.R;
import com.example.bcspreparations.admin.EnglishEditAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ModelTestBangla extends AppCompatActivity {
    private DatabaseReference rootRef;
    private DatabaseReference banglaRef;
    private List<GetPush> banglaModelTest = new ArrayList<>();
    Button nextBTN;
    TextView total, attend, score, question, optionA, optionB, optionC, optionD, answer, userAnswer;
    RadioGroup radioGroup;
    RadioButton radioA,radioB,radioC,radioD;
    private int count =0;
    private int scr = 0;
    private int att = 0;
    private String TAG ="ModelTestBangla";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_test_bangla);
        setTitle("বাংলা মডেল টেস্ট");
        total = findViewById(R.id.banglaModelTestQuestionTOTAL);
        attend = findViewById(R.id.banglaModelTestQuestionATTEND);
        score = findViewById(R.id.banglaModelTestQuestionSCORE);
        question = findViewById(R.id.banglaModelTestQuestion);
        optionA = findViewById(R.id.banglaModelTestOptionA);
        optionB = findViewById(R.id.banglaModelTestOptionB);
        optionC = findViewById(R.id.banglaModelTestOptionC);
        optionD = findViewById(R.id.banglaModelTestOptionD);
        answer = findViewById(R.id.banglaModelTestAnswer);
        radioGroup = findViewById(R.id.banglaRadioGroup);
        nextBTN = findViewById(R.id.banglaNextBTN);
        userAnswer = findViewById(R.id.banglaClicked);
        nextBTN.setVisibility(View.GONE);
        rootRef = FirebaseDatabase.getInstance().getReference();
        banglaRef = rootRef.child("Bangla");
        banglaRef.keepSynced(true);
        banglaRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                banglaModelTest.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    GetPush e = d.getValue(GetPush.class);
                    banglaModelTest.add(e);
                }
                total.setText("Total Question: "+banglaModelTest.size());
                attend.setText("Attend: "+att);
                score.setText("Score: "+ scr);
                question.setText("Question: "+ (count+1) +"\n"+ banglaModelTest.get(count).question);
                optionA.setText("A. "+banglaModelTest.get(count).firstOption);
                optionB.setText("B. "+banglaModelTest.get(count).secondOption);
                optionC.setText("C. "+banglaModelTest.get(count).thirdOption);
                optionD.setText("D. "+banglaModelTest.get(count).fourthOption);
                answer.setText("Answer: "+banglaModelTest.get(count).answer);
                answer.setVisibility(View.GONE);
                nextBTN.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
                count++;
                banglaRef.getDatabase();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void NextBTN(View view) {
        if(banglaModelTest.size()>count){
            DefaultText();
            userAnswer.setVisibility(View.INVISIBLE);
            radioGroup.clearCheck();
            total.setText("Total Question: "+banglaModelTest.size());
            attend.setText("Attend: "+att);
            score.setText("Score: "+ scr);
            answer.setVisibility(View.GONE);
            question.setText("Question: "+ (count+1) +"\n"+ banglaModelTest.get(count).question);
            optionA.setText("A. "+banglaModelTest.get(count).firstOption);
            optionB.setText("B. "+banglaModelTest.get(count).secondOption);
            optionC.setText("C. "+banglaModelTest.get(count).thirdOption);
            optionD.setText("D. "+banglaModelTest.get(count).fourthOption);
            answer.setText("Answer: "+banglaModelTest.get(count).answer);
            radioGroup.setVisibility(View.VISIBLE);
            count++;
        }else {
            Intent intent = new Intent(ModelTestBangla.this, MarkSheet.class);
            intent.putExtra("Total",String.valueOf(banglaModelTest.size()));
            intent.putExtra("Attend",String.valueOf(att));
            intent.putExtra("Correct",String.valueOf(scr));
            intent.putExtra("Wrong", String.valueOf(att-scr));
            startActivity(intent);
        }
    }


    public void bRadioA(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option A.");
        if (banglaModelTest.get(count-1).firstOption.equals(banglaModelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.correct));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            if (banglaModelTest.get(count-1).secondOption.equals(banglaModelTest.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).thirdOption.equals(banglaModelTest.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).fourthOption.equals(banglaModelTest.get(count-1).answer)){
                optionD.setTextColor(getResources().getColor(R.color.correct));
            }
            answer.setTextColor(getResources().getColor(R.color.incorrect));
        }
    }

    public void bRadioB(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option B.");
        if (banglaModelTest.get(count-1).secondOption.equals(banglaModelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.correct));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            if (banglaModelTest.get(count-1).firstOption.equals(banglaModelTest.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).thirdOption.equals(banglaModelTest.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).fourthOption.equals(banglaModelTest.get(count-1).answer)){
                optionD.setTextColor(getResources().getColor(R.color.correct));
            }
            answer.setTextColor(getResources().getColor(R.color.incorrect));
        }
    }

    public void bRadioC(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option C.");
        if (banglaModelTest.get(count-1).thirdOption.equals(banglaModelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.correct));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            if (banglaModelTest.get(count-1).firstOption.equals(banglaModelTest.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).secondOption.equals(banglaModelTest.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).fourthOption.equals(banglaModelTest.get(count-1).answer)){
                optionD.setTextColor(getResources().getColor(R.color.correct));
            }
            answer.setTextColor(getResources().getColor(R.color.incorrect));
        }
    }

    public void bRadioD(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option D.");
        if (banglaModelTest.get(count-1).fourthOption.equals(banglaModelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.correct));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            if (banglaModelTest.get(count-1).firstOption.equals(banglaModelTest.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).secondOption.equals(banglaModelTest.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (banglaModelTest.get(count-1).thirdOption.equals(banglaModelTest.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }
            answer.setTextColor(getResources().getColor(R.color.incorrect));
        }
    }

    public void DefaultText(){
        optionA.setTextColor(getResources().getColor(R.color.textDefault));
        optionB.setTextColor(getResources().getColor(R.color.textDefault));
        optionC.setTextColor(getResources().getColor(R.color.textDefault));
        optionD.setTextColor(getResources().getColor(R.color.textDefault));
        answer.setTextColor(getResources().getColor(R.color.colorBlack));
    }

}
