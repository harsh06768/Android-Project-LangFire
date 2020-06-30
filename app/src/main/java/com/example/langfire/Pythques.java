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

public class Pythques extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pythques);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button2d).setOnClickListener(this);
        findViewById(R.id.button21).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button10c).setOnClickListener(this);
        findViewById(R.id.button10t).setOnClickListener(this);
        findViewById(R.id.button10f).setOnClickListener(this);
        findViewById(R.id.button10r).setOnClickListener(this);
        findViewById(R.id.button10s).setOnClickListener(this);


    }

    @Override
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
        }else
        {

            Intent i;
            switch (v.getId()) {
                case R.id.button2:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_basic");
                    startActivity(i);
                    break;
                case R.id.button2d:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_datatypes");
                    startActivity(i);
                    break;

                //***************************
                case R.id.button21:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_operator");
                    startActivity(i);
                    break;

                case R.id.button3:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_ifelse");
                    startActivity(i);
                    break;

                case R.id.button4:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_loops");
                    startActivity(i);
                    break;

                case R.id.button5:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_strings");
                    startActivity(i);
                    break;

                case R.id.button6:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_functions");
                    startActivity(i);
                    break;

                case R.id.button7:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_list");
                    startActivity(i);
                    break;

                case R.id.button8:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_tuple");
                    startActivity(i);
                    break;

                case R.id.button9:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_sets");
                    startActivity(i);
                    break;

                case R.id.button10:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_dict");
                    startActivity(i);
                    break;

                case R.id.button10c:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_classobj");
                    startActivity(i);
                    break;

                case R.id.button10t:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_tryexcept");
                    startActivity(i);
                    break;

                case R.id.button10f:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_file");
                    startActivity(i);
                    break;

                case R.id.button10r:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_regexp");
                    startActivity(i);
                    break;

                case R.id.button10s:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "python");
                    i.putExtra("ref2", "py_strformate");
                    startActivity(i);
                    break;


            }
            }
    }
}
