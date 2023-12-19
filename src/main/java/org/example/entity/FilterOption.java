package org.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.example.entity.serializer.FilterOptionSerializer;

@JsonSerialize(using = FilterOptionSerializer.class)
public enum FilterOption {
    TITLE("Title"),
    AUTHOR("Author"),
    GENRE("Genre"),
    DATE("Publishing date"),
    AMOUNT("Copies sold");

    private final String value;

    FilterOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
