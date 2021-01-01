package com.example.bcspreparations;

public class TestQuestionList {
    public  String id,question,firstOption,secondOption,thirdOption, fourthOption, answer;
    public int flag;

    public TestQuestionList(String id, String question, String firstOption, String secondOption, String thirdOption, String fourthOption, String answer, int flag) {
        this.id = id;
        this.question = question;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.thirdOption = thirdOption;
        this.fourthOption = fourthOption;
        this.answer = answer;
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(String firstOption) {
        this.firstOption = firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(String secondOption) {
        this.secondOption = secondOption;
    }

    public String getThirdOption() {
        return thirdOption;
    }

    public void setThirdOption(String thirdOption) {
        this.thirdOption = thirdOption;
    }

    public String getFourthOption() {
        return fourthOption;
    }

    public void setFourthOption(String fourthOption) {
        this.fourthOption = fourthOption;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
