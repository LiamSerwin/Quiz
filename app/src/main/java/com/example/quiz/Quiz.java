package com.example.quiz;

import java.util.List;

public class Quiz {
    private String question;
    private List<com.example.quiz.Question> questions;
    private boolean answer;
    private int questionNumber;
    private int score;

    public Quiz(List<com.example.quiz.Question> questions){
        score = 0;
        questionNumber = 0;
        this.questions = questions;
    }

    public void setQuestions(List<com.example.quiz.Question> questions) {
        this.questions = questions;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
