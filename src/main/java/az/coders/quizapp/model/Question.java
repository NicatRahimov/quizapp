package az.coders.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "question_title")
    private String questionTitle;
    @Column(name = "first_option")
    private String firstOption;
    @Column(name = "second_option")
    private String secondOption;
    @Column(name = "third_option")
    private String thirdOption;
    @Column(name = "fourth_option")
    private String fourthOption;
    @Column(name = "right_answer")
    private String rightAnswer;
    @Column(name = "difficulty_level")
    private Integer difficultyLevel;
    @Column(name ="category")
    private String category;
}
