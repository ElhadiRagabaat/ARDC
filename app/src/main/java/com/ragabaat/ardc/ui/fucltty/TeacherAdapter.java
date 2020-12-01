package com.ragabaat.ardc.ui.fucltty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.ragabaat.ardc.FullImageView;
import com.ragabaat.ardc.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private List<com.ragabaat.ardc.ui.fucltty.TeacherData> list;
    private Context context;


    public TeacherAdapter(List<com.ragabaat.ardc.ui.fucltty.TeacherData> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {

        com.ragabaat.ardc.ui.fucltty.TeacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.emil.setText(item.getEmail());
        holder.post.setText(item.getPost());


        try {
            Picasso.get().load(item.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image",list.get(position).getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {


        private TextView name, emil, post;

        private CircleImageView imageView;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            emil = itemView.findViewById(R.id.teacherEmail);
            post = itemView.findViewById(R.id.teacherPost);

            imageView = itemView.findViewById(R.id.teacherImage);
        }
    }

}
