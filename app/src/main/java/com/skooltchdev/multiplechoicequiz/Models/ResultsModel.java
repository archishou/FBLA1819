package com.skooltchdev.multiplechoicequiz.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class ResultsModel {
    List<String> correctAnswer, givenAnswer;

    public ResultsModel () {
        correctAnswer = new ArrayList<>();
        givenAnswer = new ArrayList<>();
    }
    public void addEntry(String correct, String chosen) {
        correctAnswer.add(correct);
        givenAnswer.add(chosen);
    }

    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getGivenAnswer() {
        return givenAnswer;
    }
}
