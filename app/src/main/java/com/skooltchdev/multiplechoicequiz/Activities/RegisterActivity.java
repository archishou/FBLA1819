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
public class RegisterActivity extends AppCompatActivity {
    private RegisterActivity registerActivity;
    private EditText email, pass, confirmPass, name;
    private Button register, signIn;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_register);
        email = (EditText) findViewById(R.id.userNameEditText_Register);
        pass = (EditText) findViewById(R.id.passwordEditText_Register);
        confirmPass = (EditText) findViewById(R.id.confirmEditText);
        name = (EditText) findViewById(R.id.nameEditText);
        register = (Button) findViewById(R.id.registerButton);
        signIn = (Button) findViewById(R.id.signInButton_Register);
        registerActivity = this;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("") ||
                    pass.getText().toString().equals("") ||
                    confirmPass.getText().toString().equals("") ||
                    name.getText().toString().equals("")) {
                    makeToast("Please enter all information.");
                }
                else if (!pass.getText().toString().equals(confirmPass.getText().toString())) makeToast("Passwords do not match.");

                else if (Firebase.addUser(email.getText().toString(), pass.getText().toString(), name.getText().toString(), registerActivity)) {
                    makeToast("Registered, Redirecting to home");
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });
    }
    public void makeToast(String mssg) {
        Toast.makeText(getApplicationContext(), mssg, Toast.LENGTH_LONG).show();
    }
}
