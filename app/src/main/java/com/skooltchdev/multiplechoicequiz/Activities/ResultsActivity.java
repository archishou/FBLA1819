package com.skooltchdev.multiplechoicequiz.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
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

    }

    public static ResultsModel getResultsModel() {
        return resultsModel;
    }

    public static void setResultsModel(ResultsModel resultsModel) {
        ResultsActivity.resultsModel = resultsModel;
    }
}
