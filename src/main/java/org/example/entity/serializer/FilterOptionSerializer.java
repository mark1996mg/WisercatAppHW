package org.example.entity.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.example.entity.FilterOption;

import java.io.IOException;

public class FilterOptionSerializer extends JsonSerializer<FilterOption> {

    @Override
    public void serialize(FilterOption option, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(option.getValue());
    }
}
