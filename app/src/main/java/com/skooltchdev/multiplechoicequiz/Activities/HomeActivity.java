package com.skooltchdev.multiplechoicequiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.skooltchdev.multiplechoicequiz.Models.LeaderboardModel;
import com.skooltchdev.multiplechoicequiz.R;
import com.skooltchdev.multiplechoicequiz.Resources.Firebase;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class HomeActivity extends AppCompatActivity {
    private Button quizzes, leaderboards, logout, more;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_home);
        more = findViewById(R.id.more_button);
        logout = findViewById(R.id.log_out);
        quizzes = (Button) findViewById(R.id.dlt_act_bttn);
        quizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
                startActivity(intent);
            }
        });
        leaderboards = (Button) findViewById(R.id.sbmt_bgrprt);
        leaderboards.setOnClickListener(new View.OnClickListener() {
            LeaderboardModel leaderboardModel = new LeaderboardModel();
            @Override
            public void onClick(View view) {
                leaderboardModel.setAccountingScore(String.valueOf(Firebase.getAccountingHighScore()[0]));
                leaderboardModel.setAccountingU(String.valueOf(Firebase.getAccountingHighScore()[1]));

                leaderboardModel.setHistFBLAScore(String.valueOf(Firebase.getHistHighScore()[0]));
                leaderboardModel.setHistFBLAU(Firebase.getHistHighScore()[1]);

                leaderboardModel.setiFBLAScore(Firebase.getIntroHighScore()[0]);
                leaderboardModel.setiFBLAU(Firebase.getIntroHighScore()[1]);

                leaderboardModel.setmScore(Firebase.getMathHighScore()[0]);
                leaderboardModel.setmU(Firebase.getMathHighScore()[1]);

                leaderboardModel.setpProcedureScore(Firebase.getParliHighScore()[0]);
                leaderboardModel.setpProcedureU(Firebase.getParliHighScore()[1]);

                leaderboardModel.setHistFBLAScore(Firebase.getHistHighScore()[0]);
                leaderboardModel.setHistFBLAU(Firebase.getHistHighScore()[1]);

                LeaderboardActivity.setLeaderboardModel(leaderboardModel);

                System.out.println("%%%-%: " + leaderboardModel.getAccountingU());
                Intent intent = new Intent(getApplicationContext(), LeaderboardActivity.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase.signOut();
                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                startActivity(intent);
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
