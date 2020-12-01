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
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/gallery%2F%5BB%40e28f12ejpg?alt=media&token=f064ccf5-91ca-4834-b420-361599bfa278");
                    break;

                case 1 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/gallery%2F%5BB%40dc0685cjpg?alt=media&token=7594ad95-04b4-4637-b735-7d00cb089ef6");
                    break;


                case 3 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/gallery%2F%5BB%40c32e218jpg?alt=media&token=c49e4376-d2b0-43d4-b253-e25c2aa3967b");
                    break;

                case 4 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollage.appspot.com/o/gallery%2F%5BB%401d0bcbdjpg?alt=media&token=ebe24fb9-623b-456c-a008-cda6f1320cea");
                    break;

            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderViewl.addSliderView(sliderView);



        }
    }
}