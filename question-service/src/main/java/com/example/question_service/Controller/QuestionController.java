package com.example.question_service.Controller;


import com.example.question_service.Model.Question;
import com.example.question_service.Model.QuestionWrapper;
import com.example.question_service.Model.Response;
import com.example.question_service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("Category/{Category}")
    public List<Question> getAllQuestionByCategory(@PathVariable String Category){
        return questionService.getAllQuestionByCategory(Category);
    }

    @GetMapping("difficultyLevel/{difficultyLevel}")
    public List<Question> getAllQuestionByLevel(@PathVariable String difficultyLevel){
        return questionService.getAllQuestionBYLevel(difficultyLevel);
    }

    @GetMapping("Id/{id}")
    public Optional<Question> getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

    @GetMapping("Generate") // return the questionIds from db for requesting category and num of question
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam int numQuestion){
        return questionService.getQuizQuestion(categoryName,numQuestion);
    }

    @PostMapping("getQuestion")// return the question
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
        return questionService.getScore(response);
    }

}
