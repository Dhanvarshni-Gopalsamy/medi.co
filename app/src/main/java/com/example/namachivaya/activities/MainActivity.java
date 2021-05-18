package com.example.namachivaya.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.namachivaya.R;

public class MainActivity extends AppCompatActivity {
    private static int ZOOM_SCREEN =2000;
    //Variables
    Animation zoom_in;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Animations
        zoom_in= AnimationUtils.loadAnimation(this,R.anim.zoom_in);

        //Hooks
        img=findViewById(R.id.mainlogo);
        img.setAnimation(zoom_in);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent0=new Intent(MainActivity.this, OnBoarding.class);
                startActivity(intent0);
                finish();
            }
        },ZOOM_SCREEN);
    }
}