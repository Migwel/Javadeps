package dev.migwel.javadeps.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AdepsResponse(@JsonProperty("records") List<AdepsEntry> entries) {}
