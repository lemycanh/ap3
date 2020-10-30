package com.uni.geoquiz.models;

public class Question {
    private String content;
    private Boolean answer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public Question() {
    }

    public Question(String content, Boolean answer) {
        this.content = content;
        this.answer = answer;
    }
}
