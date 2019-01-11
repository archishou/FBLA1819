package com.skooltchdev.multiplechoicequiz.Tests;

import com.skooltchdev.multiplechoicequiz.Models.QuestionModel;
import com.skooltchdev.multiplechoicequiz.Models.TestModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class HistoryFBLA {
    List<QuestionModel> questions;
    static TestModel model;
    public HistoryFBLA() {
        questions = new ArrayList<>();

        questions.add(new QuestionModel("Who founded FBLA?",
                    new String[]{"Hamden L. Forkner", "Edward D. Miler", "Lyndon B. Johnson", "Frances Brown"}));

        questions.add(new QuestionModel("What year was the concept of FBLA developed?",
                new String[]{"1937", "1932", "1945", "1930"}));

        questions.add(new QuestionModel("What college, university, and city were the concept of FBLA envisioned?",
                new String[]{"Teachers College, Columbia University, New York City ", " Columbia Business School, Columbia University, New York City ",
                        "College of Arts and Sciences, Cornell University, Ithaca ", " SC Johnson College of Business, Cornell University, Ithaca"}));

        questions.add(new QuestionModel("What school chartered the first experimental chapter of FBLA?",
                new String[]{"Science Hill High School", "George Middleton High School",
                        "Academy of Science and Design", "Henry B. Plant High School"}));

        questions.add(new QuestionModel("What state became the first FBLA state chapter?",
                new String[]{"Iowa",
                        "Michigan",
                        "Tennessee.",
                        "New Hampshire"}));
        questions.add(new QuestionModel("When was the postsecondary division, Phi Beta Lambda (PBL) created?",
                new String[]{"1958",
                        "1972",
                        "1966.",
                        "1931"}));
        questions.add(new QuestionModel("Who was the first full-time executive director of FBLA-PBL?",
                new String[]{"Edward D. Miller",
                        "Frances Brown",
                        "Hamden L. Forkner.",
                        "Kevin O’Leary"}));
        questions.add(new QuestionModel("What is an alternative name to the Professional Division?",
                new String[]{"Alumni Division",
                        "Executive Divison",
                        "Alumni Level.",
                        "Executive Level"}));
        questions.add(new QuestionModel("When was the Alumni Division formed?",
                new String[]{"1947",
                        "1932",
                        "1945.",
                        "1955"}));

        questions.add(new QuestionModel("When was the FBLA-Middle Level division formed?",
                new String[]{"1994",
                        "1952",
                        "1967.",
                        "1989"}));


        model = new TestModel("parliment", "Parliamentary Procedures Test 1", questions);
    }

    public TestModel getModel() {
        return model;
    }
}
