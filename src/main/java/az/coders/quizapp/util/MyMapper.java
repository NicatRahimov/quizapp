package az.coders.quizapp.util;

import az.coders.quizapp.dto.QuestionDTO;
import az.coders.quizapp.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyMapper {

    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);
    @Mapping(source = "questionTitle",target = "questionTitle")
    @Mapping(source = "firstOption",target = "firstOption")
    @Mapping(source = "secondOption",target = "secondOption")
    @Mapping(source = "thirdOption",target = "thirdOption")
    @Mapping(source = "fourthOption",target = "fourthOption")
    @Mapping(source = "id",target = "id")
    QuestionDTO entityToDto(Question entity);

    @Mapping(source = "questionTitle",target = "questionTitle")
    @Mapping(source = "firstOption",target = "firstOption")
    @Mapping(source = "secondOption",target = "secondOption")
    @Mapping(source = "thirdOption",target = "thirdOption")
    @Mapping(source = "fourthOption",target = "fourthOption")
    @Mapping(source = "id",target = "id")
    Question dtoToEntity(QuestionDTO dto);
}