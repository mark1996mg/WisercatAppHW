package org.example.controller;

import org.example.entity.Filter;
import org.example.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookFilter")
@CrossOrigin(origins = "http://localhost:3000")
public class FilterController {

    @Autowired
    private FilterService service;

    @GetMapping(value = "/filters", produces = "application/json")
    public List<Filter> getAllFilters() {
        return service.findAllFilters();
    }

    @PostMapping(value = "/addFilter", produces = "application/json", consumes = "application/json")
    public Filter createNewFilter(@RequestBody Filter filter) {
        return service.createNewFilter(filter);
    }
}
