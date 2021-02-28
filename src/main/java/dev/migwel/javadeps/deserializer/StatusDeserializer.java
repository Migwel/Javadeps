package dev.migwel.javadeps.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.migwel.javadeps.data.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class StatusDeserializer extends StdDeserializer<Status> {

    Logger log = LoggerFactory.getLogger(StatusDeserializer.class);

    public StatusDeserializer() {
        super(Boolean.class);
    }

    protected StatusDeserializer(Class<?> vc) {
        super(vc);
    }

    protected StatusDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected StatusDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Status deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String statusStr = jsonParser.getValueAsString();
        if (statusStr == null || statusStr.isEmpty()) {
            return null;
        }

        for (Status status : Status.values()) {
            if (statusStr.equals(status.getFrenchWording())) {
                return status;
            }
        }
        log.warn("Unknown status: "+ statusStr);
        return Status.UNKNOWN;
    }
}
