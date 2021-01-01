package com.example.bcspreparations.english;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
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
import com.example.bcspreparations.TestQuestionList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ModelTestEnglish extends AppCompatActivity {
    private DatabaseReference rootRef;
    private DatabaseReference englishRef;
    private List<GetPush> modelTest = new ArrayList<>();
    Button nextBTN;
    TextView total, attend, score, question, optionA, optionB, optionC, optionD, answer, userAnswer;
    RadioGroup radioGroup;
    RadioButton radioA,radioB,radioC,radioD;
    private int count =0;
    private int scr = 0;
    private int att = 0;
    private static final String TAG = "ModelTestEnglish";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_test_english);
        setTitle("ইংরেজী মডেল টেস্ট");
        total = findViewById(R.id.englishModelTestQuestionTOTAL);
        attend = findViewById(R.id.englishModelTestQuestionATTEND);
        score = findViewById(R.id.englishModelTestQuestionSCORE);
        question = findViewById(R.id.englishModelTestQuestion);
        optionA = findViewById(R.id.englishModelTestOptionA);
        optionB = findViewById(R.id.englishModelTestOptionB);
        optionC = findViewById(R.id.englishModelTestOptionC);
        optionD = findViewById(R.id.englishModelTestOptionD);
        answer = findViewById(R.id.englishModelTestAnswer);
        radioGroup = findViewById(R.id.englishRadioGroup);
        nextBTN = findViewById(R.id.englishNextBTN);
        userAnswer = findViewById(R.id.englishClicked);
        nextBTN.setVisibility(View.GONE);
        rootRef = FirebaseDatabase.getInstance().getReference();
        englishRef = rootRef.child("English");
        englishRef.keepSynced(true);
        englishRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelTest.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    GetPush e = d.getValue(GetPush.class);
                    /*GetPush questionList=new GetPush(e.getQuestion(),e.getFirstOption(),e.getSecondOption(),
                            e.getThirdOption(),e.getFourthOption(),e.getAnswer(),0);*/
                    modelTest.add(e);
                }
                total.setText("Total Question: "+modelTest.size());
                attend.setText("Attend: "+att);
                score.setText("Score: "+ scr);
                question.setText("Question: "+ (count+1) +"\n"+ modelTest.get(count).question);
                optionA.setText("A. "+modelTest.get(count).firstOption);
                optionB.setText("B. "+modelTest.get(count).secondOption);
                optionC.setText("C. "+modelTest.get(count).thirdOption);
                optionD.setText("D. "+modelTest.get(count).fourthOption);
                answer.setText("Answer: "+modelTest.get(count).answer);
                answer.setVisibility(View.GONE);
                nextBTN.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
                count++;
                englishRef.getDatabase();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void NextBTN(View view) {
        if(modelTest.size()>count){
            DefaultText();
            userAnswer.setVisibility(View.INVISIBLE);
            radioGroup.clearCheck();
            total.setText("Total Question: "+modelTest.size());
            attend.setText("Attend: "+att);
            score.setText("Score: "+ scr);
            answer.setVisibility(View.GONE);
            question.setText("Question: "+ (count+1) +"\n"+ modelTest.get(count).question);
            optionA.setText("A. "+modelTest.get(count).firstOption);
            optionB.setText("B. "+modelTest.get(count).secondOption);
            optionC.setText("C. "+modelTest.get(count).thirdOption);
            optionD.setText("D. "+modelTest.get(count).fourthOption);
            answer.setText("Answer: "+modelTest.get(count).answer);
            radioGroup.setVisibility(View.VISIBLE);
            count++;
        }else {
            Intent intent = new Intent(ModelTestEnglish.this, MarkSheet.class);
            intent.putExtra("Total",String.valueOf(modelTest.size()));
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
        if (modelTest.get(count-1).firstOption.equals(modelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.correct));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            if (modelTest.get(count-1).secondOption.equals(modelTest.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).thirdOption.equals(modelTest.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).fourthOption.equals(modelTest.get(count-1).answer)){
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
        if (modelTest.get(count-1).secondOption.equals(modelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.correct));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            if (modelTest.get(count-1).firstOption.equals(modelTest.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).thirdOption.equals(modelTest.get(count-1).answer)){
                optionC.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).fourthOption.equals(modelTest.get(count-1).answer)){
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
        if (modelTest.get(count-1).thirdOption.equals(modelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.correct));
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            if (modelTest.get(count-1).firstOption.equals(modelTest.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).secondOption.equals(modelTest.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).fourthOption.equals(modelTest.get(count-1).answer)){
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
        if (modelTest.get(count-1).fourthOption.equals(modelTest.get(count-1).answer)){
            scr++;
            optionA.setTextColor(getResources().getColor(R.color.incorrect));
            optionB.setTextColor(getResources().getColor(R.color.incorrect));
            optionC.setTextColor(getResources().getColor(R.color.incorrect));
            optionD.setTextColor(getResources().getColor(R.color.correct));
            answer.setTextColor(getResources().getColor(R.color.correct));
            score.setText("Score: "+ scr);
        }else {
            optionD.setTextColor(getResources().getColor(R.color.incorrect));
            if (modelTest.get(count-1).firstOption.equals(modelTest.get(count-1).answer)){
                optionA.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).secondOption.equals(modelTest.get(count-1).answer)){
                optionB.setTextColor(getResources().getColor(R.color.correct));
            }else if (modelTest.get(count-1).thirdOption.equals(modelTest.get(count-1).answer)){
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
