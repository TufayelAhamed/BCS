package com.example.bcspreparations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.bcspreparations.bangla.ModelTestBangla;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ModelTestScience extends AppCompatActivity {
    private DatabaseReference rootRef;
    private DatabaseReference sciRef;
    private List<GetPush> sci = new ArrayList<>();
    Button nextBTN;
    TextView total, attend, score, question, optionA, optionB, optionC, optionD, answer, userAnswer;
    RadioGroup radioGroup;
    RadioButton radioA,radioB,radioC,radioD;
    private int count =0;
    private int scr = 0;
    private int att = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_test_science);
        setTitle("বিজ্ঞান মডেল টেস্ট");
        total = findViewById(R.id.sciModelTestQuestionTOTAL);
        attend = findViewById(R.id.sciModelTestQuestionATTEND);
        score = findViewById(R.id.sciModelTestQuestionSCORE);
        question = findViewById(R.id.sciModelTestQuestion);
        optionA = findViewById(R.id.sciModelTestOptionA);
        optionB = findViewById(R.id.sciModelTestOptionB);
        optionC = findViewById(R.id.sciModelTestOptionC);
        optionD = findViewById(R.id.sciModelTestOptionD);
        answer = findViewById(R.id.sciModelTestAnswer);
        radioGroup = findViewById(R.id.sciRadioGroup);
        nextBTN = findViewById(R.id.sciNextBTN);
        userAnswer = findViewById(R.id.sciClicked);
        nextBTN.setVisibility(View.GONE);
        rootRef = FirebaseDatabase.getInstance().getReference();
        sciRef = rootRef.child("Science");
        sciRef.keepSynced(true);
        sciRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sci.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    GetPush e = d.getValue(GetPush.class);
                    sci.add(e);
                }
                total.setText("Total Question: "+sci.size());
                attend.setText("Attend: "+att);
                score.setText("Score: "+ scr);
                question.setText("Question: "+ (count+1) +"\n"+ sci.get(count).question);
                optionA.setText("A. "+sci.get(count).firstOption);
                optionB.setText("B. "+sci.get(count).secondOption);
                optionC.setText("C. "+sci.get(count).thirdOption);
                optionD.setText("D. "+sci.get(count).fourthOption);
                answer.setText("Answer: "+sci.get(count).answer);
                answer.setVisibility(View.GONE);
                nextBTN.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
                count++;
                sciRef.getDatabase();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void NextBTN(View view) {
        if(sci.size()>count){
            DefaultText();
            userAnswer.setVisibility(View.INVISIBLE);
            radioGroup.clearCheck();
            total.setText("Total Question: "+sci.size());
            attend.setText("Attend: "+att);
            score.setText("Score: "+ scr);
            answer.setVisibility(View.GONE);
            question.setText("Question: "+ (count+1) +"\n"+ sci.get(count).question);
            optionA.setText("A. "+sci.get(count).firstOption);
            optionB.setText("B. "+sci.get(count).secondOption);
            optionC.setText("C. "+sci.get(count).thirdOption);
            optionD.setText("D. "+sci.get(count).fourthOption);
            answer.setText("Answer: "+sci.get(count).answer);
            radioGroup.setVisibility(View.VISIBLE);
            count++;
        }else {
            Intent intent = new Intent(ModelTestScience.this, MarkSheet.class);
            intent.putExtra("Total",String.valueOf(sci.size()));
            intent.putExtra("Attend",String.valueOf(att));
            intent.putExtra("Correct",String.valueOf(scr));
            intent.putExtra("Wrong", String.valueOf(att-scr));
            startActivity(intent);
        }
    }

    public void RadioA(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option A.");
        if (sci.get(count-1).firstOption.equals(sci.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.correct));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            if (sci.get(count-1).secondOption.equals(sci.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).thirdOption.equals(sci.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).fourthOption.equals(sci.get(count-1).answer)){
                optionD.setTextColor(getResources().getColor(R.color.correct));
            }
            answer.setTextColor(getResources().getColor(R.color.incorrect));
        }
    }

    public void RadioB(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option B.");
        if (sci.get(count-1).secondOption.equals(sci.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.correct));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            if (sci.get(count-1).firstOption.equals(sci.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).thirdOption.equals(sci.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).fourthOption.equals(sci.get(count-1).answer)){
                optionD.setTextColor(getResources().getColor(R.color.correct));
            }
            answer.setTextColor(getResources().getColor(R.color.incorrect));
        }
    }

    public void RadioC(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option C.");
        if (sci.get(count-1).thirdOption.equals(sci.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.correct));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            if (sci.get(count-1).firstOption.equals(sci.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).secondOption.equals(sci.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).fourthOption.equals(sci.get(count-1).answer)){
                optionD.setTextColor(getResources().getColor(R.color.correct));
            }
            answer.setTextColor(getResources().getColor(R.color.incorrect));
        }
    }

    public void RadioD(View view) {
        att++;
        attend.setText("Attend: "+att);
        answer.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        userAnswer.setVisibility(View.VISIBLE);
        userAnswer.setText("Your Choice: Option D.");
        if (sci.get(count-1).fourthOption.equals(sci.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.correct));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            if (sci.get(count-1).firstOption.equals(sci.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).secondOption.equals(sci.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (sci.get(count-1).thirdOption.equals(sci.get(count-1).answer)){
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
