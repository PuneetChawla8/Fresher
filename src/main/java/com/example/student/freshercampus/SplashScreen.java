package com.example.student.freshercampus;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
     //   getActionBar().setTitle(" ");
        TextView tv=(TextView)findViewById(R.id.tv);
        ImageView tv2=(ImageView)findViewById(R.id.tv2);
        tv2.setTranslationX(-3000f);
        tv.setTranslationY(3000f);
        tv.animate().translationYBy(-3000f).setDuration(2000);
        tv2.animate().translationXBy(3000f).setDuration(2500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getBaseContext(),WelcomeActivity.class);
                startActivity(i);
                finish(); }
        },4000);
    }
}
