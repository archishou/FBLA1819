package com.skooltchdev.multiplechoicequiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.skooltchdev.multiplechoicequiz.R;
import com.skooltchdev.multiplechoicequiz.Tests.FinancialMathTest;
import com.skooltchdev.multiplechoicequiz.Tests.ParliamentaryProceduresTest;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class CategoriesActivity extends AppCompatActivity {
    private Button accouting, parliment, intro, hist, math, home;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_categorys);
        accouting = (Button) findViewById(R.id.accouting_cat_button);
        parliment = (Button) findViewById(R.id.parliment_button) ;
        math = (Button) findViewById(R.id.math_cat_button);
        home = (Button) findViewById(R.id.goto_home);
        parliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestActivity.setTestModel(new ParliamentaryProceduresTest().getModel());
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestActivity.setTestModel(new FinancialMathTest().getModel());
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
