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

public class ICTEditAdapter extends RecyclerView.Adapter<ICTEditAdapter.Holder> {
    private Context context;
    private List<GetPush> ict;

    public ICTEditAdapter(Context context, List<GetPush> ict) {
        this.context = context;
        this.ict = ict;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_row,parent,false);
        return new ICTEditAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final GetPush gp = ict.get(position);
        holder.questionName.setText("Question-"+ (position+1)+": " +ict.get(position).getQuestion());
        holder.optionA.setText("A. "+ ict.get(position).getFirstOption());
        holder.optionB.setText("B. "+ict.get(position).getSecondOption());
        holder.optionC.setText("C. "+ict.get(position).getThirdOption());
        holder.optionD.setText("D. "+ict.get(position).getFourthOption());
        holder.answer.setText("Answer: "+ict.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return ict.size();
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
