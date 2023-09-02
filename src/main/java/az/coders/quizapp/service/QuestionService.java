package az.coders.quizapp.service;

import az.coders.quizapp.dao.QuestionDAO;
import az.coders.quizapp.model.Question;
import az.coders.quizapp.util.NullChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

        }
    }


    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        try{
            return new ResponseEntity<>(questionDAO.getQuestionsByCategory(category),HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDAO.save(question);
            return new ResponseEntity<>("Added succesfull!",HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("There was problem when add question",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Question> updateData(Long id, Question question) {
        Question question1 = questionDAO.findById(id).get();
        if (NullChecker.ifNotNull(question.getQuestionTitle())){
            question1.setQuestionTitle(question.getQuestionTitle());
        }
        if (NullChecker.ifNotNull(question.getCategory())){
            question1.setCategory(question.getCategory());
        }
        if (NullChecker.ifNotNull(question.getDifficultyLevel())){
            question1.setDifficultyLevel(question.getDifficultyLevel());
        }
        if (NullChecker.ifNotNull(question.getFirstOption())){
            question1.setFirstOption(question.getFirstOption());
        }
        if (NullChecker.ifNotNull(question.getSecondOption())){
            question1.setSecondOption(question.getSecondOption());
        }
        if (NullChecker.ifNotNull(question.getThirdOption())){
            question1.setThirdOption(question.getThirdOption());
        }
        if (NullChecker.ifNotNull(question.getFourthOption())){
            question1.setFourthOption(question.getFourthOption());
        }
        if (NullChecker.ifNotNull(question.getRightAnswer())){
            question1.setRightAnswer(question.getRightAnswer());
        }
        questionDAO.save(question1);
        return new ResponseEntity<>(question1,HttpStatus.OK);
    }
}
