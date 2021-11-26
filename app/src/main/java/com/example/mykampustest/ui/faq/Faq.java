package com.example.mykampustest.ui.faq;

public class Faq {
    private String question;
    private String answer;

    Faq(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
