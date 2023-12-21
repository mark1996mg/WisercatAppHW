package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Filter;
import org.example.entity.FilterCondition;
import org.example.entity.FilterCriteria;
import org.example.entity.FilterOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootTest
class FilterControllerTest {

    @Autowired
    private FilterController controller;

    public static final String FILTER_NAME = "New Filter 1";
    public static final FilterOption FILTER_OPTION = FilterOption.TITLE;
    public static final FilterCondition FILTER_CONDITION = FilterCondition.STARTS_WITH;
    public static final String SEARCH_VALUE = "Clean Programming";

    @Test
    void testCreateNewFilter() throws JsonProcessingException {
        String restaurantScheduleJson = createJsonInput();
        ObjectMapper objectMapper = new ObjectMapper();
        Filter filter = objectMapper.readValue(restaurantScheduleJson, Filter.class);

        Filter savedFilter = controller.createNewFilter(filter);
        Assertions.assertNotNull(savedFilter.getId());
        Assertions.assertEquals(FILTER_NAME, savedFilter.getName());

        List<FilterCriteria> filterCriteria = savedFilter.getFilterCriteria();
        Assertions.assertEquals(1, filterCriteria.size());
        Assertions.assertEquals(FILTER_OPTION, filterCriteria.iterator().next().getFilterOption());
        Assertions.assertEquals(FILTER_CONDITION, filterCriteria.iterator().next().getCondition());
        Assertions.assertEquals(SEARCH_VALUE, filterCriteria.iterator().next().getSearchValue());

        List<Filter> allFilters = controller.getAllFilters().stream()
            .filter(f -> Objects.equals(savedFilter.getId(), f.getId()))
            .collect(Collectors.toList());
        Assertions.assertEquals(1, allFilters.size());
        Assertions.assertEquals(savedFilter, allFilters.iterator().next());
    }

    private String createJsonInput() {
        return String.format(
            """
            {
                "name": "%s",
                "filterCriteria": [
                    {
                        "filterOption": "%s",
                        "condition": "%s",
                        "searchValue": "%s"
                    }
                ]
            }
            """
        , FILTER_NAME, FILTER_OPTION, FILTER_CONDITION, SEARCH_VALUE);
    }

}