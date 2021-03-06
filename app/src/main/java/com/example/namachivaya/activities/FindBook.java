package com.example.namachivaya.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.namachivaya.R;

public class FindBook extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_book);
        //navigation
        findViewById(R.id.bookvideoconsult).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SelectTime.class)));

        //on pressing back
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}