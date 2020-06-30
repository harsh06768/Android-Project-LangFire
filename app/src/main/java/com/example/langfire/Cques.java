package com.example.langfire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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

public class Cques extends AppCompatActivity implements View.OnClickListener {
    Button bt,bt1;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cques);

        bt=(Button) findViewById(R.id.button2);
        bt1=(Button) findViewById(R.id.button21);
        bt.setOnClickListener(this);
        bt1.setOnClickListener(this);
        findViewById(R.id.buttond).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
    }

    public void onClick(View v) {

        //no internet connection code
        ConnectivityManager connectivityManager=(ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()) {


            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.internet_alert);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
            Button bttryagain = dialog.findViewById(R.id.tryagain);

            bttryagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
recreate();

                }
            });

            dialog.show();
        }else
        {
            Intent i;
            switch (v.getId()) {
                case R.id.button2:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_basic");

                    startActivity(i);
                    break;

                case R.id.button21:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_ifelse");

                    startActivity(i);
                    break;
                case R.id.buttond:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_datatypes");

                    startActivity(i);
                    break;
                case R.id.button4:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_loops");

                    startActivity(i);
                    break;
                case R.id.button5:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_functions");

                    startActivity(i);
                    break;
                case R.id.button6:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_array");

                    startActivity(i);
                    break;


                case R.id.button7:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_string");

                    startActivity(i);
                    break;


                case R.id.button8:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_pointer");

                    startActivity(i);
                    break;

                case R.id.button10:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_struni");

                    startActivity(i);
                    break;
                case R.id.button11:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1","c");
                    i.putExtra("ref2","c_file");

                    startActivity(i);
                    break;



            }
        }



    }

    }


