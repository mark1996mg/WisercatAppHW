package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FILTERS")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "filter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("filter")
    private List<FilterCriteria> filterCriteria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FilterCriteria> getFilterCriteria() {
        return filterCriteria;
    }

    public void setFilterCriteria(List<FilterCriteria> filterCriteria) {
        this.filterCriteria = filterCriteria;
    }
}
