package com.ragabaat.ardc.ui.fucltty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ragabaat.ardc.R;

import java.util.ArrayList;
import java.util.List;


public class FaculltyFragment extends Fragment {


    private RecyclerView csDepartment, ChemistryDepartment, phisicDepartment, MechanicalDepartment;
    private LinearLayout csNoData, mechNoData, physicsNoData, ChemistryNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_facullty, container, false);


        ChemistryDepartment = view.findViewById(R.id.ChemistryDepartment);
        ChemistryNoData = view.findViewById(R.id.ChemistryNoData);
        phisicDepartment = view.findViewById(R.id.phisicDepartment);
        physicsNoData = view.findViewById(R.id.physicsNoData);
        MechanicalDepartment = view.findViewById(R.id.MechanicalDepartment);
        mechNoData = view.findViewById(R.id.mechNoData);
        csDepartment = view.findViewById(R.id.csDepartment);
        csNoData = view.findViewById(R.id.csNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        MechanicalDepartment();
        phisicDepartment();
        ChemistryDepartment();


        return view;
    }

    private void csDepartment() {

        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {

                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);

                } else {

                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    csDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void MechanicalDepartment() {

        dbRef = reference.child("Codding");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {

                    mechNoData.setVisibility(View.VISIBLE);
                    MechanicalDepartment.setVisibility(View.GONE);

                } else {

                    mechNoData.setVisibility(View.GONE);
                    MechanicalDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    MechanicalDepartment.setHasFixedSize(true);
                    MechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    MechanicalDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void phisicDepartment() {

        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {

                    physicsNoData.setVisibility(View.VISIBLE);
                    phisicDepartment.setVisibility(View.GONE);

                } else {

                    physicsNoData.setVisibility(View.GONE);
                    phisicDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    phisicDepartment.setHasFixedSize(true);
                    phisicDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    phisicDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void ChemistryDepartment() {

        dbRef = reference.child("Others");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {

                    ChemistryNoData.setVisibility(View.VISIBLE);
                    ChemistryDepartment.setVisibility(View.GONE);

                } else {

                    ChemistryNoData.setVisibility(View.GONE);
                    ChemistryDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    ChemistryDepartment.setHasFixedSize(true);
                    ChemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    ChemistryDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
