package com.skooltchdev.multiplechoicequiz.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skooltchdev.multiplechoicequiz.Models.ResultsModel;
import com.skooltchdev.multiplechoicequiz.R;
import com.skooltchdev.multiplechoicequiz.Resources.Utils;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class DetailActivity extends AppCompatActivity {

    private static ResultsModel resultsModel;
    private static int questionNumber;
    private Button mBack;
    private TextView mQuestionNumber, mQuestion,
            mChosenAnswer, mCorrectAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        mQuestionNumber = (TextView) findViewById(R.id.question_number);
        mQuestion = (TextView) findViewById(R.id.question);
        mChosenAnswer = (TextView) findViewById(R.id.chosen_answer);
        mCorrectAnswer = (TextView) findViewById(R.id.correct_answer);
        mBack = (Button) findViewById(R.id.back);

        mQuestionNumber.setText("Question Number: " + String.valueOf(questionNumber));
        mQuestion.setText("Question: " + resultsModel.getQuestion().get(questionNumber - 1));
        mChosenAnswer.setText("Chosen Answer: " + resultsModel.getGivenAnswer().get(questionNumber - 1));
        mCorrectAnswer.setText("Correct Answer: " + resultsModel.getCorrectAnswer().get(questionNumber - 1));
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.switchActivity(getApplicationContext(), ResultsActivity.class);
            }
        });
    }

    public static ResultsModel getResultsModel() {
        return resultsModel;
    }

    public static void setResultsModel(ResultsModel resultsModel) {
        DetailActivity.resultsModel = resultsModel;
    }

    public static int getQuestionNumber() {
        return questionNumber;
    }

    public static void setQuestionNumber(int questionNumber) {
        DetailActivity.questionNumber = questionNumber;
    }
}
