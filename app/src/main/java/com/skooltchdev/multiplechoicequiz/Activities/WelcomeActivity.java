package com.skooltchdev.multiplechoicequiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.skooltchdev.multiplechoicequiz.R;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class WelcomeActivity extends AppCompatActivity {
    private Button mAccountButton, mNewAccount, mUserAgreement, mPrivacy;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_welcome);
        mAccountButton = (Button) findViewById(R.id.accountButton);
        mNewAccount = (Button)findViewById(R.id.newAccountButton);
        mUserAgreement = (Button)findViewById(R.id.agreementButton);
        mPrivacy = (Button)findViewById(R.id.privacyButton);
        mAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                finish();
                startActivity(intent);
            }
        });
        mNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                finish();
                startActivity(intent);
            }
        });
        mPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(WelcomeActivity.this, PrivacyActivity.class));
            }
        });
        mUserAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(WelcomeActivity.this, UserAgreementActivity.class));
            }
        });

    }
}
