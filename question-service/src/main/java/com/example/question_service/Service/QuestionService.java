package com.example.question_service.Service;


import com.example.question_service.Model.Question;
import com.example.question_service.Model.QuestionWrapper;
import com.example.question_service.Model.Response;
import com.example.question_service.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    public ResponseEntity<List<Question>> getAllQuestion(){
        try{
            return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public List<Question> getAllQuestionByCategory(String Category) {
        return questionRepository.findByCategory( Category);
    }

    public List<Question> getAllQuestionBYLevel(String difficultyLevel) {
        return questionRepository.findByDifficultyLevel(difficultyLevel);
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            // Save the question object
            questionRepository.save(question);

            // Return a success message as a String
            return new ResponseEntity<>("Question added successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed to add Question", HttpStatus.OK);
    }


    public ResponseEntity<List<Integer>> getQuizQuestion(String categoryName, int numQuestion) {
        List<Integer> question= questionRepository.findRandomQuestionByCategory(categoryName,numQuestion);
        return new ResponseEntity<>(question,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {

        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for (Integer id : questionIds){
            questions.add(questionRepository.findById(id).get());
        }

        for (Question q : questions){
            QuestionWrapper qw = new QuestionWrapper();
            qw.setId(q.getId());
            qw.setQuestionTitle(q.getQuestionTitle());
            qw.setA(q.getA());
            qw.setB(q.getB());
            qw.setC(q.getC());
            qw.setD(q.getD());

            wrappers.add(qw);
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> response) {

        int marks = 0;
        for(Response r :response) {
            Question q = questionRepository.findById(r.getId()).get();
            if (r.getResponse().equals(q.getCorrectAnswer()))
                marks++;
        }
        return new ResponseEntity<>(marks,HttpStatus.OK);
    }
}