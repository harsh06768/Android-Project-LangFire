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

public class Cpques extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpques);
        findViewById(R.id.button2p).setOnClickListener(this);
        findViewById(R.id.button21p).setOnClickListener(this);
        findViewById(R.id.button4p).setOnClickListener(this);
        findViewById(R.id.button5p).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button7p).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);

    }
    public void onClick(View v)
    {

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
        }else{

            Intent i;
            switch (v.getId()) {
                case R.id.button2p:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_basic");

                    startActivity(i);
                    break;
                case R.id.button21p:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_oprtr");

                    startActivity(i);
                    break;
                case R.id.button4p:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_array");

                    startActivity(i);
                    break;
                case R.id.button5p:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_classob");

                    startActivity(i);
                    break;
                case R.id.button6:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_consdes");

                    startActivity(i);
                    break;
                case R.id.button7:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_inherit");

                    startActivity(i);
                    break;
                case R.id.button7p:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_poly");

                    startActivity(i);
                    break;
                case R.id.button8:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_olodride");

                    startActivity(i);
                    break;
                case R.id.button9:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_file");

                    startActivity(i);
                    break;
                case R.id.button10:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "cpp");
                    i.putExtra("ref2", "cpp_exception");

                    startActivity(i);
                    break;


            }
            }
    }
}
