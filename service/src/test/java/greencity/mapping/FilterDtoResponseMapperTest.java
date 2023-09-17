package greencity.mapping;

import greencity.dto.user.UserFilterDtoResponse;
import greencity.entity.Filter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static greencity.ModelUtils.getFilter;
import static greencity.ModelUtils.getUserFilterDtoResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class FilterDtoResponseMapperTest {
    @InjectMocks
    private FilterDtoResponseMapper mapper;

    @Test
    void convertTest() {
        Filter filter = getFilter();

        UserFilterDtoResponse expected = getUserFilterDtoResponse();

        assertEquals(expected, mapper.convert(filter));
    }
}