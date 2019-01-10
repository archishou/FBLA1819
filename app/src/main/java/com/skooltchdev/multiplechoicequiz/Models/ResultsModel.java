package com.skooltchdev.multiplechoicequiz.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class ResultsModel {
    List<String> correctAnswer, givenAnswer;
    List<String> correctAnswerLetter, givenAnswerLetter;
    List<String> questions;
    private int score = 0;
    public ResultsModel () {
        correctAnswer = new ArrayList<>();
        givenAnswer = new ArrayList<>();
        correctAnswerLetter = new ArrayList<>();
        givenAnswerLetter = new ArrayList<>();
        questions = new ArrayList<>();
    }
    public void addEntry(String correct, String chosen, String letterCorrect, String letterGiven, String question) {
        correctAnswer.add(correct);
        givenAnswer.add(chosen);
        correctAnswerLetter.add(letterCorrect);
        givenAnswerLetter.add(letterGiven);
        questions.add(question);
    }

    public List<String> getQuestion() {
        return questions;
    }

    public void setQuestion(List<String> question) {
        this.questions = question;
    }

    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getGivenAnswer() {
        return givenAnswer;
    }

    public List<String> getCorrectAnswerLetter() {
        return correctAnswerLetter;
    }

    public List<String> getGivenAnswerLetter() {
        return givenAnswerLetter;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
