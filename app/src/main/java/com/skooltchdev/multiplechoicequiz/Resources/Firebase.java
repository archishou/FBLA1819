package com.skooltchdev.multiplechoicequiz.Resources;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    public static boolean signIn(String userName, String password, Activity activity)  {
        FirebaseApp.initializeApp(activity.getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                setmSuccessful(task.isSuccessful());
            }
        });
        return ismSuccessful();
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
                            for (String column : Database.columnNames) databaseReference.child(firebaseAuth.getUid()).child(column).setValue(0);
                        }
                        successful = task.isSuccessful();
                        setmSuccessful(successful);
                    }
                });

        return ismSuccessful();
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

    public static int getHighScore(final String branch)   {
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int score = 0;
                for(DataSnapshot user: dataSnapshot.getChildren())  {
                    int userScore = Integer.parseInt(String.valueOf(user.child(branch).getValue()));
                    if(score <= userScore) score = userScore;
                }
                setHighScore(score);
                System.out.println("After Score: " + score);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        System.out.println("Get Score: " + getHighScore());
        return getHighScore();
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
