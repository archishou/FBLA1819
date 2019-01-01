package com.skooltchdev.multiplechoicequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Archishmaan Peyyety on 12/31/18.
 * Project: FBLA1819
 */
public class QuizActivity extends AppCompatActivity {
    static QuizModel quizModel;
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    public static void setQuizModel(QuizModel quizModel1) {
        quizModel = quizModel1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        updateQuestion(mQuestionNumber);
    }
    private void updateQuestion(int questionID){
        String[] split = quizModel.getQuestionsAnswers()[questionID].split(":");

        mQuestionView.setText(split[0]);
        mButtonChoice1.setText(split[genNumbers()[0]]);
        mButtonChoice2.setText(split[genNumbers()[1]]);
        mButtonChoice3.setText(split[genNumbers()[2]]);
        mButtonChoice4.setText(split[genNumbers()[3]]);
        mAnswer = split[1];
        mQuestionNumber++;
    }
    private static int[] genNumbers () {
        int[] rand = new int[4];
        int random1 = (int )(Math.random() * 4 + 1);
        rand[0] = random1;
        int random2 = (int)(Math.random() * 4 + 1);
        while (random2 == random1) random2 = (int)(Math.random());
        rand[1] = random2;
        int random3 = (int)(Math.random() * 4 + 1);
        while (random3 == random1 || random3 == random2) random3 = (int)(Math.random() * 4 + 1);
        rand[2] = random3;
        int random4 = (int)(Math.random() * 4 + 1);
        while (random4 == random1 || random4 == random2 || random4 == random3) random4 = (int)(Math.random() * 4 + 1);
        rand[3] = random4;
        return rand;
    }
}
