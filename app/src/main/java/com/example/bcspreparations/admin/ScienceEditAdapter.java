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

public class ScienceEditAdapter  extends RecyclerView.Adapter<ScienceEditAdapter.Holder> {
    private Context context;
    private List<GetPush> science;

    public ScienceEditAdapter(Context context, List<GetPush> science) {
        this.context = context;
        this.science = science;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_row,parent,false);
        return new ScienceEditAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final GetPush gp = science.get(position);
        holder.questionName.setText("Question-"+ (position+1)+": " +science.get(position).getQuestion());
        holder.optionA.setText("A. "+ science.get(position).getFirstOption());
        holder.optionB.setText("B. "+science.get(position).getSecondOption());
        holder.optionC.setText("C. "+science.get(position).getThirdOption());
        holder.optionD.setText("D. "+science.get(position).getFourthOption());
        holder.answer.setText("Answer: "+science.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return science.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        TextView optionA,optionB,optionC,optionD;
        TextView questionName;
        TextView answer;

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
