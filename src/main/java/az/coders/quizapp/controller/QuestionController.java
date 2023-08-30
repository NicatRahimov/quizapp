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
        return questionService.getAllQuestions();
    }
@GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
      return questionService.getQuestionsByCategory(category);
}
@PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
}
@PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id,@RequestBody Question question) {
        return questionService.updateData(id,question);
}
}
