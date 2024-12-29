package com.example.question_service.Repository;


import com.example.question_service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question>findByCategory(String Category);
    List<Question>findByDifficultyLevel(String difficultyLevel);

    @Query (value = "SELECT q.id FROM question q Where q.category =:categoryName ORDER BY RANDOM() LIMIT :numQuestion", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String categoryName, int numQuestion);
}
