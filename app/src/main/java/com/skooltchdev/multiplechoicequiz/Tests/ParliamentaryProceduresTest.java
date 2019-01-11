package com.skooltchdev.multiplechoicequiz.Tests;

import com.skooltchdev.multiplechoicequiz.Models.QuestionModel;
import com.skooltchdev.multiplechoicequiz.Models.TestModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class ParliamentaryProceduresTest {
    List<QuestionModel> questions;
    static TestModel model;
    public ParliamentaryProceduresTest() {
        questions = new ArrayList<>();

        questions.add(new QuestionModel("The five administrative regions of FBLA include all but which of the following?",
                    new String[]{"Central", "Western", "Eastern", "Southern"}));

        questions.add(new QuestionModel("No two national officers can be elected from the same?",
                new String[]{"State", "Region", "City", "County"}));

        questions.add(new QuestionModel("The tellers' report should not include which of the following?",
                new String[]{"The number of members eligible to vote.", "The number of votes against.",
                        "The number of votes cast.", "The number necessary for adoption."}));

        questions.add(new QuestionModel("When a committee is named by the assembly without designating a chairman...",
                new String[]{"The committee elects its own chairman.", "The body that elected the committee members names the chairman.",
                        "The chairman is the first-named member of the committee.", "The chair names the chairman."}));

        questions.add(new QuestionModel("If previous notice is to be given at a meeting...",
                new String[]{"It is in order to do so even after it has been voted to adjourn.",
                        "The notice is in order when another person has been assigned the floor and has begun to",
                        "The full text of the motion or resolution must be submitted.",
                        "It must be in writing."}));

        model = new TestModel("parliment", "Parliamentary Procedures Test 1", questions);
    }

    public TestModel getModel() {
        return model;
    }
}
