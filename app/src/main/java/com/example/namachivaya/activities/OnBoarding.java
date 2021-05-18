package com.example.namachivaya.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.namachivaya.R;

public class OnBoarding extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        //navigating to signin
        findViewById(R.id.butsignin).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignInActivity.class)));
        //navigating to signup
        findViewById(R.id.butsignup).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));

    }
}