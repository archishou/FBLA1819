package com.skooltchdev.multiplechoicequiz.Resources;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class Firebase {
    static FirebaseDatabase firebaseDatabase;
    static FirebaseAuth firebaseAuth;
    static DatabaseReference databaseReference;
    static boolean isAuth;
    static boolean mSuccessful;
    public static boolean isAuth(String userName, String password, Activity activity)  {
        FirebaseApp.initializeApp(activity.getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
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
    public static boolean addUser(String email, String password, String name, final Activity activity) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    boolean successful;
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) Toast.makeText(activity, "Email already in use.", Toast.LENGTH_SHORT).show();
                        else {
                            for (String column : Database.columnNames)
                            databaseReference.child(firebaseAuth.getUid()).child(column).setValue(0);
                        }
                        successful = task.isSuccessful();
                        setmSuccessful(successful);
                    }
                });

        return ismSuccessful();
    }

    private static boolean ismSuccessful() {
        return mSuccessful;
    }

    private static void setmSuccessful(boolean mSuccessful) {
        Firebase.mSuccessful = mSuccessful;
    }
}
