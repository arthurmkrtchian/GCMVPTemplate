package greencity.filters;

import greencity.entity.HabitFact;
import greencity.filters.HabitFactSpecification;
import greencity.filters.SearchCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HabitFactSpecificationTest {

    @Test
    public void testToPredicate() {
        // Mocking necessary objects
        Root<HabitFact> root = mock(Root.class);
        CriteriaQuery<?> criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        Predicate predicate = mock(Predicate.class);

        // Creating a list of search criteria
        List<SearchCriteria> searchCriteriaList = new ArrayList<>();
        searchCriteriaList.add(new SearchCriteria("id", "1", "numeric"));
        searchCriteriaList.add(new SearchCriteria("habitId", "2", "numeric"));
        searchCriteriaList.add(new SearchCriteria("content", "example", "string"));

        // Mocking the behavior of the criteriaBuilder
        when(criteriaBuilder.and(predicate, predicate)).thenReturn(predicate);

        // Creating the HabitFactSpecification
        HabitFactSpecification specification = new HabitFactSpecification(searchCriteriaList);

        // Calling toPredicate and capturing the result
        Predicate result = specification.toPredicate(root, criteriaQuery, criteriaBuilder);

        // Asserting that the result is as expected
        assertEquals(predicate, result);
    }
}
