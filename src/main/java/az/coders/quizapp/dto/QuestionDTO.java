package az.coders.quizapp.dto;

import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String questionTitle;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;
}
