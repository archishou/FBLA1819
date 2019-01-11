package com.skooltchdev.multiplechoicequiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skooltchdev.multiplechoicequiz.Models.LeaderboardModel;
import com.skooltchdev.multiplechoicequiz.R;
import com.skooltchdev.multiplechoicequiz.Resources.Firebase;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class LeaderboardActivity extends AppCompatActivity {
    private Button home;
    private TextView actU, actS;
    private TextView histU, histS;
    private TextView introU, introS;
    private TextView mathU, mathS;
    private TextView parlimentU, parlimentS;

    private static LeaderboardModel leaderboardModel =
            new LeaderboardModel("5", "3", "2", "3",
                    "3", "h", "b", "o", "o", "o");
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_leaderboard);
        home = (Button) findViewById(R.id.go_home_leaderboard);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        actU = (TextView) findViewById(R.id.act_username_1);
        actS = (TextView) findViewById(R.id.acount_score_1);

        introU = (TextView) findViewById(R.id.intro_username_1);
        introS = (TextView) findViewById(R.id.intro_score_1);

        histU = (TextView) findViewById(R.id.hist_username_1);
        histS = (TextView) findViewById(R.id.hist_score_1);

        parlimentU = (TextView) findViewById(R.id.par_username_1);
        parlimentS = (TextView) findViewById(R.id.par_score_1);

        mathU = (TextView) findViewById(R.id.math_username_1);
        mathS = (TextView) findViewById(R.id.math_score_1);

        leaderboardModel.setAccountingScore(String.valueOf(Firebase.getHighScore("account")));
        leaderboardModel.setAccountingU(String.valueOf(Firebase.getHighScoreUser("account")));

        leaderboardModel.setiFBLAScore(String.valueOf(Firebase.getHighScore("intro")));
        leaderboardModel.setiFBLAU(String.valueOf(Firebase.getHighScoreUser("intro")));

        leaderboardModel.setmScore(String.valueOf(Firebase.getHighScore("math")));
        leaderboardModel.setmU(String.valueOf(Firebase.getHighScoreUser("math")));

        leaderboardModel.setpProcedureScore(String.valueOf(Firebase.getHighScore("parliment")));
        leaderboardModel.setpProcedureU(String.valueOf(Firebase.getHighScoreUser("parliment")));

        leaderboardModel.setHistFBLAScore(String.valueOf(Firebase.getHighScore("hist")));
        leaderboardModel.setHistFBLAU(String.valueOf(Firebase.getHighScoreUser("hist")));


        actU.setText(leaderboardModel.getAccountingU());
        introU.setText(leaderboardModel.getiFBLAU());
        mathU.setText(leaderboardModel.getmU());
        parlimentU.setText(leaderboardModel.getpProcedureU());
        histU.setText(leaderboardModel.getHistFBLAU());

        actS.setText(leaderboardModel.getAccountingScore());
        introS.setText(leaderboardModel.getiFBLAScore());
        mathS.setText(leaderboardModel.getmScore());
        parlimentS.setText(leaderboardModel.getpProcedureScore());
        histS.setText(leaderboardModel.getHistFBLAScore());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public static LeaderboardModel getLeaderboardModel() {
        return leaderboardModel;
    }

    public static void setLeaderboardModel(LeaderboardModel leaderboardModel) {
        LeaderboardActivity.leaderboardModel = leaderboardModel;
    }
}
