package az.coders.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String questionTitle;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;
}
