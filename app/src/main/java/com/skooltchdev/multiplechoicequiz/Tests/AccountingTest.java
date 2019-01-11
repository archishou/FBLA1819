package com.skooltchdev.multiplechoicequiz.Tests;

import com.skooltchdev.multiplechoicequiz.Models.QuestionModel;
import com.skooltchdev.multiplechoicequiz.Models.TestModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class AccountingTest {
    List<QuestionModel> questions;
    static TestModel model;
    public AccountingTest() {
        questions = new ArrayList<>();

        questions.add(new QuestionModel("An amount recorded on the left side of a T account is _____.",
                new String[]{"Debit", "Normal Balance", "Credit", "None of the Above"}));

        questions.add(new QuestionModel("A sale on account: ",
                new String[]{"Increases an owner's equity account and increases an asset account ", "Increases a liability account and increases an asset account" +
                        "", "Increases an owner's equity account and increases a liability account" +
                        "", "Increases an owner's equity account and decreases a liability account" +
                        ""}));

                        questions.add(new QuestionModel("The recording of debit and credit parts of a transaction is ____.",
                                new String[]{"Double-entry accounting ", "Accounting",
                                        " Single-entry accounting", "None of the above "}));

        questions.add(new QuestionModel("When the owner withdraws cash, the owner's drawing account is ____.",
                new String[]{"Increased by a debit", "Decreased by a debit ",
                        "Increased by a credit ", "Decreased by a credit "}));

        questions.add(new QuestionModel("The entry to record receipt of cash from the owner as an investment is ____",
                new String[]{"Debit Cash, credit Capital ",
                        "Debit Capital, credit Cash ",
                        "Debit Cash, credit Accounts Payable ",
                        "None of the above"}));



        questions.add(new QuestionModel("The right side of a T account is the ____.",
                new String[]{"Normal balance side",
                        "Debit side ",
                        "Credit side ",
                        "Equity side"}));
        questions.add(new QuestionModel("When the owner withdraws cash for personal use, ____.",
                new String[]{"Assets decrease and owner's equity decreases",
                        "Liabilities decrease and assets decrease",
                        "Assets decrease and owner's equity increases ",
                        "Liabilities increase and assets decrease"}));
        questions.add(new QuestionModel("When cash is received from sales, ____.",
                new String[]{"Assets increase; owner's equity increases",
                        "Assets increase; owner's equity decreases",
                        "Assets decrease; owner's equity decreases",
                        "None of the above"}));
        questions.add(new QuestionModel("A business prepares a balance sheet to report information about ____.",
                new String[]{"The business's assets, liabilities, and owner's equity ",
                        "Profit the business has made for the year ",
                        "Revenue received during a given period of time ",
                        "Expenses incurred during a given period of time "}));

        questions.add(new QuestionModel("If a business paid cash for repairs to equipment, this would ____.",
                new String[]{"Decrease owner's equity ",
                        "Decrease liabilities ",
                        "Increase liabilities ",
                        "Increase owner’s equity"}));


        model = new TestModel("account", "Accounting Test 1", questions);
    }

        public TestModel getModel() {
            return model;
        }
    }
