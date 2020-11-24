package com.ragabaat.ardc.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ragabaat.ardc.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {

private SliderLayout sliderViewl;
private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_home, container, false);

       sliderViewl = view.findViewById(R.id.slider);
       sliderViewl.setIndicatorAnimation(IndicatorAnimations.FILL);
       sliderViewl.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
       sliderViewl.setScrollTimeInSec(1);



       setSliderViews();
       map = view .findViewById(R.id.map);
       map.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               openMap();
           }
       });

       return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Tel-Aviv");
        Intent intent  = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);

    }

    private void setSliderViews() {

        for (int i = 0; i < 5; i++){

            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){

                case 0 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/Notice%2F%5BB%4072dd32jpg?alt=media&token=89ccda03-fa8d-4683-b7ff-4a052b9b8835");
                    break;

                case 1 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/Notice%2F%5BB%4075b2801jpg?alt=media&token=08619e09-040c-4e3b-9e9d-e8a9d3164a1e");
                    break;


                case 3 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/Notice%2F%5BB%408acf0d3jpg?alt=media&token=a77f06b1-283e-4f3e-a2a5-d1f21e03e3a4");
                    break;

                case 4 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/Notice%2F%5BB%4096b190cjpg?alt=media&token=330c8f8d-d090-43ab-8425-508190689cf6");
                    break;

            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderViewl.addSliderView(sliderView);
        }
    }
}