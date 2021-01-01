package com.example.bcspreparations.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.bcspreparations.GetPush;
import com.example.bcspreparations.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GeneralKnowledgeEdit extends AppCompatActivity {
    private DatabaseReference rootRef;
    private DatabaseReference gkRef;
    private List<GetPush> gk = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GeneralKnowledgeEditAdapter adapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowladge_edit);
        recyclerView = findViewById(R.id.gkModelTestEdit);
        context=this;
        rootRef = FirebaseDatabase.getInstance().getReference();
        gkRef = rootRef.child("GeneralKnowledge");
        gkRef.keepSynced(true);

        gkRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                gk.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    GetPush e = d.getValue(GetPush.class);
                    gk.add(e);
                }
                gkRef.getDatabase();
                layoutManager=new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                adapter=new GeneralKnowledgeEditAdapter(context,gk);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
