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

public class EnglishEdit extends AppCompatActivity {
    private DatabaseReference rootRef;
    private DatabaseReference englishRef;
    private List<GetPush> english = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private EnglishEditAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_edit);
        recyclerView = findViewById(R.id.englishModelTestEdit);
        context=this;
        rootRef = FirebaseDatabase.getInstance().getReference();
        englishRef = rootRef.child("English");
        englishRef.keepSynced(true);

        englishRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                english.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    GetPush e = d.getValue(GetPush.class);
                    english.add(e);
                }
                englishRef.getDatabase();
                layoutManager=new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                adapter=new EnglishEditAdapter(context,english);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
