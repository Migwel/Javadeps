package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.data.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusFilterTest {

    @Test
    public void okQuery() {
        Filter filter = new StatusFilter(Status.OK);
        assertEquals("statut: \"OK\"", filter.getQuery());
    }

    @Test
    public void cancelledQuery() {
        Filter filter = new StatusFilter(Status.CANCELLED);
        assertEquals("statut: \"Annulé\"", filter.getQuery());
    }

    @Test
    public void modifiedQuery() {
        Filter filter = new StatusFilter(Status.MODIFIED);
        assertEquals("statut: \"Modifié\"", filter.getQuery());
    }

}