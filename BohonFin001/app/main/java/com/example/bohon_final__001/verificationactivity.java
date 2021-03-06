package com.example.bohon_final__001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class verificationactivity extends AppCompatActivity implements View.OnClickListener {
    public TextView line ;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificationactivity);
        mAuth = FirebaseAuth.getInstance();


        line = (TextView) findViewById(R.id.verificationid);

        line.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v.getId() == R.id.verificationid) {
            final FirebaseUser user = mAuth.getCurrentUser();
            if ( user.isEmailVerified()) {
                Toast.makeText(getApplicationContext(),"EMAIL IS VERIFIED",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Registration was Successful",Toast.LENGTH_SHORT).show();
            }
            else {
                user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(verificationactivity.this,"VERIFICATION EMAIL SENT AND REGISTRATION IS SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }
    }
}
