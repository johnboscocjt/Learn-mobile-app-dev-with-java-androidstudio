package com.example.mathapp;

//class to show different questions
public class QuestionBank {
    //declaring variables
    private int question;
    private boolean trueQuestion;

    //declare the constructor class for the class
    public QuestionBank(int question, boolean trueQuestion){
        //passing the two parameters which initialize the variables
        this.question = question;
        this.trueQuestion = trueQuestion;

    }

//setter and getter methods
    public int getQuestion(){
        return question;
    }

    public void setQuestion(int question){
        this.question = question;
    }

    public boolean istrueQuestion(){
        return trueQuestion;
    }
    public void settrueQuestion(boolean trueQuestion){
        this.trueQuestion = trueQuestion;
    }
}