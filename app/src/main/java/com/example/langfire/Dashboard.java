package com.example.langfire;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageButton;
import pl.droidsonroids.gif.GifImageView;

public class Dashboard extends AppCompatActivity {
   private GifImageView button;
   GifImageButton button1;
   private long backPressedTime;
   private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        button1=findViewById(R.id.button6);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);

                builder.setIcon(R.mipmap.ic_launcher_warning);
                builder.setCancelable(false);
                builder.setTitle("Exit");
                builder.setMessage("Are you sure, You want to exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Dashboard.this, "You clicked over No", Toast.LENGTH_SHORT).show();

                    }
                });


                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

        button=(GifImageView)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 openChooseLang();

             }

        });
    }


    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 >System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
          backToast= Toast.makeText(getBaseContext(),"Press back again to exit", Toast.LENGTH_SHORT);
          backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }

    public void openChooseLang(){
        Intent intent=new Intent(this, ChooseLang.class);
        startActivity(intent);
    }
    public void clickExit(View v)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);


    }



}
