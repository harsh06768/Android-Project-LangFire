package com.example.langfire;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Button;

public class JavaQues extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_ques);

        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button21).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button3t).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button8e).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button10r).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);
        findViewById(R.id.button12s).setOnClickListener(this);




    }
    public void onClick(View v) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

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
        }else {

            Intent i;
            switch (v.getId()) {
                case R.id.button2:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_basic");
                    startActivity(i);
                    break;
                case R.id.button21:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_datatype");
                    startActivity(i);
                    break;
                case R.id.button3:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_array");
                    startActivity(i);
                    break;
                case R.id.button3t:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_typcst");
                    startActivity(i);
                    break;
                case R.id.button4:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_string");
                    startActivity(i);
                    break;
                case R.id.button5:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_classobj");
                    startActivity(i);
                    break;
                    //*******************
                case R.id.button6:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_modi");
                    startActivity(i);
                    break;
                case R.id.button7:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_abstract");
                    startActivity(i);
                    break;
                case R.id.button8:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_inherit");
                    startActivity(i);
                    break;
                case R.id.button8e:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_encapsul");
                    startActivity(i);
                    break;
                case R.id.button9:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_interface");
                    startActivity(i);
                    break;
                case R.id.button10:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_pkg");
                    startActivity(i);
                    break;
                case R.id.button10r:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_wrapper");
                    startActivity(i);
                    break;
                case R.id.button11:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_exception");
                    startActivity(i);
                    break;

                    case R.id.button12:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_multithread");
                    startActivity(i);
                    break;

                    case R.id.button12s:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "java");
                    i.putExtra("ref2", "java_swing");
                    startActivity(i);
                    break;
            }
        }
            }
}
