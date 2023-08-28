package az.coders.quizapp.controller;

import az.coders.quizapp.model.Question;
import az.coders.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), OK );
    }

@GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getSpecifiedQuestions(@PathVariable String category){
      return new ResponseEntity<>(questionService.getQuestionsByCategory(category),HttpStatus.OK);
}

}
