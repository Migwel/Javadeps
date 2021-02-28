package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.data.Status;

public class StatusFilter implements Filter {

    private final Status status;

    public StatusFilter(Status status) {
        this.status = status;
    }

    @Override
    public String getQuery() {
        return "statut: \""+ status.getFrenchWording() +"\"";
    }
}
