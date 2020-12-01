package com.ragabaat.ardc.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ragabaat.ardc.R;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {


    RecyclerView convoRecyclerView,otherRecyclerView;
    GalleryAdapter galleryAdapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRecyclerView = view.findViewById(R.id.convoRecyclerView);
       otherRecyclerView = view.findViewById(R.id.otherRecyclerView);

       reference = FirebaseDatabase.getInstance().getReference().child("gallery");

       getConvoImage();

       getOtherImage();


        return view;
    }

    private void getOtherImage() {

        reference.child("Other Event").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<String>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for (DataSnapshot snapshot : datasnapshot.getChildren()){


                    String data ;
                    data = String.valueOf(snapshot.getValue());

                    imageList.add(data);
                }

                galleryAdapter = new GalleryAdapter(getContext(),imageList);
                otherRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

                otherRecyclerView.setAdapter(galleryAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getConvoImage() {



        reference.child("Graduating").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<String>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for (DataSnapshot snapshot : datasnapshot.getChildren()){


                    String  data ;

                        data = String.valueOf(snapshot.getValue());



                    imageList.add(data);
                }

                galleryAdapter = new GalleryAdapter(getContext(),imageList);
                convoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

                convoRecyclerView.setAdapter(galleryAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}