package greencity.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import greencity.dto.habittranslation.HabitTranslationDto;
import greencity.entity.HabitTranslation;
import greencity.entity.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class HabitTranslationDtoMapperTest {
    private HabitTranslationDtoMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new HabitTranslationDtoMapper();
    }

    @Test
    void convertTest() {
        Language language = mock(Language.class);
        HabitTranslation habitTranslation = HabitTranslation.builder()
                .name("Test Habit")
                .description("This is a test habit.")
                .habitItem("Test Item")
                .language(language)
                .build();

        HabitTranslationDto habitTranslationDto = mapper.convert(habitTranslation);

        assertEquals(habitTranslation.getName(), habitTranslationDto.getName());
        assertEquals(habitTranslation.getDescription(), habitTranslationDto.getDescription());
        assertEquals(habitTranslation.getHabitItem(), habitTranslationDto.getHabitItem());
        assertEquals(language.getCode(), habitTranslationDto.getLanguageCode());
    }

    @Test
    void mapAllToListTest() {
        Language language = mock(Language.class);
        HabitTranslation habitTranslation1 = HabitTranslation.builder()
                .name("Test Habit 1")
                .description("This is a test habit 1.")
                .language(language)
                .habitItem("Test Item 1")

                .build();
        HabitTranslation habitTranslation2 = HabitTranslation.builder()
                .name("Test Habit 2")
                .description("This is a test habit 2.")
                .habitItem("Test Item 2")
                .language(language)
                .build();
        List<HabitTranslation> habitTranslationList = Arrays.asList(habitTranslation1, habitTranslation2);

        List<HabitTranslationDto> habitTranslationDtoList = mapper.mapAllToList(habitTranslationList);

        assertEquals(habitTranslationList.size(), habitTranslationDtoList.size());
        assertEquals(habitTranslationList.get(0).getName(), habitTranslationDtoList.get(0).getName());
        assertEquals(habitTranslationList.get(1).getDescription(), habitTranslationDtoList.get(1).getDescription());
        assertEquals(habitTranslationList.get(0).getHabitItem(), habitTranslationDtoList.get(0).getHabitItem());
        assertEquals(habitTranslationList.get(0).getLanguage().getCode(), habitTranslationDtoList.get(0).getLanguageCode());
    }
}
