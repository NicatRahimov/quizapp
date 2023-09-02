package az.coders.quizapp.exception;

public class QuizNotFound extends RuntimeException{
    public QuizNotFound(String message) {
        super(message);
    }
}
