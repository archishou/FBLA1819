package com.skooltchdev.multiplechoicequiz;


public class QuizModel {
    private String title;
    // Formatted Question, Answer.
    // Answer is formatted is the following
    // "Answer:C2:C3:C4"
    private String[] questionsAnswers;

    public QuizModel(String title, String[] questionsAnswers) {
        this.title = title;
        this.questionsAnswers = questionsAnswers;
    }

    public String getTitle() {
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
