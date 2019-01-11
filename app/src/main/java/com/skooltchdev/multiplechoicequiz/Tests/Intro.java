package com.skooltchdev.multiplechoicequiz.Tests;

import com.skooltchdev.multiplechoicequiz.Models.QuestionModel;
import com.skooltchdev.multiplechoicequiz.Models.TestModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class Intro {
    List<QuestionModel> questions;
    static TestModel model;
    public Intro() {
        questions = new ArrayList<>();

        questions.add(new QuestionModel("Key words found in the FBLA goals include:",
                    new String[]{"Confidence, understanding, efficient, scholarship ", "Seek, sincere, abide, initiative ", "Promise, aims, qualities, active ", "Manner, directors, regulations, cooperation "}));

        questions.add(new QuestionModel("In the last paragraph of the FBLA Creed, the following statement is made:",
                new String[]{"I promise to use my abilities ", "I agree to do my utmost", "Every person should actively", "Every person should prepare"}));

        questions.add(new QuestionModel("The National Awards Program (NAP) provides events based on:",
                new String[]{"Goals of FBLA-PBL and curriculum of business education programs", " National office requests ",
                        " Guidelines in the Chapter Management Handbook", "Bylaws and goals of FBLA-PBL"}));

        questions.add(new QuestionModel("In the performance event presentations:",
                new String[]{"The leader of the group presents all information", "All team members actively participate ",
                        "One member is designated to answer the judges questions ", " Each team member has five minutes to speak"}));

        questions.add(new QuestionModel("A parliamentary procedure team can have ______ repeat members from a previous National Leadership Conference team.",
                new String[]{“Two",
                        "One",
                        "Three",
                        "None"}));

        questions.add(new QuestionModel("Handbooks for officers can be purchased from:",
                    new String[]{"MarketPlace", "Barnes and Nobles ", "NAP Committee", "Board of directors"}));

        questions.add(new QuestionModel("The Chapter Management Handbook updates are revised and distributed:",
                    new String[]{"Once a year", "As needed ", "Twice a year ", "Every two years"}));

        questions.add(new QuestionModel("National celebrations include each of the following except:",	
                    new String[]{"March of Dimes Day", "FBLA-PBL Week", "American Enterprise Day ", "FBLA-PBL Community Service Day"}));

        questions.add(new QuestionModel("FBLA-PBL week is the second week in:",
                    new String[]{"February ", "January ", "March ", "April"}));

        questions.add(new QuestionModel("The National Fall Leadership Conferences are held in:",
                    new String[]{"November ", "September ", "October ", "December"}));


        model = new TestModel("parliment", "IntroFBLA", questions);
    }

    public TestModel getModel() {
        return model;
    }
}
