package org.example.service;

import org.example.entity.Filter;

import java.util.List;

public interface FilterService {

    List<Filter> findAllFilters();
    Filter createNewFilter(Filter filter);
}
