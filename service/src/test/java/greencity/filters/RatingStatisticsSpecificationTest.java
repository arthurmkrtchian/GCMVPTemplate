package greencity.filters;

import greencity.dto.econews.EcoNewsViewDto;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RatingStatisticsSpecificationTest {




    @BeforeEach
    void setUp() {
        EcoNewsViewDto ecoNewsViewDto =
                new EcoNewsViewDto("", "anyTitle", "anyAuthor", "weather", "", "", "News");

        criteriaList = new ArrayList<>();
        criteriaList.add(
                SearchCriteria.builder()
                        .key(EcoNews_.TITLE)
                        .type(EcoNews_.TITLE)
                        .value(ecoNewsViewDto.getTitle())
                        .build());
        criteriaList.add(
                SearchCriteria.builder()
                        .key(EcoNews_.AUTHOR)
                        .type(EcoNews_.AUTHOR)
                        .value(ecoNewsViewDto.getAuthor())
                        .build());
        criteriaList.add(
                SearchCriteria.builder()
                        .key(EcoNews_.TEXT)
                        .type(EcoNews_.TEXT)
                        .value(ecoNewsViewDto.getText())
                        .build());
        criteriaList.add(
                SearchCriteria.builder()
                        .key(EcoNews_.TAGS)
                        .type(EcoNews_.TAGS)
                        .value(ecoNewsViewDto.getTags())
                        .build());

        EcoNews_.tags = tags;
        Tag_.tagTranslations = tagTranslations;
        TagTranslation_.name = name;

        ecoNewsSpecification = new EcoNewsSpecification(criteriaList);
    }

}