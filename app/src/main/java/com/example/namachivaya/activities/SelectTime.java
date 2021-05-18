package com.example.namachivaya.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.namachivaya.R;
import com.example.namachivaya.activities.HelperClasses.DateslotAdapter;
import com.example.namachivaya.activities.HelperClasses.DateslotHelperClass;


import java.util.ArrayList;

public class SelectTime extends AppCompatActivity {
    //variables
    RecyclerView dateslotRecycler;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);
        //navigation
        findViewById(R.id.patientdetails).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PatientDetails.class)));

        //on pressing back
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //hooks
        dateslotRecycler=findViewById(R.id.date_recycler);
        dateslotRecycler();

    }
    private void dateslotRecycler(){
        dateslotRecycler.setHasFixedSize(true);
        dateslotRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<DateslotHelperClass> dateslotLocations = new ArrayList<>();
        //driver code
        dateslotLocations.add(new DateslotHelperClass("Today 21,","6 slots available"));
        dateslotLocations.add(new DateslotHelperClass("Tomorrow 22,","6 slots available"));
        dateslotLocations.add(new DateslotHelperClass("Sat 22,","5 slots available"));
        dateslotLocations.add(new DateslotHelperClass("Sun 21,","4 slots available"));
        adapter = new DateslotAdapter(dateslotLocations);
        dateslotRecycler.setAdapter(adapter);
    }

}