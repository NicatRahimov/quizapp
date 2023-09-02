package az.coders.quizapp.controller;
import az.coders.quizapp.dto.QuestionDTO;
import az.coders.quizapp.model.Quiz;
import az.coders.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title) {
        return quizService.createQuizByCategory(category, numQ, title);
    }
@GetMapping("getQuiz/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id){
       return quizService.getQuizById(id);
    }
    @GetMapping("/getAllQuiz")
    public ResponseEntity<List<Quiz>> getQuiz() {
        return quizService.getAllQuiz();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
      return quizService.deleteById(id);
    }

    @GetMapping("getQuestions")
    public ResponseEntity<List<QuestionDTO>> getQuestionsForUser(@RequestParam Integer numQ,
                                                                 @RequestParam String category){
        return quizService.getQuestionDTOs(numQ,category);
    }}


