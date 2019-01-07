package com.skooltchdev.multiplechoicequiz;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseManagement {

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Test updateTest;
    Test generateTest;

    public FirebaseDatabaseManagement(String uid) {
        updateTest = new Test("testTopic", 0,0,0);
        generateTest = new Test();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users").child(uid);


    }

    public void updateDatabase(String topic, int test1, int test2, int test3) {

        updateTest.setProgress1(test1);
        updateTest.setProgress2(test2);
        updateTest.setProgress3(test3);
        updateTest.setTestTopic(topic);

        databaseReference.child(topic).setValue(updateTest);
    }

    public void generateDatabase()  {

        String testTopic1 = "Accounting 1";
        String testTopic2 = "Introduction to Financial Math";
        String testTopic3 = "Topic 3";
        String testTopic4 = "Topic 4";
        String testTopic5 = "Topic 5";

        generateTest.setTestTopic(testTopic1);
        databaseReference.child(testTopic1).setValue(generateTest);
        generateTest.setTestTopic(testTopic2);
        databaseReference.child(testTopic2).setValue(generateTest);
        generateTest.setTestTopic(testTopic3);
        databaseReference.child(testTopic3).setValue(generateTest);
        generateTest.setTestTopic(testTopic4);
        databaseReference.child(testTopic4).setValue(generateTest);
        generateTest.setTestTopic(testTopic5);
        databaseReference.child(testTopic5).setValue(generateTest);




    }

}
