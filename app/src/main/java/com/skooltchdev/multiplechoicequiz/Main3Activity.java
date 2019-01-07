package com.skooltchdev.multiplechoicequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//maybe a main screen where you can click buttons to go to the tests

public class Main3Activity extends AppCompatActivity {

    TextView textView,textView2, textView3;
    Button refresh;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        final FirebaseDatabaseManagement firebase = new FirebaseDatabaseManagement(firebaseAuth.getUid());


        //Toast.makeText(getApplicationContext(),firebaseAuth.getUid(), Toast.LENGTH_SHORT).show();

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        refresh = (Button)findViewById(R.id.button);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebase.updateDatabase("Accounting 1",50,20,80);
                Toast.makeText(getApplicationContext(),"meme", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
