package com.example.quiz_service.Service;


import com.example.quiz_service.Feign.QuizInterface;
import com.example.quiz_service.Model.QuestionWrapper;
import com.example.quiz_service.Model.Quiz;
import com.example.quiz_service.Model.Response;
import com.example.quiz_service.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz( String categoryName, int numQuestion, String title) { // for Admin to create quiz

       List<Integer> questionIds = quizInterface.getQuestionForQuiz(categoryName,numQuestion).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);

        quizRepository.save(quiz);

        return new ResponseEntity<>("Sucess" , HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) { // for user get quiz by quiz id

        Quiz quiz =quizRepository.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();

        ResponseEntity<List<QuestionWrapper>>questionForUser = quizInterface.getQuestionFromId(questionIds);
        return questionForUser;
    }


    public ResponseEntity<Integer> culculateResult(Integer id, List<Response> response) {
        ResponseEntity<Integer> marks = quizInterface.getScore(response);
        return marks;

    }


}
