package com.example.bcspreparations.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.R;

import java.util.List;

public class GeneralKnowledgeEditAdapter extends RecyclerView.Adapter<GeneralKnowledgeEditAdapter.Holder> {
    private Context context;
    private List<GetPush> gk;

    public GeneralKnowledgeEditAdapter(Context context, List<GetPush> gk) {
        this.context = context;
        this.gk = gk;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_row,parent,false);
        return new GeneralKnowledgeEditAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final GetPush gp = gk.get(position);
        holder.questionName.setText("Question-"+ (position+1)+": " +gk.get(position).getQuestion());
        holder.optionA.setText("A. "+ gk.get(position).getFirstOption());
        holder.optionB.setText("B. "+gk.get(position).getSecondOption());
        holder.optionC.setText("C. "+gk.get(position).getThirdOption());
        holder.optionD.setText("D. "+gk.get(position).getFourthOption());
        holder.answer.setText("Answer: "+gk.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return gk.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView optionA,optionB,optionC,optionD, questionName, answer;
        private Holder(@NonNull View itemView) {
            super(itemView);
            questionName=itemView.findViewById(R.id.questionNameEdit);
            optionA = itemView.findViewById(R.id.optionAEdit);
            optionB = itemView.findViewById(R.id.optionBEdit);
            optionC = itemView.findViewById(R.id.optionCEdit);
            optionD = itemView.findViewById(R.id.optionDEdit);
            answer = itemView.findViewById(R.id.answerEdit);
        }
    }
}
