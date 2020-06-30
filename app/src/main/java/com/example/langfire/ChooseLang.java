package com.example.langfire;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseLang extends AppCompatActivity implements View.OnClickListener{
//private DrawerLayout drawer;
Button bt,bt1,bt2,bt3,bt4,bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langchoose);
        bt=(Button) findViewById(R.id.buttonC);
         bt1=(Button) findViewById(R.id.buttonCplus);
         bt2=(Button) findViewById(R.id.buttonjava);
         bt3=(Button) findViewById(R.id.buttonpython);
        bt4=(Button) findViewById(R.id.buttonsql);
        bt5=(Button) findViewById(R.id.buttonhtml);

        bt.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);


        //Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       // drawer=findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
      //  drawer.addDrawerListener(toggle);
      //  toggle.syncState();


    }

    @Override
 //  public void onBackPressed() {
       // if(drawer.isDrawerOpen(GravityCompat.START)){
           // drawer.closeDrawer(GravityCompat.START);
      //  }else{
      //  super.onBackPressed();
       // }
   // }

    public void onClick(View v){

    Intent i;

    switch(v.getId()){
        case R.id.buttonC: i = new Intent(this, Cques.class);startActivity(i);break;
        case R.id.buttonCplus: i = new Intent(this, Cpques.class);startActivity(i);break;
        case R.id.buttonjava: i = new Intent(this, JavaQues.class);startActivity(i);break;
        case R.id.buttonpython: i = new Intent(this, Pythques.class);startActivity(i);break;
        case R.id.buttonsql: i = new Intent(this, Sqlques.class);startActivity(i);break;
        case R.id.buttonhtml: i = new Intent(this, Htmlques.class);startActivity(i);break;
        default:break;


    }


    }



}
