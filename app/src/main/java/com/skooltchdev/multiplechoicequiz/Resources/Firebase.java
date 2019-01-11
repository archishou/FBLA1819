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

import java.util.Map;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class Firebase {
    static FirebaseDatabase firebaseDatabase;
    static FirebaseAuth firebaseAuth;
    static String branch;
    static DatabaseReference databaseReference;
    static boolean isAuth;
    static int score, highScore;
    static boolean mSuccessful;
    static String eMail;
    static int accountHigh, histHigh, parliHigh, mathHigh, introHigh;
    static String accountU, histU, parliU, mathU, introU;

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

    public static String[] getAccountingHighScore() {
        String[] returnString;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getHighScoreAccount((Map<String,Object>) dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        });
        returnString = new String[]{
                String.valueOf(getAccountHigh()),
                getAccountU()
        };
        return returnString;
    }
    private static void getHighScoreAccount(Map<String,Object> users) {
        int score = -1;
        int userScore = 0;
        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            userScore = Integer.parseInt(String.valueOf(singleUser.get("account")));
            if (userScore > score) {
                String email = String.valueOf(singleUser.get("email"));
                setAccountU(email.substring(0, email.indexOf('@')));
                score = userScore;
            }
        }
        setAccountHigh(score);
    }
    private static int getAccountHigh() {
        return accountHigh;
    }
    private static void setAccountHigh(int accountHigh) {
        Firebase.accountHigh = accountHigh;
    }
    public static String getAccountU() {return accountU;}
    public static void setAccountU(String accountU) {Firebase.accountU = accountU;}

    public static String[] getHistHighScore() {
        String[] returnString;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getHighScoreHist((Map<String,Object>) dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        });
        returnString = new String[]{
                String.valueOf(getHistHigh()),
                getHistU()
        };
        return returnString;
    }
    private static void getHighScoreHist(Map<String,Object> users) {
        int score = -1;
        int userScore = 0;
        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            userScore = Integer.parseInt(String.valueOf(singleUser.get("hist")));
            if (userScore > score) {
                String email = String.valueOf(singleUser.get("email"));
                setHistU(email.substring(0, email.indexOf('@')));
                score = userScore;
            }
        }
        setHistHigh(score);
    }
    private static int getHistHigh() {
        return histHigh;
    }
    private static void setHistHigh(int histHigh) {
        Firebase.histHigh = histHigh;
    }
    private static String getHistU() {
        return histU;
    }
    private static void setHistU(String histU) {
        Firebase.histU = histU;
    }

    public static String[] getParliHighScore() {
        String[] returnString;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getHighScoreParli((Map<String,Object>) dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        });
        returnString = new String[]{
                String.valueOf(getParliHigh()),
                getParliU()
        };
        return returnString;
    }
    private static void getHighScoreParli(Map<String,Object> users) {
        int score = -1;
        int userScore = 0;
        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            userScore = Integer.parseInt(String.valueOf(singleUser.get("parliment")));
            if (userScore > score) {
                String email = String.valueOf(singleUser.get("email"));
                setParliU(email.substring(0, email.indexOf('@')));
                score = userScore;
            }
        }
        setParliHigh(score);
    }
    private static int getParliHigh() {
        return parliHigh;
    }
    private static void setParliHigh(int parliHigh) {
        Firebase.parliHigh = parliHigh;
    }
    private static String getParliU() {
        return parliU;
    }
    private static void setParliU(String parliU) {
        Firebase.parliU = parliU;
    }

    public static String[] getMathHighScore() {
        String[] returnString;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getHighScoreMath((Map<String,Object>) dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        });
        returnString = new String[]{
                String.valueOf(getMathHigh()),
                getMathU()
        };
        return returnString;
    }
    private static void getHighScoreMath(Map<String,Object> users) {
        int score = -1;
        int userScore = 0;
        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            userScore = Integer.parseInt(String.valueOf(singleUser.get("math")));
            if (userScore > score) {
                String email = String.valueOf(singleUser.get("email"));
                setMathU(email.substring(0, email.indexOf('@')));
                score = userScore;
            }
        }
        setMathHigh(score);
    }
    private static int getMathHigh() {
        return mathHigh;
    }
    private static void setMathHigh(int mathHigh) {
        Firebase.mathHigh = mathHigh;
    }
    private static String getMathU() {
        return mathU;
    }
    private static void setMathU(String mathU) {
        Firebase.mathU = mathU;
    }

    public static String[] getIntroHighScore() {
        String[] returnString;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getHighScoreIntro((Map<String,Object>) dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        });
        returnString = new String[]{
                String.valueOf(getIntroHigh()),
                getIntroU()
        };
        return returnString;
    }
    private static void getHighScoreIntro(Map<String,Object> users) {
        int score = -1;
        int userScore = 0;
        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            userScore = Integer.parseInt(String.valueOf(singleUser.get("math")));
            if (userScore > score) {
                String email = String.valueOf(singleUser.get("email"));
                setIntroU(email.substring(0, email.indexOf('@')));
                score = userScore;
            }
        }
        setIntroHigh(score);
    }
    public static int getIntroHigh() {
        return introHigh;
    }
    public static void setIntroHigh(int introHigh) {
        Firebase.introHigh = introHigh;
    }
    public static String getIntroU() {
        return introU;
    }
    public static void setIntroU(String introU) {
        Firebase.introU = introU;
    }
}
