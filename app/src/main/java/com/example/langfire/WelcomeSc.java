package com.example.langfire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class WelcomeSc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_sc);
        FirebaseOptions op =  new FirebaseOptions.Builder()

                .setApplicationId("1:973213571697:android:aa72f9a2537f3d005359d0") // Required for Analytics.

                .setApiKey("AIzaSyBx-uQR9DCq-63woYVutBcxi8MDv9WBz1s") // Required for Auth.

                .setDatabaseUrl("https://lang-fire-ddb3c.firebaseio.com/") // Required for RTDB.

                .build();
        //  FirebaseApp.initializeApp(this,op,"secondary");
        boolean hasBeenInitialized = false;
        List<FirebaseApp> fbsLcl = FirebaseApp.getApps(WelcomeSc.this);
        for (FirebaseApp app : fbsLcl) {
            if (app.getName().equals("secondary")) {
                hasBeenInitialized = true;
            }
        }
        FirebaseApp  fbApp,app;
        if (!hasBeenInitialized)
            fbApp = FirebaseApp.initializeApp(WelcomeSc.this, op, "secondary");
        else
            fbApp = FirebaseApp.getInstance("secondary");

        /*
        FirebaseApp myApp = FirebaseApp.initializeApp(this,op,
                "secondary");
        FirebaseApp app = myApp.getInstance("secondary");
*/

// Get the database for the other app.
        FirebaseDatabase secondaryDatabase = FirebaseDatabase.getInstance(fbApp);
        DatabaseReference myRef=secondaryDatabase.getReference("Name");
        String nam=getIntent().getExtras().getString("name");
        String sn[]=nam.split(" ");
        ((TextView)findViewById(R.id.welt)).setText("Welcome , "+sn[0]);
        if (isConnected())
        {
            myRef.child(getIntent().getExtras().getString("nameid")).setValue("Done");
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeSc.this,SideBarDashBoard.class));
                finish();
            }
        },2500);

    }
    public boolean isConnected()
    {
        ConnectivityManager c=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo n = c.getActiveNetworkInfo();
        return n!=null && n.isConnected();
    }
}
