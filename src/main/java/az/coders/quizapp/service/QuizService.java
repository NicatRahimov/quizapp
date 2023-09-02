package az.coders.quizapp.service;

import az.coders.quizapp.dao.QuestionDAO;
import az.coders.quizapp.dao.QuizDAO;
import az.coders.quizapp.exception.QuizNotFound;
import az.coders.quizapp.model.Question;
import az.coders.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizService {
    @Autowired
    QuizDAO quizDAO;
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuizByCategory(String category, Integer numQ, String title) {
        List<Question>questions = questionDAO.findRandomlyByCategory(category,numQ);
                Quiz quiz = new Quiz();
                quiz.setTitle(title);
                quiz.setQuestions(questions);
                quizDAO.save(quiz);
                return new ResponseEntity<>("Succes", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Quiz>> getAllQuiz() {
       List<Quiz>quizzes = quizDAO.findAll();
       return new ResponseEntity<>(quizzes,HttpStatus.OK);
    }

    public ResponseEntity<Quiz> getQuizById(Long id) {
       if (quizDAO.findById(id).isPresent()){
           return new ResponseEntity<>(quizDAO.findById(id).get(),HttpStatus.OK);
       }else {
           throw new QuizNotFound("Quiz not have such id.");
       }

    }

    public ResponseEntity<String> deleteById(Long id) {
        quizDAO.deleteById(id);
        return new ResponseEntity<>("Deleted succesfully",HttpStatus.OK);
    }
}
