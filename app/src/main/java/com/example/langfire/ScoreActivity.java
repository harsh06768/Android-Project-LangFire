package com.example.langfire;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class ScoreActivity extends AppCompatActivity {

    private TextView score,total;
    private Button donebtn;
LinearLayout g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score=findViewById(R.id.scored);
        total=findViewById(R.id.outof);
        donebtn=findViewById(R.id.done_btn);

        g=findViewById(R.id.linearLayout);
        if(getIntent().getExtras().get("col").equals("c"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#2a1eff")));
            donebtn.setBackground(new ColorDrawable(Color.parseColor("#2a1eff")));

        }else if(getIntent().getExtras().get("col").equals("cpp"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#00e5ff")));
            donebtn.setBackground(new ColorDrawable(Color.parseColor("#00e5ff")));

        }else if(getIntent().getExtras().get("col").equals("html"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#ff4373")));
            donebtn.setBackground(new ColorDrawable(Color.parseColor("#ff4373")));

        }else if(getIntent().getExtras().get("col").equals("java"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));
            donebtn.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));

        }else if(getIntent().getExtras().get("col").equals("mysql"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));
            donebtn.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));

        }else if(getIntent().getExtras().get("col").equals("python"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#e7bc25")));
            donebtn.setBackground(new ColorDrawable(Color.parseColor("#e7bc25")));

        }


        score.setText(String.valueOf(getIntent().getIntExtra("score",0)));
        int scr=getIntent().getIntExtra("score",0);
         if(scr>0&&scr<5)
        {
            ((GifImageView)findViewById(R.id.button16)).setImageResource(R.drawable.fair);
            ((TextView)findViewById(R.id.textView6)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.textView6)).setText("Fair");
        }else if(scr>4&&scr<8)
        {
            ((GifImageView)findViewById(R.id.button16)).setImageResource(R.drawable.average);
            ((TextView)findViewById(R.id.textView6)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textView6)).setText("Average");
        }else if(scr>7&&scr<10)
        {
            ((GifImageView)findViewById(R.id.button16)).setImageResource(R.drawable.excellent);
            ((TextView)findViewById(R.id.textView6)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textView6)).setText("Excellent");
        }else if(scr==10)
        {
            ((GifImageView)findViewById(R.id.button16)).setImageResource(R.drawable.win);
            ((TextView)findViewById(R.id.textView6)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textView6)).setText("Bingo");
        }else if(scr==0)
         {
             ((GifImageView)findViewById(R.id.button16)).setImageResource(R.drawable.cry);
             ((TextView)findViewById(R.id.textView6)).setTextColor(Color.RED);
             ((TextView)findViewById(R.id.textView6)).setText("Failed");
         }


        donebtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                finish();
            }

        });
    }
}
