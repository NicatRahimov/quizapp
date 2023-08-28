package az.coders.quizapp.dao;

import az.coders.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Long> {
    List<Question> getQuestionsByCategory(String category);
}
