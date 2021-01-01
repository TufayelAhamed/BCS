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

public class BanglaEditAdapter extends RecyclerView.Adapter<BanglaEditAdapter.Holder> {
    private Context context;
    private List<GetPush> bangla;
    public BanglaEditAdapter(Context context, List<GetPush> bangla) {
        this.context = context;
        this.bangla = bangla;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_row,parent,false);
        return new BanglaEditAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        final GetPush gp = bangla.get(position);
        holder.questionName.setText("Question-"+ (position+1)+": " +bangla.get(position).getQuestion());
        holder.optionA.setText("A. "+ bangla.get(position).getFirstOption());
        holder.optionB.setText("B. "+bangla.get(position).getSecondOption());
        holder.optionC.setText("C. "+bangla.get(position).getThirdOption());
        holder.optionD.setText("D. "+bangla.get(position).getFourthOption());
        holder.answer.setText("Answer: "+bangla.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return bangla.size();
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
