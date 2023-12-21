package org.example.service;

import org.example.entity.Filter;
import org.example.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterRepository repository;

    @Override
    public List<Filter> findAllFilters() {
        return repository.findAll();
    }

    @Override
    public Filter createNewFilter(Filter filter) {
        if (filter.getFilterCriteria() != null) {
            filter.getFilterCriteria().forEach(criteria ->  criteria.setFilter(filter));
        }
        return repository.saveAndFlush(filter);
    }
}
