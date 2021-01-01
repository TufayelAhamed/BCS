package com.example.bcspreparations.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.R;

import java.util.List;

public class EnglishEditAdapter extends RecyclerView.Adapter<EnglishEditAdapter.Holder> {
    private Context context;
    private List<GetPush> english;

    public EnglishEditAdapter(Context context, List<GetPush> english) {
        this.context = context;
        this.english = english;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_row,parent,false);
        return new EnglishEditAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final GetPush gp = english.get(position);
        holder.questionName.setText("Question-"+ (position+1)+": " +english.get(position).getQuestion());
        holder.optionA.setText("A. "+ english.get(position).getFirstOption());
        holder.optionB.setText("B. "+english.get(position).getSecondOption());
        holder.optionC.setText("C. "+english.get(position).getThirdOption());
        holder.optionD.setText("D. "+english.get(position).getFourthOption());
        holder.answer.setText("Answer: "+english.get(position).getAnswer());
        /*holder.select.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return english.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        TextView optionA,optionB,optionC,optionD,questionName,answer;
        LinearLayout select;

        private Holder(@NonNull View itemView) {
            super(itemView);
            questionName=itemView.findViewById(R.id.questionNameEdit);
            optionA = itemView.findViewById(R.id.optionAEdit);
            optionB = itemView.findViewById(R.id.optionBEdit);
            optionC = itemView.findViewById(R.id.optionCEdit);
            optionD = itemView.findViewById(R.id.optionDEdit);
            answer = itemView.findViewById(R.id.answerEdit);
            select = itemView.findViewById(R.id.englishEdit);
        }
    }
}
