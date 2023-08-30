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

    public void addQuestion(Question question) {
        questionDAO.save(question);
    }

    public Question updateData(Long id, Question question) {
        Question question1 = questionDAO.findById(id).get();
        question1.setQuestionTitle(question.getQuestionTitle());
        question1.setCategory(question.getCategory());
        question1.setDifficultyLevel(question.getDifficultyLevel());
        question1.setFirstOption(question.getFirstOption());
        question1.setSecondOption(question.getSecondOption());
        question1.setThirdOption(question.getThirdOption());
        question1.setFourthOption(question.getFourthOption());
        question1.setRightAnswer(question.getRightAnswer());
        questionDAO.save(question1);
        return question1;
    }
}
