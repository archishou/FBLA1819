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
    private SignInActivity signInActivity;
    private static String username;
    private Button signIn, signUp;
    private EditText usernameE, passwordE;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_signin);
        signIn = (Button) findViewById(R.id.signInButton_Signin);
        signUp = (Button) findViewById(R.id.noAccountButton);
        usernameE = (EditText) findViewById(R.id.userNameEditText);
        passwordE = (EditText) findViewById(R.id.passwordEditText);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        signInActivity = this;
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Ustring: " + usernameE.getText().toString());
                System.out.println("Pstring: " + passwordE.getText().toString());
                if (usernameE.getText().toString().equals("") || passwordE.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter all information.", Toast.LENGTH_LONG).show();
                else {
                    if (Firebase.isAuth(usernameE.getText().toString(), passwordE.getText().toString(), signInActivity)) {
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        username = usernameE.getText().toString();
                    }
                    else Toast.makeText(getApplicationContext(), "Incorrect Credentials.", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    public static String getUsername() {
        return username;
    }
}
