package com.skooltchdev.multiplechoicequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private QuizModel qModel1 = new QuizModel("Q1",
            new String[]{
                    "How Many Stars?:1:2:3:4"
    });
    ScrollView scrollView;
    LinearLayout linearLayout;
    List<QuizModel> quizModels = new ArrayList<>();
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        quizModels.add(qModel1);
        super.onCreate(savedInstanceState);
        scrollView = (ScrollView) findViewById(R.id.scroll);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearLayout);
        System.out.println(quizModels.size());
        for (QuizModel quizModel : quizModels) {
            Button button = new Button(getApplicationContext());
            button.setText (quizModel.getTitle());
            button.setId(i);
            button.setTextSize(15);
            button.setWidth(1000);
            button.setHeight(100);
            //button.getBackground().setColorFilter(Color.parseColor("#DAA520"), PorterDuff.Mode.DARKEN);
            linearLayout.addView(button);
            /*button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateMatch.add(updateMatchEntry);
                    assert getFragmentManager() != null;
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new EditActivity())
                            .commit();
                }
            });*/
        }
        setContentView(R.layout.activity_categorys);
    }

}
