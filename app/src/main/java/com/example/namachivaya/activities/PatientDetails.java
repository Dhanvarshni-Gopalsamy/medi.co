package com.example.namachivaya.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.namachivaya.R;
import android.os.Bundle;
import android.view.View;

public class PatientDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        //on pressing back
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}