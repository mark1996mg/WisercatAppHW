package org.example.controller;

import org.example.entity.Book;
import org.example.entity.Filter;
import org.example.entity.FilterCriteria;
import org.example.service.BookService;
import org.example.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookFilter")
@CrossOrigin(origins = "http://localhost:3000")
public class FilterController {

    @Autowired
    private FilterService service;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public Resource indexPage() {
        return new ClassPathResource("templates/index.html");
    }

    @GetMapping(value = "/filters", produces = "application/json")
    private List<Filter> getAllFilters() {
        return service.findAllFilters();
    }

    @PostMapping(value = "/addFilter", produces = "application/json", consumes = "application/json")
    private Filter createNewFilter(@RequestBody Filter criteria) {
        return service.createNewFilter(criteria);
    }

    @GetMapping(value = "/getBooks", consumes = "application/json", produces = "application/json")
    private List<Book> getBooksByCriteria(@RequestBody List<FilterCriteria> criteriaList) {
        return bookService.findBooksByCriteria();
    }
}
