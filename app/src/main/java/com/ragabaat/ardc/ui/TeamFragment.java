package com.ragabaat.ardc.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ragabaat.ardc.R;
import com.ragabaat.ardc.TeamAdapter;
import com.ragabaat.ardc.TeamData;
import com.ragabaat.ardc.ui.notice.NoticeAdapter;
import com.ragabaat.ardc.ui.notice.NoticeData;

import java.util.ArrayList;

public class TeamFragment extends Fragment {


    private RecyclerView teacherRecycler;
    private ProgressBar progressBar;
    private DatabaseReference reference;

    private ArrayList<TeamData> list;
    private TeamAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_team, container, false);

         progressBar= view.findViewById(R.id.progressBar1);
         teacherRecycler = view.findViewById(R.id.teamRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("team");


        getData();

         return view;

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
                adapter = new TeamAdapter(list, getActivity());
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
               teacherRecycler.setAdapter(adapter);





            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
}