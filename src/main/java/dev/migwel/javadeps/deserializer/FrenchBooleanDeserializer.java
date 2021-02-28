package dev.migwel.javadeps.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.migwel.javadeps.exception.FetchException;

import java.io.IOException;

public class FrenchBooleanDeserializer extends StdDeserializer<Boolean> {

    public FrenchBooleanDeserializer() {
        super(Boolean.class);
    }

    protected FrenchBooleanDeserializer(Class<?> vc) {
        super(vc);
    }

    protected FrenchBooleanDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected FrenchBooleanDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String booleanStr = jsonParser.getValueAsString();
        if (booleanStr == null || booleanStr.isEmpty()) {
            return false;
        }
        return switch (booleanStr) {
            case "Oui" -> true;
            case "Non" -> false;
            default -> throw new FetchException("Incorrect boolean value");
        };
    }
}
