package com.skooltchdev.multiplechoicequiz.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skooltchdev.multiplechoicequiz.Models.QuestionModel;
import com.skooltchdev.multiplechoicequiz.Models.TestModel;
import com.skooltchdev.multiplechoicequiz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 12/31/18.
 * Project: FBLA1819
 */
public class TestActivity extends AppCompatActivity {
    static TestModel testModel;
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button submit, quit;
    private Button correctButton;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    List<Button> choices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        List<QuestionModel> questionModels = new ArrayList<>();
                questionModels.add(new QuestionModel("How Are you?", new String[]{"Bad", "Med", "Sed", "med"}));
        testModel = new TestModel("How Are You", questionModels);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        choices.add(mButtonChoice1);
        choices.add(mButtonChoice2);
        choices.add(mButtonChoice3);
        choices.add(mButtonChoice4);
        quit = (Button)findViewById(R.id.quit_button);
        submit = (Button)findViewById(R.id.submit_button);
        updateQuestion(mQuestionNumber);

        for (final Button b : choices) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (Button nB: choices) nB.setBackgroundColor(Color.rgb(0,145,234));
                    b.setBackgroundColor(Color.rgb(255, 0, 0));
                }
            });
        }
    }
    private void updateQuestion(int questionID){
        int[] ran = genNumbers();
        mQuestionView.setText(testModel.getQuestions().get(questionID).getQuestion());
        mButtonChoice1.setText(testModel.getQuestions().get(questionID).getQuestionsAnswers()[ran[0]]);
        mButtonChoice2.setText(testModel.getQuestions().get(questionID).getQuestionsAnswers()[ran[1]]);
        mButtonChoice3.setText(testModel.getQuestions().get(questionID).getQuestionsAnswers()[ran[2]]);
        mButtonChoice4.setText(testModel.getQuestions().get(questionID).getQuestionsAnswers()[ran[3]]);
        mAnswer = testModel.getQuestions().get(questionID).getQuestionsAnswers()[0];
        if (mButtonChoice1.getText().equals(mAnswer)) correctButton = mButtonChoice1;
        mQuestionNumber++;
    }
    private static int[] genNumbers () {
        int[] rand = new int[4];
        int random1 = (int )(Math.random() * 4);
        rand[0] = random1;
        int random2 = (int)(Math.random() * 4);
        while (random2 == random1) random2 = (int)(Math.random());
        rand[1] = random2;
        int random3 = (int)(Math.random() * 4);
        while (random3 == random1 || random3 == random2) random3 = (int)(Math.random() * 4);
        rand[2] = random3;
        int random4 = (int)(Math.random() * 4);
        while (random4 == random1 || random4 == random2 || random4 == random3) random4 = (int)(Math.random() * 4);
        rand[3] = random4;
        return rand;
    }
    public static void setTestModel(TestModel testModel1) {
        testModel = testModel1;
    }

}