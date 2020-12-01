package com.ragabaat.ardc.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.github.barteksc.pdfviewer.PDFView;
import com.ragabaat.ardc.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfViewActivity extends AppCompatActivity {

   private String url;
   private PDFView pdfView;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);


        pdfView = findViewById(R.id.pdfView);
        url = getIntent().getStringExtra("pdfUrl");
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        linearLayout = findViewById(R.id.shimmer_layout);



        new PdfDownload().execute(url);



    }
    private  class PdfDownload extends AsyncTask<String,Void, InputStream>{


        @Override
        protected InputStream doInBackground(String... strings) {

            InputStream inputStream = null;

            try {

                URL url = new URL(strings[0]);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                if (urlConnection.getResponseCode() == 200){

                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                }

            } catch (IOException e) {
                e.printStackTrace();
            }



            return inputStream;




        }



        @Override
        protected void onPostExecute(InputStream inputStream) {



            pdfView.fromStream(inputStream).load();


            //// shimmer anim
            shimmerFrameLayout.stopShimmer();
            linearLayout.setVisibility(View.GONE);


        }


    }




}