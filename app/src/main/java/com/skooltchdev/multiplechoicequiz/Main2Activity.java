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

public class Main2Activity extends AppCompatActivity {

    private EditText userNameEditText, passwordEditText;
    private Button signInButton, noAccountButton, forgotPasswordButton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseAuth = FirebaseAuth.getInstance();

        userNameEditText = (EditText)findViewById(R.id.userNameEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        signInButton = (Button)findViewById(R.id.signInButton);
        noAccountButton = (Button)findViewById(R.id.noAccountButton);
        forgotPasswordButton = (Button)findViewById(R.id.forgotPasswordButton);

        if(firebaseAuth.getCurrentUser() != null)   {
            //GO DIRECTLY TO MAIN PROFILE ACTIVITY
        }

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        noAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                startActivity(new Intent(Main2Activity.this, ForgotPassword.class));
            }
        });

    }
    private void login()    {
        String eMail = userNameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();


        if(TextUtils.isEmpty(eMail))    {
            Toast.makeText(getApplicationContext(),"Please enter an E-Mail", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getApplicationContext(),"Signing In...", Toast.LENGTH_SHORT).show();

        firebaseAuth.signInWithEmailAndPassword(eMail, password)
                .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Sign In Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Sign In Failed. Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}
