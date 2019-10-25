package com.example.quiz;

public class Question {
    private String question;
    private boolean answer;

    public Question() {
    }

    public String getQuestion(){
        return question;
    }
    public boolean getAnswer(){
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question=" + question + '\'' + ",answer=" + answer +
                '}';
    }
}
