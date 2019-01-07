package com.skooltchdev.multiplechoicequiz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private EditText userName, password, confirmPassword;
    private Button signIn, register;
    private FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseDatabaseManagement firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        userName = (EditText)findViewById(R.id.userNameEditText);
        password = (EditText)findViewById(R.id.passwordEditText);
        confirmPassword = (EditText)findViewById(R.id.confirmEditText);
        signIn = (Button)findViewById(R.id.signInButton);
        register = (Button)findViewById(R.id.registerButton);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String eMail = userName.getText().toString().trim();
                String passCode = password.getText().toString().trim();
                String confirmPassCode = confirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(eMail))    {
                    Toast.makeText(getApplicationContext(),"Please enter an E-Mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passCode)) {
                    Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!confirmPassCode.equals(passCode))    {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Registering User", Toast.LENGTH_SHORT).show();

                firebaseAuth.createUserWithEmailAndPassword(eMail, passCode).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "You have successfully registered", Toast.LENGTH_SHORT).show();
                            FirebaseDatabaseManagement firebase = new FirebaseDatabaseManagement(firebaseAuth.getUid());
                            firebase.generateDatabase();
                            Toast.makeText(getApplicationContext(), "database created", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(MainActivity.this, Main2Activity.class));
                        }
                        else{

                            if(task.getException() instanceof FirebaseAuthUserCollisionException)   {
                                Toast.makeText(getApplicationContext(), "An account already exists with this e-mail", Toast.LENGTH_LONG).show();
                            }
                            else    {
                                Toast.makeText(getApplicationContext(), "Please enter a valid E-mail and Password", Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                });
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

}
