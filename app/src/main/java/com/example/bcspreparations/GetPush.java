package com.example.bcspreparations;

import java.util.ArrayList;
import java.util.List;

public class GetPush {
    public  String id,question,firstOption,secondOption,thirdOption, fourthOption, answer;
    int flag;
    private static List<GetPush>gp = new ArrayList<>();

    public GetPush() {
    }

    public GetPush(String question, String firstOption, String secondOption,
                   String thirdOption, String fourthOption, String answer) {
        this.question = question;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.thirdOption = thirdOption;
        this.fourthOption = fourthOption;
        this.answer = answer;
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

    public static void addToList(GetPush getPush){
        gp.add(getPush);
    }
}
