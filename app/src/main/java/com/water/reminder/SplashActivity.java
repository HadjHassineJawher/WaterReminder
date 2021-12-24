package com.water.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timer timer;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView img_spalsh= findViewById(R.id.imgv_spalsh);


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        animation.setRepeatCount(Animation.INFINITE);
        img_spalsh.startAnimation((animation));


        timer =new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
               // Toast.makeText(getApplicationContext(), "Welcome to Water Reminder App", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        },1500);



    }
}