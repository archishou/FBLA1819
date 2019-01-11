package com.skooltchdev.multiplechoicequiz.Resources;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.skooltchdev.multiplechoicequiz.Activities.HomeActivity;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class Firebase {
    static FirebaseDatabase firebaseDatabase;
    static FirebaseAuth firebaseAuth;
    static DatabaseReference databaseReference;
    static boolean isAuth;
    static int score, highScore;
    static boolean mSuccessful;
    static String eMail;

    public static boolean isrSuccessful() {
        return rSuccessful;
    }

    public static void setrSuccessful(boolean rSuccessful) {
        Firebase.rSuccessful = rSuccessful;
    }

    static boolean rSuccessful;

    public static boolean signIn(String userName, String password, final Activity activity)  {
        FirebaseApp.initializeApp(activity.getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(userName, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(activity, "Sign In Successful", Toast.LENGTH_SHORT);
                            Intent sharingIntent = new Intent(activity, HomeActivity.class);
                            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(sharingIntent);
                        }
                        else Toast.makeText(activity,"Sign In Failed. Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                });
        return ismSuccessful();
    }
    public static boolean addUser(final String email, String password, String name, final Activity activity) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    boolean successful;
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(activity, "You have successfully registered", Toast.LENGTH_SHORT).show();
                            for (String column : Database.columnNames) databaseReference.child(firebaseAuth.getUid()).child(column).setValue(0);
                            writeBranchData("email", email);
                            setrSuccessful(true);
                            Intent sharingIntent = new Intent(activity, HomeActivity.class);
                            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(sharingIntent);
                        }
                        else{
                            setrSuccessful(false);
                            if(task.getException() instanceof FirebaseAuthUserCollisionException)   {
                                Toast.makeText(activity, "An account already exists with this e-mail", Toast.LENGTH_LONG).show();

                            }
                            else    {
                                Toast.makeText(activity, "Please enter a valid E-mail and Password", Toast.LENGTH_LONG).show();

                            }
                        }

                    }
                });

        return isrSuccessful();
    }

    public static FirebaseUser getUser () {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public static int readBranchData(final String branch) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(getUser().getUid()).child(branch).getValue(Integer.class) != null)
                setScore(dataSnapshot.child(getUser().getUid()).child(branch).getValue(Integer.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return getScore();
    }
    public static void writeBranchData(final String branch, final int branchData) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        databaseReference.child(firebaseAuth.getUid()).child(branch).setValue(branchData);
    }
    public static void writeBranchData(final String branch, final String branchData) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        databaseReference.child(firebaseAuth.getUid()).child(branch).setValue(branchData);
    }

    public static int getHighScore(final String branch)   {
        //setHighScore(0);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int score = -1;
                for(DataSnapshot user: dataSnapshot.getChildren())  {
                    int userScore = Integer.parseInt(String.valueOf(user.child(branch).getValue()));
                    if(score <= userScore) score = userScore;
                }
                setHighScore(score);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return getHighScore();
    }

    public static String getHighScoreUser(final String branch)  {
        //seteMail("");
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot user: dataSnapshot.getChildren())  {
                    int userScore = Integer.parseInt(String.valueOf(user.child(branch).getValue()));
                    if(score <= userScore)  {
                        score = userScore;
                        seteMail(user.child("email").getValue(String.class)
                                .substring(0,user.child("email").getValue(String.class).indexOf('@')));
                    }
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return geteMail();
    }

    public static String geteMail() {
        return eMail;
    }

    public static void seteMail(String eMail) {
        Firebase.eMail = eMail;
    }

    private static int getHighScore() {
        return highScore;
    }

    private static void setHighScore(int highScore) {
        Firebase.highScore = highScore;
    }

    private static int getScore() {
        return score;
    }
    private static void setScore(int score) {
        Firebase.score = score;
    }

    private static boolean ismSuccessful() {
        return mSuccessful;
    }
    private static void setmSuccessful(boolean mSuccessful) {
        Firebase.mSuccessful = mSuccessful;
    }
}
