package dev.migwel.javadeps.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AdepsEntry(@JsonProperty("recordid") String id,
                         @JsonProperty("fields") AdepsFields fields) {
}
