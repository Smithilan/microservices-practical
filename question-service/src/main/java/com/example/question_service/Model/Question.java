package com.example.question_service.Model;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String a;
    private String b;
    private String c;
    private String d;
    private String correctAnswer;
    private String category;
    private String difficultyLevel;

    // Getter and Setter for 'id'
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for 'questionTitle'
    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    // Getter and Setter for 'a'
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    // Getter and Setter for 'b'
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    // Getter and Setter for 'c'
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    // Getter and Setter for 'd'
    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    // Getter and Setter for 'correctAnswer'
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    // Getter and Setter for 'category'
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and Setter for 'difficultyLevel'
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
