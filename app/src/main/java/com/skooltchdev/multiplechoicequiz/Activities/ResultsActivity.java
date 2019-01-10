package com.skooltchdev.multiplechoicequiz.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.skooltchdev.multiplechoicequiz.Models.ResultsModel;
import com.skooltchdev.multiplechoicequiz.R;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class ResultsActivity extends AppCompatActivity {
    static ResultsModel resultsModel;
    TextView mScoreView;
    TableLayout mTableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        mScoreView = (TextView) findViewById(R.id.results_layout_score_view);
        mTableLayout = (TableLayout) findViewById(R.id.results_layout_table_layout);
        int i = 0;
        while (i < resultsModel.getCorrectAnswer().size()){
            TableRow tableRow = new TableRow(getApplicationContext());

            TextView questionNumber = new TextView(getApplicationContext());
            questionNumber.setText(String.valueOf(i + 1));

            TextView chosenAnswer = new TextView(getApplicationContext());
            chosenAnswer.setText(resultsModel.getGivenAnswerLetter().get(i));

            TextView correctAnswer = new TextView(getApplicationContext());
            correctAnswer.setText(resultsModel.getCorrectAnswerLetter().get(i));

            questionNumber.setTextAppearance(this, R.style.TextAppearance_AppCompat_Menu);
            chosenAnswer.setTextAppearance(this, R.style.TextAppearance_AppCompat_Menu);
            correctAnswer.setTextAppearance(this, R.style.TextAppearance_AppCompat_Menu);
            if (chosenAnswer.getText().equals(correctAnswer.getText())) tableRow.setBackgroundColor(Color.rgb(5, 178, 51));
            else tableRow.setBackgroundColor(Color.rgb(255, 0, 0));
            tableRow.setLeft(20);
            tableRow.addView(questionNumber);
            tableRow.addView(chosenAnswer);
            tableRow.addView(correctAnswer);
            tableRow.setMinimumHeight(150);
            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            mTableLayout.addView(tableRow);
            i++;
        }
        mScoreView.setText(String.valueOf(resultsModel.getScore()));
    }

    public static ResultsModel getResultsModel() {
        return resultsModel;
    }

    public static void setResultsModel(ResultsModel resultsModel) {
        ResultsActivity.resultsModel = resultsModel;
    }
}
