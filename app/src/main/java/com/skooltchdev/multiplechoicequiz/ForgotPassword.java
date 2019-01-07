package com.skooltchdev.multiplechoicequiz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class ForgotPassword extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText eMail;
    Button authenticate, signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        firebaseAuth = FirebaseAuth.getInstance();
        authenticate = (Button) findViewById(R.id.authButton);
        eMail = (EditText) findViewById(R.id.eMailEditText);
        signInButton = (Button) findViewById(R.id.signInButton);

        authenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eMailId = eMail.getText().toString().trim();
                if(TextUtils.isEmpty(eMailId))  {
                    Toast.makeText(getApplicationContext(),"Please enter an E-Mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Im here", Toast.LENGTH_SHORT).show();
                firebaseAuth.sendPasswordResetEmail(eMailId).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"E-Mail has been sent", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(ForgotPassword.this, Main2Activity.class));
                        }
                        else    {
                            Toast.makeText(getApplicationContext(),"Please enter a valid E-Mail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ForgotPassword.this, Main2Activity.class));
            }
        });



    }
}
