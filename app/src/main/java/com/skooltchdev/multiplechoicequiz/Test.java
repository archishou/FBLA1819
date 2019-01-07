package com.skooltchdev.multiplechoicequiz;


public class Test {

    private String testTopic;
    private int progress1;
    private int progress2;
    private int progress3;


    public Test(String testTopic, int progress1, int progress2, int progress3) {
        this.testTopic = testTopic;
        this.progress1 = progress1;
        this.progress2 = progress2;
        this.progress3 = progress3;
    }
    public Test()   {
        testTopic = null;
        progress1 = 0;
        progress2 = 0;
        progress3 = 0;
    }

    public String getTestTopic() {
        return testTopic;
    }

    public void setTestTopic(String testTopic) {
        this.testTopic = testTopic;
    }

    public int getProgress1() {
        return progress1;
    }

    public void setProgress1(int progress1) {
        this.progress1 = progress1;
    }

    public int getProgress2() {
        return progress2;
    }

    public void setProgress2(int progress2) {
        this.progress2 = progress2;
    }

    public int getProgress3() {
        return progress3;
    }

    public void setProgress3(int progress3) {
        this.progress3 = progress3;
    }
}
