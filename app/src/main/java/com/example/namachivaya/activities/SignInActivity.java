package com.example.namachivaya.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.namachivaya.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //navigating to signup
        findViewById(R.id.textSignUp).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));

        //navigating to userdashboard
        findViewById(R.id.buttonSignIn).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), UserDashboard.class)));

        FirebaseFirestore database= FirebaseFirestore.getInstance();
        HashMap<String,Object> user=new HashMap<>();
        user.put("first_name","Jennifer");
        user.put("second_name","Lopus");
        user.put("email","jennifer@gmail.com");
        database.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(SignInActivity.this, "user inserted", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignInActivity.this, "error adding user", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}