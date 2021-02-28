package dev.migwel.javadeps.data;

public enum Status {
    OK("OK"),
    MODIFIED("Modifié"),
    CANCELLED("Annulé"),
    UNKNOWN(null),
    ;

    private final String frenchWording;

    Status(String frenchWording) {
        this.frenchWording = frenchWording;
    }

    public String getFrenchWording() {
        return frenchWording;
    }
}
