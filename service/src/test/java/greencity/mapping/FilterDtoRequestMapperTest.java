package greencity.mapping;

import greencity.dto.user.UserFilterDtoRequest;
import greencity.entity.Filter;
import greencity.enums.FilterType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static greencity.ModelUtils.getUserFilterDtoRequest;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class FilterDtoRequestMapperTest {
    @InjectMocks
    private FilterDtoRequestMapper mapper;

    @Test
    void convertTest() {
        UserFilterDtoRequest userFilterDtoRequest = getUserFilterDtoRequest();
        Filter actual = mapper.convert(userFilterDtoRequest);
        StringBuilder values = new StringBuilder(userFilterDtoRequest.getSearchCriteria());
        values.append(";");
        values.append(userFilterDtoRequest.getUserRole());
        values.append(";");
        values.append(userFilterDtoRequest.getUserStatus());

        assertEquals(userFilterDtoRequest.getName(), actual.getName());
        assertEquals(actual.getType(), FilterType.USERS.toString());
        assertEquals(actual.getValues(), values.toString());
    }
}