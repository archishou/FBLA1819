package com.skooltchdev.multiplechoicequiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skooltchdev.multiplechoicequiz.R;
import com.skooltchdev.multiplechoicequiz.Resources.Firebase;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class SignInActivity extends AppCompatActivity {
    private Button signIn, forgotPassword, signUp;
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_signin);
        signIn = (Button) findViewById(R.id.signInButton);
        forgotPassword = (Button) findViewById(R.id.forgotPasswordButton);
        signUp = (Button) findViewById(R.id.noAccountButton);
        username = (EditText) findViewById(R.id.userNameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("") || password.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter all information.", Toast.LENGTH_LONG).show();
                else {
                    if (Firebase.isAuth(username.getText().toString(), password.getText().toString())) {
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                    else Toast.makeText(getApplicationContext(), "Incorrect Credentials.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
