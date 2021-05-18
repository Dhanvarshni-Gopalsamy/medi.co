package com.example.namachivaya.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.namachivaya.R;
import com.example.namachivaya.activities.HelperClasses.FeaturedAdapter;
import com.example.namachivaya.activities.HelperClasses.FeaturedHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//variables
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    //navigation board
    ImageView menuIcon;
    static final  float END_SCALE = 0.7f;
    LinearLayout contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Navigating to activities
        findViewById(R.id.viewallspecialist).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), FindBook.class)));

        //hooks
        featuredRecycler=findViewById(R.id.featured_recycler);
        featuredRecycler();
        menuIcon=findViewById(R.id.menuboard);
        contentView = findViewById(R.id.main_home);

        //Menu Hooks
        drawerLayout =findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.navigation_view);

        //Navigation Drawer
        navigationDrawer();
    }


    //navigation drawerfunction
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible((GravityCompat.START))){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
           super.onBackPressed();}
    }
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_appointments);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible((GravityCompat.START))) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }
    private void animateNavigationDrawer() {
        //tofix color
        //drawerLayout.setScrimColor(getResources().getColor(R.color.card1));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                //Scale the view based on current slide effect
             final float diffScaledOffset =slideOffset * (1-END_SCALE);
             final float offsetScale =1 - diffScaledOffset;
             contentView.setScaleX(offsetScale);
             contentView.setScaleY(offsetScale);

             //translate the view, accounting for the scaled with
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset/2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    private void featuredRecycler(){
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        //driver code
        featuredLocations.add(new FeaturedHelperClass("Asked for female","45 years, Delhi","Post covid complications","Day 26 of covid Complains : low grade fever with headache and CT score in second week: 8/25 CRP in second week 8.8 Current BP 155/95 (no prior BP history) Current oxygen 97 Current PR..."));
        featuredLocations.add(new FeaturedHelperClass("Asked for female","45 years, Delhi","Post covid complications","Day 26 of covid Complains : low grade fever with headache and CT score in second week: 8/25 CRP in second week 8.8 Current BP 155/95 (no prior BP history) Current oxygen 97 Current PR..."));
        featuredLocations.add(new FeaturedHelperClass("Asked for female","45 years, Delhi","Post covid complications","Day 26 of covid Complains : low grade fever with headache and CT score in second week: 8/25 CRP in second week 8.8 Current BP 155/95 (no prior BP history) Current oxygen 97 Current PR..."));
        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }


}