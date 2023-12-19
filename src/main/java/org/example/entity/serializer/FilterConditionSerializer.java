package org.example.entity.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.example.entity.FilterCondition;

import java.io.IOException;

public class FilterConditionSerializer extends JsonSerializer<FilterCondition> {

    @Override
    public void serialize(FilterCondition condition, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(condition.getValue());
    }
}
