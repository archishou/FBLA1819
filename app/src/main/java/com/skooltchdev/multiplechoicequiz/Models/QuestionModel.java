package com.skooltchdev.multiplechoicequiz.Models;


public class QuestionModel {
    private String title;
    // Formatted Question, Answer.
    // Answer is formatted is the following
    // "Answer:C2:C3:C4"
    private String[] questionsAnswers;

    public QuestionModel(String question, String[] questionsAnswers) {
        this.title = question;
        this.questionsAnswers = questionsAnswers;
    }

    public String getQuestion() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getQuestionsAnswers() {
        return questionsAnswers;
    }

    public void setQuestionsAnswers(String[] questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }
}
