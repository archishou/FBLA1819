package com.skooltchdev.multiplechoicequiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.skooltchdev.multiplechoicequiz.R;
import com.skooltchdev.multiplechoicequiz.Tests.AccountingTest;
import com.skooltchdev.multiplechoicequiz.Tests.FinancialMathTest;
import com.skooltchdev.multiplechoicequiz.Tests.ParliamentaryProceduresTest;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class CategoriesActivity extends AppCompatActivity {
    private Button accouting, parliment, intro, hist, math, home;
    // Creates Buttons for each of the subjects above
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_categorys);
        //Allows set up of buttons for each individual quiz topic and home to return to main page after sign in
        intro = (Button) findViewById(R.id.intro_cat_button);
        hist = (Button) findViewById(R.id.hist_cat_button);
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
                //Starts Parliamentary Procedures Quiz if the button for Parliamentary Procedures is tapped
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestActivity.setTestModel(new FinancialMathTest().getModel());
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
                //Starts Financial Math Quiz if the button for Financial Math is tapped

            }
            
        });
        accouting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestActivity.setTestModel(new AccountingTest().getModel());
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
                //Starts Accounting Quiz if the button for Accounting is tapped

            }
            
        });
        
    
                hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestActivity.setTestModel(new HistoryFBLA().getModel());
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
                //Starts Financial Math Quiz if the button for Financial Math is tapped

            }
        
        
        
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
