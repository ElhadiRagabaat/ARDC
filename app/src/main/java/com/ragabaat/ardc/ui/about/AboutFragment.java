package com.ragabaat.ardc.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ragabaat.ardc.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

private ViewPager viewPager;
private BranchAdapter adapter;
private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_about, container, false);


       list = new ArrayList<>();
       list.add(new BranchModel(R.drawable.ic__computer,"Codding","six-week long pre-course that teaches relevant coding skills and identifies high-potential candidates with the relevant skill-sets, language skills, motivation, and dedication to succeed.."));
       list.add(new BranchModel(R.drawable.ic__computer,"Economic","The ARDC firmly believes in the value of vocational education and training. For asylum-seekers in Israel, learning practical skills at a high level opens many doors for employment opportunities which otherwise would be inaccessible. Additionally,"));


       list.add(new BranchModel(R.drawable.ic_cod," educational program","ARDC's educational program is the core of our activity. The program aims to strengthen the capacity and autonomy of African asylum seekers in Israel through education, training, professional guidance and action toward a more dignified life."));
       list.add(new BranchModel(R.drawable.ic_baseline_group_24," COMMUNITY ",
               "Every month, members of ARDC Community Engagement team travel to cities around Israel in order to meet and engage with asylum seekers who are not able to easily access our community center in Tel Aviv."));

       adapter = new BranchAdapter(getContext(),list);
       viewPager = view.findViewById(R.id.viewPager);
       viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/gallery%2F%5BB%401d0bcbdjpg?alt=media&token=ebe24fb9-623b-456c-a008-cda6f1320cea")
                .into(imageView);

       return view;
    }
}