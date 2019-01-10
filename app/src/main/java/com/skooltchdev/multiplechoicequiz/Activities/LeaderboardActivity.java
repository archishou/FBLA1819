package com.skooltchdev.multiplechoicequiz.Activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skooltchdev.multiplechoicequiz.Models.LeaderboardModel;
import com.skooltchdev.multiplechoicequiz.R;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class LeaderboardActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_leaderboard);
        linearLayout = (LinearLayout) findViewById(R.id.linear_leader);
        for (String s : LeaderboardModel.leadership) {
            CardView cardView = new CardView(getApplicationContext());
            ConstraintLayout constraintLayout = new ConstraintLayout(getApplicationContext());
            TextView title, username, score;
            title = new TextView(getApplicationContext());
            username = new TextView(getApplicationContext());
            score = new TextView(getApplicationContext());

            cardView.setRadius(12);
            cardView.setX(16);
            cardView.setY(137);
            CardView.LayoutParams params = new CardView.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.TOP;
            cardView.setLayoutParams(params);

            title.setText(s);
            title.setTextAppearance(this, R.style.TextAppearance_AppCompat_Headline);
            title.setWidth(213);
            title.setHeight(39);

        }
    }
}
