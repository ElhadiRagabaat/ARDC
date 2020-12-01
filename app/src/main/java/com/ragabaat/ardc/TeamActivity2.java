package com.ragabaat.ardc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeamActivity2 extends AppCompatActivity {



    private RecyclerView teacherRecycler;
    private ProgressBar progressBar;
    private DatabaseReference reference;

    private ArrayList<TeamData> list;
    private TeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team2);

        progressBar = findViewById(R.id.progressBar1);
        teacherRecycler =findViewById(R.id.teamRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("team");


        getData();

    }

    private void getData() {


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list = new ArrayList<>();

                for (DataSnapshot snapshot : datasnapshot.getChildren()) {

                    TeamData data = snapshot.getValue(TeamData.class);
                    list.add(0,data);


                }
                adapter = new TeamAdapter(list, TeamActivity2.this);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

                teacherRecycler.setLayoutManager(new LinearLayoutManager(TeamActivity2.this));
                teacherRecycler.setAdapter(adapter);





            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(TeamActivity2.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
}