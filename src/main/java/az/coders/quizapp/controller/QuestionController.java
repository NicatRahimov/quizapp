package az.coders.quizapp.controller;

import az.coders.quizapp.dao.QuestionDAO;
import az.coders.quizapp.model.Question;
import az.coders.quizapp.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("question")

public class QuestionController {


    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionDAO questionDAO;



    @GetMapping("/allQuestion")
    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation =Question.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Question not found",
                    content = @Content) })
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/filter")
    public Page<Question> filterBooks(@ParameterObject Pageable pageable) {
        return questionDAO.findAll(pageable);
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
