package com.skooltchdev.multiplechoicequiz.Models;

import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class TestModel {
    String title;
    String branch;
    List<QuestionModel> questions;

    public TestModel(String branch, String title, List<QuestionModel> questions) {
        this.title = title;
        this.questions = questions;
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }
}
