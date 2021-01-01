package com.example.bcspreparations.ict;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.MarkSheet;
import com.example.bcspreparations.R;
import com.example.bcspreparations.bangla.ModelTestBangla;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ModelTestICT extends AppCompatActivity {
    private DatabaseReference rootRef;
    private DatabaseReference ictRef;
    private List<GetPush> ict = new ArrayList<>();
    Button nextBTN;
    TextView total, attend, score, question, optionA, optionB, optionC, optionD, answer, userAnswer;
    RadioGroup radioGroup;
    RadioButton radioA,radioB,radioC,radioD;
    private int count =0;
    private int scr = 0;
    private int att = 0;
    private String TAG="ModelTestICT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_test_ict);
        setTitle("কম্পিউটার ও তথ্যপ্রযুক্তি মডেল টেস্ট");
        total = findViewById(R.id.ictModelTestQuestionTOTAL);
        attend = findViewById(R.id.ictModelTestQuestionATTEND);
        score = findViewById(R.id.ictModelTestQuestionSCORE);
        question = findViewById(R.id.ictModelTestQuestion);
        optionA = findViewById(R.id.ictModelTestOptionA);
        optionB = findViewById(R.id.ictModelTestOptionB);
        optionC = findViewById(R.id.ictModelTestOptionC);
        optionD = findViewById(R.id.ictModelTestOptionD);
        answer = findViewById(R.id.ictModelTestAnswer);
        radioGroup = findViewById(R.id.ictRadioGroup);
        nextBTN = findViewById(R.id.ictNextBTN);
        userAnswer = findViewById(R.id.ictClicked);
        nextBTN.setVisibility(View.GONE);
        rootRef = FirebaseDatabase.getInstance().getReference();
        ictRef = rootRef.child("ICT");
        //ictRef.keepSynced(true);
        ictRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ict.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    GetPush i = d.getValue(GetPush.class);
                    GetPush questionList=new GetPush(i.getQuestion(),i.getFirstOption(),i.getSecondOption(),
                            i.getThirdOption(),i.getFourthOption(),i.getAnswer());
                    ict.add(questionList);
                    Log.i(TAG,"Data"+questionList);
                }
                Log.i(TAG, "Size: "+ict.size());
                total.setText("Total Question: "+ict.size());
                attend.setText("Attend: "+att);
                score.setText("Score: "+ scr);
                question.setText("Question: "+ (count+1) +"\n"+ ict.get(count).question);
                optionA.setText("A. "+ict.get(count).firstOption);
                optionB.setText("B. "+ict.get(count).secondOption);
                optionC.setText("C. "+ict.get(count).thirdOption);
                optionD.setText("D. "+ict.get(count).fourthOption);
                answer.setText("Answer: "+ict.get(count).answer);
                answer.setVisibility(View.GONE);
                nextBTN.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
                count++;
                ictRef.getDatabase();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void NextBTN(View view) {
        if(ict.size()>count){
            DefaultText();
            userAnswer.setVisibility(View.INVISIBLE);
            radioGroup.clearCheck();
            total.setText("Total Question: "+ict.size());
            attend.setText("Attend: "+att);
            score.setText("Score: "+ scr);
            answer.setVisibility(View.GONE);
            question.setText("Question: "+ (count+1) +"\n"+ ict.get(count).question);
            optionA.setText("A. "+ict.get(count).firstOption);
            optionB.setText("B. "+ict.get(count).secondOption);
            optionC.setText("C. "+ict.get(count).thirdOption);
            optionD.setText("D. "+ict.get(count).fourthOption);
            answer.setText("Answer: "+ict.get(count).answer);
            radioGroup.setVisibility(View.VISIBLE);
            count++;
        }else {
            Intent intent = new Intent(ModelTestICT.this, MarkSheet.class);
            intent.putExtra("Total",String.valueOf(ict.size()));
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
        if (ict.get(count-1).firstOption.equals(ict.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.correct));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            if (ict.get(count-1).secondOption.equals(ict.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).thirdOption.equals(ict.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).fourthOption.equals(ict.get(count-1).answer)){
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
        if (ict.get(count-1).secondOption.equals(ict.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.correct));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            if (ict.get(count-1).firstOption.equals(ict.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).thirdOption.equals(ict.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).fourthOption.equals(ict.get(count-1).answer)){
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
        if (ict.get(count-1).thirdOption.equals(ict.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.correct));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            if (ict.get(count-1).firstOption.equals(ict.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).secondOption.equals(ict.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).fourthOption.equals(ict.get(count-1).answer)){
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
        if (ict.get(count-1).fourthOption.equals(ict.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.correct));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            if (ict.get(count-1).firstOption.equals(ict.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).secondOption.equals(ict.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (ict.get(count-1).thirdOption.equals(ict.get(count-1).answer)){
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