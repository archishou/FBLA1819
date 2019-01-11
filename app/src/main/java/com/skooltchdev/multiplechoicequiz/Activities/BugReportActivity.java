package com.skooltchdev.multiplechoicequiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.skooltchdev.multiplechoicequiz.R;
import com.skooltchdev.multiplechoicequiz.Resources.Firebase;

/**
 * Created by Archishmaan Peyyety on 1/11/19.
 * Project: FBLA1819
 */
public class BugReportActivity extends AppCompatActivity {
    private Button submit;
    private EditText name, cat, comments;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.bug_report_activty);
        submit = (Button) findViewById(R.id.submit_bg_report);
        comments = (EditText) findViewById(R.id.comments_bug);
        cat = (EditText) findViewById(R.id.cat_bug);
        name = (EditText) findViewById(R.id.name_bug);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase.submitBugReport(name.getText().toString(),
                        cat.getText().toString(), comments.getText().toString());
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
