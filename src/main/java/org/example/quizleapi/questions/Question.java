package org.example.quizleapi.questions;

public interface Question {

    //default is 6
    int requestedQuestions(int numberOfQuestions);


    //list of questions for not asking again
    Question getQuestionsAnsweredCorrectly(Question questionAnsweredCorrectly);


    //return a set of available questions
    Question questionsAvailable(int numberOfQuestions, Question questionsAnsweredCorrectly);


    //return a set of correctly answered questions
    Question questionsAlreadyAnswered(Question questionsAnsweredCorrectly);
}
