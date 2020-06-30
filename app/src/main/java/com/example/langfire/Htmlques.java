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

public class Htmlques extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlques);

        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button21).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button9a).setOnClickListener(this);
        findViewById(R.id.button9b).setOnClickListener(this);
        findViewById(R.id.button9c).setOnClickListener(this);
        findViewById(R.id.button9d).setOnClickListener(this);
        findViewById(R.id.button9e).setOnClickListener(this);
        findViewById(R.id.button9f).setOnClickListener(this);
        findViewById(R.id.button9g).setOnClickListener(this);
        findViewById(R.id.button9h).setOnClickListener(this);
        findViewById(R.id.button9i).setOnClickListener(this);

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
        }else {

            Intent i;
            switch (v.getId()) {
                case R.id.button2:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_basic");
                    startActivity(i);
                    break;


                case R.id.button21:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_elements");
                    startActivity(i);
                    break;
                case R.id.button3:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_attribute");
                    startActivity(i);
                    break;
                case R.id.button4:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_table");
                    startActivity(i);
                    break;
                case R.id.button5:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_lists");
                    startActivity(i);
                    break;
                case R.id.button6:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_forms");
                    startActivity(i);
                    break;
                case R.id.button7:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_lib");
                    startActivity(i);
                    break;
                case R.id.button8:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_favico");
                    startActivity(i);
                    break;
                case R.id.button9:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_video");
                    startActivity(i);
                    break;

                case R.id.button9a:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_audio");
                    startActivity(i);
                    break;

                case R.id.button9b:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_graph");
                    startActivity(i);
                    break;

                case R.id.button9c:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_beyond");
                    startActivity(i);
                    break;

                case R.id.button9d:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_theme");
                    startActivity(i);
                    break;

                case R.id.button9e:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_scvectrgraph");
                    startActivity(i);
                    break;

                case R.id.button9f:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_font");
                    startActivity(i);
                    break;

                case R.id.button9g:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_dragdrop");
                    startActivity(i);
                    break;

                case R.id.button9h:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_geoapi");
                    startActivity(i);
                    break;

                case R.id.button9i:
                    i = new Intent(this, Cbasic.class);
                    i.putExtra("ref1", "html");
                    i.putExtra("ref2", "html_webdb");
                    startActivity(i);
                    break;

            }
        }
    }
}
