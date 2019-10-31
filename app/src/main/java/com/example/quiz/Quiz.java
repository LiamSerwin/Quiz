package com.example.quiz;

import java.util.List;

public class Quiz {
    private String question;
    private List<Question> questions;
    private boolean answer;
    private int questionNumber;
    private int score;

    public Quiz(List<com.example.quiz.Question> questions){
        question = questions.get(0).getQuestion();
        score = 0;
        questionNumber = 0;
        this.questions = questions;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public boolean checkAnswer(boolean answer) {

        if(questions.get(questionNumber).getAnswer() == answer){
            score++;
            return true;

        }
        else{
            return false;
        }



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

    public void nextQuestion() {
        setQuestionNumber(getQuestionNumber()+1);
        question = questions.get(getQuestionNumber()).getQuestion();

    }
    public boolean haveMoreQuestions(){
        if(questionNumber+1<=questions.size()-1){
            return true;
        }
        else{
            return false;
        }

    }

    public List getQuestionList(){return questions;}

    public void setQuestion(String question) {
        this.question = question;
    }
}
