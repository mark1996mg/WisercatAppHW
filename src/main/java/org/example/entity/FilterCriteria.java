package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "FILTER_CRITERIA")
public class FilterCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FilterOption filterOption;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FilterCondition condition;

    @Column(nullable = false)
    private String searchValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FILTER_ID", nullable = false)
    @JsonIgnoreProperties("filterCriteria")
    private Filter filter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public FilterOption getFilterOption() {
        return filterOption;
    }

    public void setFilterOption(FilterOption filterOption) {
        this.filterOption = filterOption;
    }

    public FilterCondition getCondition() {
        return condition;
    }

    public void setCondition(FilterCondition condition) {
        this.condition = condition;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
