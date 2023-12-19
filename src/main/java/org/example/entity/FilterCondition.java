package org.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.example.entity.serializer.FilterConditionSerializer;

@JsonSerialize(using = FilterConditionSerializer.class)
public enum FilterCondition {
    STARTS_WITH("Starts with"),
    CONTAINS("Contains"),
    EXACT_MATCH("Exact match"),
    EQUALS("Equals"),
    MORE("More"),
    LESS("Less"),
    AFTER("After"),
    BEFORE("Before");

    private final String value;

    FilterCondition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
