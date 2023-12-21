package org.example.service;

import org.example.entity.Filter;
import org.example.entity.FilterCondition;
import org.example.entity.FilterCriteria;
import org.example.entity.FilterOption;
import org.example.repository.FilterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@SpringBootTest
class FilterServiceImplTest {

    @Autowired
    private FilterService service;

    @Autowired
    private FilterRepository repository;

    @Test
    @Transactional
    void testCreateFilter() {
        FilterCriteria criteria = new FilterCriteria();
        criteria.setFilterOption(FilterOption.AMOUNT);
        criteria.setCondition(FilterCondition.MORE);
        criteria.setSearchValue("5");

        Filter filter = new Filter();
        filter.setName("New Filter 1");
        filter.setFilterCriteria(Collections.singletonList(criteria));

        Filter savedFilter = service.createNewFilter(filter);
        Assertions.assertNotNull(savedFilter.getId());
        Assertions.assertEquals(filter.getName(), savedFilter.getName());

        FilterCriteria savedCriteria = savedFilter.getFilterCriteria().iterator().next();
        Assertions.assertNotNull(savedCriteria.getId());
        Assertions.assertEquals(criteria.getFilterOption(), savedCriteria.getFilterOption());
        Assertions.assertEquals(criteria.getCondition(), savedCriteria.getCondition());
        Assertions.assertEquals(criteria.getSearchValue(), savedCriteria.getSearchValue());
    }

}