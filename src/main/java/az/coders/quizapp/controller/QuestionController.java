package az.coders.quizapp.controller;

import az.coders.quizapp.model.Question;
import az.coders.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), OK );
    }

@GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
      return new ResponseEntity<>(questionService.getQuestionsByCategory(category),HttpStatus.OK);
}

@PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return new ResponseEntity<>("Added succesful",HttpStatus.OK);
}

@PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id,@RequestBody Question question){
        return new ResponseEntity<>(questionService.updateData(id,question),HttpStatus.OK);
}

}
