package com.example.langfire;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class GetName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
        findViewById(R.id.send2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((EditText) findViewById(R.id.getnm)).getText().toString().matches("")) {
                    alert();
                } else {
                    Intent i = new Intent(GetName.this, WelcomeSc.class);
                    String n1,n2,nam;
                    n1= new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date())+"**"+ new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date())+"**";
                    n2= Integer.toString((int)new GetRandomNum().getRanNum());
                    nam=((EditText)findViewById(R.id.getnm)).getText().toString();
                    i.putExtra("nameid",n1+nam+n2);
                    i.putExtra("name",nam);
                    DataBaseHelper db = new DataBaseHelper(GetName.this);
                    db.setName(nam,nam);
                    startActivity(i);
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

                    finish();
                }

            }
        });
    }
    public void alert()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(GetName.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Enter your Name");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        alertDialog.show();
    }
}
