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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
        filter.setName("New Filter");
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

    @Test
    @Transactional
    void testThrowsExceptionIfFilterNameIsNull() {
        FilterCriteria criteria = new FilterCriteria();
        criteria.setFilterOption(FilterOption.AMOUNT);
        criteria.setCondition(FilterCondition.MORE);
        criteria.setSearchValue("5");

        Filter filter = new Filter();
        filter.setName(null);
        filter.setFilterCriteria(Collections.singletonList(criteria));

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> service.createNewFilter(filter));
    }

    @Test
    @Transactional
    void testThrowsExceptionIfFilterCriteriaOptionIsNull() {
        FilterCriteria criteria = new FilterCriteria();
        criteria.setFilterOption(null);
        criteria.setCondition(FilterCondition.MORE);
        criteria.setSearchValue("5");

        Filter filter = new Filter();
        filter.setName("New Filter");
        filter.setFilterCriteria(Collections.singletonList(criteria));

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> service.createNewFilter(filter));
    }

    @Test
    @Transactional
    void testThrowsExceptionIfFilterCriteriaConditionIsNull() {
        FilterCriteria criteria = new FilterCriteria();
        criteria.setFilterOption(FilterOption.AMOUNT);
        criteria.setCondition(null);
        criteria.setSearchValue("5");

        Filter filter = new Filter();
        filter.setName("New Filter");
        filter.setFilterCriteria(Collections.singletonList(criteria));

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> service.createNewFilter(filter));
    }

    @Test
    @Transactional
    void testThrowsExceptionIfFilterCriteriaSearchValueIsNull() {
        FilterCriteria criteria = new FilterCriteria();
        criteria.setFilterOption(FilterOption.AMOUNT);
        criteria.setCondition(FilterCondition.MORE);
        criteria.setSearchValue(null);

        Filter filter = new Filter();
        filter.setName("New Filter");
        filter.setFilterCriteria(Collections.singletonList(criteria));

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> service.createNewFilter(filter));
    }

    @Test
    @Transactional
    void testGetAllFilters() {
        FilterCriteria criteria1 = new FilterCriteria();
        criteria1.setFilterOption(FilterOption.AMOUNT);
        criteria1.setCondition(FilterCondition.MORE);
        criteria1.setSearchValue("5");

        FilterCriteria criteria2 = new FilterCriteria();
        criteria2.setFilterOption(FilterOption.DATE);
        criteria2.setCondition(FilterCondition.AFTER);
        criteria2.setSearchValue(LocalDate.now().toString());

        Filter filter1 = new Filter();
        filter1.setName("New Filter ");
        filter1.setFilterCriteria(Collections.singletonList(criteria1));

        Filter filter2 = new Filter();
        filter2.setName("New Filter 2");
        filter2.setFilterCriteria(Collections.singletonList(criteria2));

        Filter savedFilter1 = service.createNewFilter(filter1);
        Filter savedFilter2 = service.createNewFilter(filter2);

        List<Filter> allFilters = service.findAllFilters().stream()
            .filter(filter -> Arrays.asList(savedFilter1.getId(), savedFilter2.getId()).contains(filter.getId()))
            .sorted(Comparator.comparing(Filter::getId))
            .collect(Collectors.toList());
        Assertions.assertEquals(2, allFilters.size());
        Assertions.assertEquals(filter1, allFilters.get(0));
        Assertions.assertEquals(filter1.getFilterCriteria(), allFilters.get(0).getFilterCriteria());
        Assertions.assertEquals(filter2, allFilters.get(1));
        Assertions.assertEquals(filter2.getFilterCriteria(), allFilters.get(1).getFilterCriteria());
    }



}