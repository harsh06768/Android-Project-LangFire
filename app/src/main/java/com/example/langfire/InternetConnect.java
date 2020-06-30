package com.example.langfire;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class InternetConnect extends AppCompatActivity {

    //WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_connect);

        //webView=findViewById(R.id.web);

       // WebSettings webSettings=webView.getSettings();
        //webSettings.setJavaScriptEnabled(true);

        ConnectivityManager connectivityManager=(ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if(networkInfo==null || !networkInfo.isConnected() || !networkInfo.isAvailable()){

            Dialog dialog=new Dialog(this);
            dialog.setContentView(R.layout.internet_alert);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations=android.R.style.Animation_Dialog;
            Button bttryagain=dialog.findViewById(R.id.tryagain);

            bttryagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    recreate();
                }
            });

            dialog.show();
        }
        //else {

          //  webView.loadUrl("https://m.youtube.com");
        //}


    }
}
