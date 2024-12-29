package com.example.quiz_service.Model;

import lombok.Data;

@Data
public class QuizDto {
     String categoryName;
     Integer numQuestions;
     String title;

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getCategoryName() {
          return categoryName;
     }

     public void setCategoryName(String categoryName) {
          this.categoryName = categoryName;
     }

     public Integer getNumQuestions() {
          return numQuestions;
     }

     public void setNumQuestions(Integer numQuestions) {
          this.numQuestions = numQuestions;
     }
}
