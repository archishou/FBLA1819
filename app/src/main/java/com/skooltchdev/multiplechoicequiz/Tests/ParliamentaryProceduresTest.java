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
        questions.add(new QuestionModel("The amendment to add or insert a paragraph may ",
                new String[]{"be amended after adoption by adding words not in conflict.", " have a primary and secondary amendment.",
                        " be amended after adoption by inserting words not in a conflict.", "be made only by the maker of the primary amendment."}));
        questions.add(new QuestionModel("Which of the following statements, concerning a member's right to speak and vote, is correct?",
                new String[]{"A member may vote for or against his motion.", " A speaker is required to speak for his motion.",
                        "A member may not speak against his own motion unless through amendment it becomes " +
                                "a different question.", " A member may vote and speak as he chooses so long as his debate is germane."}));
        questions.add(new QuestionModel("Which article in the FBLA bylaws describes the information about FBLA dues?",
                new String[]{"Article IV", "Article III",
                        "Article VI", "Article V"}));
        questions.add(new QuestionModel("A board has the character of a deliberative assembly, except ",
                new String[]{"All answers are correct.", " its powers are delegated to it by an authority outside itself.",
                        " boards have no minimum size and are frequently smaller than most other assemblies.", " it may or may not function autonomously."}));
        questions.add(new QuestionModel("In case of a tie vote on an ordinary main motion ",
                new String[]{"The motion is lost.", " another vote must be taken.",
                        " The presiding officer, who is a member, must vote to break the tie.", " The vote can be reconsidered if moved by one who voted in the affirmative."}));


        model = new TestModel("parliment", "Parliamentary Procedures Test 1", questions);
    }

        public TestModel getModel() {
            return model;
        }
    }
