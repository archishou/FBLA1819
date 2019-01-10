package com.skooltchdev.multiplechoicequiz.Resources;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class Firebase {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    static FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Users");
    static boolean isAuth;
    public static boolean isAuth(String userName, String password, Activity activity)  {
        firebaseAuth.signInWithEmailAndPassword(userName, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) isAuth = true;
                        else isAuth = false;
                    }
                });

        return isAuth;
    }
    public static boolean emailExists(String email) {
        return false;
    }
    public static void addUser(String email, String password, String name) {

    }
}
