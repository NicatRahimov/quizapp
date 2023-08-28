package az.coders.quizapp.service;

import az.coders.quizapp.dao.QuestionDAO;
import az.coders.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public List<Question> getAllQuestions() {
return questionDAO.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
      return questionDAO.getQuestionsByCategory(category);
    }
}
