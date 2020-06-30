package com.example.langfire;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cbasic extends AppCompatActivity {

    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference();
    public LinearLayout g;



public Button bt1,bt2;
private TextView vquestion,vnumber,timer;
private LinearLayout voptions;
private Button vnext;
private int count=0;
private List<QuestionModel> list;
private int position=0;
private int score=0;
private static final long START_TIME=60000;
private CountDownTimer mCountDownTimer;
private boolean mTimerRunning;
private long mTimeLeft=START_TIME;
private Dialog loadingDialog;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbasic);

        bt1=findViewById(R.id.button2);
        bt2=findViewById(R.id.button21);
        vquestion=findViewById(R.id.question);
        vnumber=findViewById(R.id.number);
        timer=findViewById(R.id.timex);
        voptions=findViewById(R.id.options);
        vnext=findViewById(R.id.next);
        g=findViewById(R.id.linearLayout);

        if(getIntent().getExtras().get("ref1").equals("c"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#2a1eff")));
            vnext.setBackground(new ColorDrawable(Color.parseColor("#2a1eff")));

        }else if(getIntent().getExtras().get("ref1").equals("cpp"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#00e5ff")));
            vnext.setBackground(new ColorDrawable(Color.parseColor("#00e5ff")));

        }else if(getIntent().getExtras().get("ref1").equals("html"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#ff4373")));
            vnext.setBackground(new ColorDrawable(Color.parseColor("#ff4373")));

        }else if(getIntent().getExtras().get("ref1").equals("java"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));
            vnext.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));

        }else if(getIntent().getExtras().get("ref1").equals("mysql"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));
            vnext.setBackground(new ColorDrawable(Color.parseColor("#ff6107")));

        }else if(getIntent().getExtras().get("ref1").equals("python"))
        {
            g.setBackground(new ColorDrawable(Color.parseColor("#e7bc25")));
            vnext.setBackground(new ColorDrawable(Color.parseColor("#e7bc25")));

        }


        FirebaseOptions op =  new FirebaseOptions.Builder()

                .setApplicationId("1:973213571697:android:aa72f9a2537f3d005359d0") // Required for Analytics.

                .setApiKey("AIzaSyBx-uQR9DCq-63woYVutBcxi8MDv9WBz1s") // Required for Auth.

                .setDatabaseUrl("https://lang-fire-ddb3c.firebaseio.com/") // Required for RTDB.

                .build();
      //  FirebaseApp.initializeApp(this,op,"secondary");
        boolean hasBeenInitialized = false;
        List<FirebaseApp> fbsLcl = FirebaseApp.getApps(this);
        for (FirebaseApp app : fbsLcl) {
            if (app.getName().equals("secondary")) {
                hasBeenInitialized = true;
            }
        }
        FirebaseApp  fbApp,app;
        if (!hasBeenInitialized)
           fbApp = FirebaseApp.initializeApp(this, op, "secondary");
        else
            fbApp = FirebaseApp.getInstance("secondary");

        /*
        FirebaseApp myApp = FirebaseApp.initializeApp(this,op,
                "secondary");
        FirebaseApp app = myApp.getInstance("secondary");
*/

// Get the database for the other app.
        FirebaseDatabase secondaryDatabase = FirebaseDatabase.getInstance(fbApp);
        myRef=secondaryDatabase.getReference();


            //loading dialog code

            loadingDialog = new Dialog(this);
            loadingDialog.setContentView(R.layout.loading);
            loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            loadingDialog.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            loadingDialog.setCancelable(false);

            //stopwatch  function call



            // retriveing data from server code
            list = new ArrayList<>();
            loadingDialog.show();

            myRef.child(getIntent().getExtras().getString("ref1")).child(getIntent().getExtras().getString("ref2")).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        String id = dataSnapshot1.getKey();
                        String question = dataSnapshot1.child("question").getValue().toString();
                        String a = dataSnapshot1.child("option1").getValue().toString();
                        String b = dataSnapshot1.child("option2").getValue().toString();
                        String c = dataSnapshot1.child("option3").getValue().toString();
                        String d = dataSnapshot1.child("option4").getValue().toString();
                        String correctANS = dataSnapshot1.child("answer").getValue().toString();
                        list.add(new QuestionModel(id, question, a, b, c, d, correctANS));
                    }


                    if (list.size() > 0) {
                        for (int i = 0; i < 4; i++) {
                            voptions.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                @Override
                                public void onClick(View v) {
                                    checkAnswer((Button) v);

                                }
                            });

                        }

                        // on next click question change animation code
                        startTimer();
                        playAnim(vquestion, 0, list.get(position).getQuestion());
                        vnext.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            public void onClick(View v) {
                                mTimeLeft = START_TIME;
                                updateCountDownText();
                                mCountDownTimer.cancel();
                                startTimer();
                                vnext.setEnabled(false);
                                vnext.setAlpha(0.7f);
                                enableOption(true);
                                position++;
                                if (position == list.size()) {
                                    //score activity

                                    Intent scoreIntent = new Intent(Cbasic.this, ScoreActivity.class);
                                    scoreIntent.putExtra("score", score);
                                    scoreIntent.putExtra("total", list.size());
                                    scoreIntent.putExtra("col",getIntent().getExtras().get("ref1").toString());
                                    startActivity(scoreIntent);
                                    finish();
                                    return;
                                }
                                count = 0;
                                playAnim(vquestion, 0, list.get(position).getQuestion());

                            }

                        });

                    } else {
                        finish();
                        Toast.makeText(Cbasic.this, "No Questions", Toast.LENGTH_SHORT).show();
                    }
                    loadingDialog.dismiss();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Cbasic.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    loadingDialog.dismiss();
                    finish();

                }
            });

        /*           myRef.child("JAVA").child("javabasic").child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                           for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                               //list.add(snapshot.getValue(QuestionModel.class));
                               //list.add(snapshot.getValue(QuestionModel.class));
                               //list.add(snapshot.getValue(QuestionModel.class));
                               String id = dataSnapshot1.getKey();
                               String question = dataSnapshot1.child("question").getValue().toString();
                               String a = dataSnapshot1.child("optionA").getValue().toString();
                               String b = dataSnapshot1.child("optionB").getValue().toString();
                               String c = dataSnapshot1.child("optionC").getValue().toString();
                               String d = dataSnapshot1.child("optionD").getValue().toString();
                               String correctANS = dataSnapshot1.child("correctANS").getValue().toString();

                               list.add(new QuestionModel(id, question, a, b, c, d, correctANS));


                           }
                           if (list.size() > 0) {
                               for (int i = 0; i < 4; i++) {
                                   voptions.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           checkAnswer((Button) v);

                                       }
                                   });

                               }
                               // on next click question change animation code
                               playAnim(vquestion, 0, list.get(position).getQuestion());
                               vnext.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       mTimeLeft = START_TIME;
                                       updateCountDownText();
                                       mCountDownTimer.cancel();
                                       startTimer();
                                       vnext.setEnabled(false);
                                       vnext.setAlpha(0.7f);
                                       enableOption(true);
                                       position++;
                                       if (position == list.size()) {
                                           //score activity

                                           Intent scoreIntent = new Intent(Cbasic.this, ScoreActivity.class);
                                           scoreIntent.putExtra("score", score);
                                           scoreIntent.putExtra("total", list.size());
                                           startActivity(scoreIntent);
                                           finish();
                                           return;
                                       }
                                       count = 0;
                                       playAnim(vquestion, 0, list.get(position).getQuestion());

                                   }

                               });

                           } else {
                               finish();
                               Toast.makeText(Cbasic.this, "No Questions", Toast.LENGTH_SHORT).show();
                           }
                           loadingDialog.dismiss();
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError databaseError) {
                           Toast.makeText(Cbasic.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                           loadingDialog.dismiss();
                           finish();

                       }
                   }); */


            // playAnim(vquestion,0,list.get(position).getQuestion());

            updateCountDownText();


    }
      // animation code
    private void playAnim(final View view, final int value, final String data)
     {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                    .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if(value == 0 && count<4 )
                {

                    String option="";

                    if(count==0){

                        option=list.get(position).getOptionA();

                    }else if(count==1){
                        option=list.get(position).getOptionB();
                    }else if(count==2) {
                        option=list.get(position).getOptionC();
                    }else if (count==3){
                        option=list.get(position).getOptionD();
                    }


                    playAnim(voptions.getChildAt(count),0,option);
                    count++;
                }


            }

            @Override
            public void onAnimationEnd(Animator animation) {


                   if(value == 0){
                       try{
                           ((TextView)view).setText(data);
                           vnumber.setText(position+1+"/"+list.size());


                       }catch (ClassCastException e){
                           ((Button)view).setText(data);
                       }
                       view.setTag(data);
                       playAnim(view,1,data);

                   }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

         @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
         private void checkAnswer(Button selectOption)
       {
           enableOption(false);
           vnext.setEnabled(true);
           vnext.setAlpha(1);
           if(selectOption.getText().toString().equals(list.get(position).getCorrectANS())){
               //correct
               score++;
               selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));


           }else{
               //incorrect
               selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
               Button correctOption=(Button) voptions.findViewWithTag(list.get(position).getCorrectANS());
               correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
           }

        }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void enableOption(boolean enable){
            for(int i=0;i<4; i++){
            voptions.getChildAt(i).setEnabled(enable);
            if(enable){
                voptions.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }

            }
        }

       // stopwatch code

    private void startTimer(){
        mCountDownTimer=new CountDownTimer(mTimeLeft,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft=millisUntilFinished;
                updateCountDownText();
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFinish() {
               // public void onClick(View v){
                    mTimeLeft=START_TIME;
                    updateCountDownText();
                    mCountDownTimer.cancel();
                    startTimer();
                    vnext.setEnabled(false);
                    vnext.setAlpha(0.7f);
                    enableOption(true);
                    position++;
                    if(position== list.size()){
                        //score activity
                        return;
                    }
                    count=0;
                    playAnim(vquestion, 0,list.get(position).getQuestion());

               // }

                //mTimerRunning=false;
                //mTimeLeft=0;
                //updateCountDownText();
               // mCountDownTimer.cancel();
            }
        }.start();
        mTimerRunning=true;


    }
    private void updateCountDownText(){
        int minutes=(int) (mTimeLeft/1000)/60;
        int seconds=(int) (mTimeLeft/1000)%60;

        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timer.setText(timeLeftFormatted);
    }

    // private void resetTimer(){

        //mTimeLeft=START_TIME;
       // updateCountDownText();


     //}


// on click button server code fetch test
    /*
View.OnClickListener listener=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(v.equals(bt2)){
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child("JAVA/ifelse").hasChildren()){
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            //list.add(snapshot.getValue(QuestionModel.class));
                            //list.add(snapshot.getValue(QuestionModel.class));
                            //list.add(snapshot.getValue(QuestionModel.class));
                            String id = dataSnapshot1.getKey();
                            String question = dataSnapshot1.child("question").getValue().toString();
                            String a = dataSnapshot1.child("optionA").getValue().toString();
                            String b = dataSnapshot1.child("optionB").getValue().toString();
                            String c = dataSnapshot1.child("optionC").getValue().toString();
                            String d = dataSnapshot1.child("optionD").getValue().toString();
                            String correctANS = dataSnapshot1.child("correctANS").getValue().toString();

                            list.add(new QuestionModel(id, question, a, b, c, d, correctANS));


                        }
                        if (list.size() > 0) {
                            for (int i = 0; i < 4; i++) {
                                voptions.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        checkAnswer((Button) v);

                                    }
                                });

                            }
                            // on next click question change animation code
                            playAnim(vquestion, 0, list.get(position).getQuestion());
                            vnext.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    mTimeLeft = START_TIME;
                                    updateCountDownText();
                                    mCountDownTimer.cancel();
                                    startTimer();
                                    vnext.setEnabled(false);
                                    vnext.setAlpha(0.7f);
                                    enableOption(true);
                                    position++;
                                    if (position == list.size()) {
                                        //score activity

                                        Intent scoreIntent = new Intent(Cbasic.this, ScoreActivity.class);
                                        scoreIntent.putExtra("score", score);
                                        scoreIntent.putExtra("total", list.size());
                                        startActivity(scoreIntent);
                                        finish();
                                        return;
                                    }
                                    count = 0;
                                    playAnim(vquestion, 0, list.get(position).getQuestion());

                                }

                            });

                        } else {
                            finish();
                            Toast.makeText(Cbasic.this, "No Questions", Toast.LENGTH_SHORT).show();
                        }
                        loadingDialog.dismiss();
                    }


                    }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Cbasic.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                loadingDialog.dismiss();
                finish();
                }
            });


        }
    }

 //end of view click listener
}; */
//appcomapat activty end curlybrace
 }
