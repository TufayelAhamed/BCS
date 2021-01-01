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

public class ICTEdit extends AppCompatActivity {
    private DatabaseReference rootRef;
    private DatabaseReference ictRef;
    private List<GetPush> ict = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ICTEditAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ictedit);
        recyclerView = findViewById(R.id.ictModelTestEdit);
        context=this;
        rootRef = FirebaseDatabase.getInstance().getReference();
        ictRef = rootRef.child("ICT");
        ictRef.keepSynced(true);

        ictRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ict.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    GetPush e = d.getValue(GetPush.class);
                    ict.add(e);
                }
                ictRef.getDatabase();
                layoutManager=new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                adapter=new ICTEditAdapter(context,ict);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
