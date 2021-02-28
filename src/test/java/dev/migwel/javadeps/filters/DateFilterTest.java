package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.filters.DateFilter;
import dev.migwel.javadeps.filters.Filter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateFilterTest {

    @Test
    public void fromAndToDates() {
        Filter dateFilter = new DateFilter(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 3, 1));
        assertEquals("date: [2021-01-01 TO 2021-03-01]", dateFilter.getQuery());
    }

    @Test
    public void onlyFromDate() {
        Filter dateFilter = new DateFilter(LocalDate.of(2021, 1, 1), null);
        assertEquals("date >= 2021-01-01", dateFilter.getQuery());
    }

    @Test
    public void onlyToDate() {
        Filter dateFilter = new DateFilter(null, LocalDate.of(2021, 3, 1));
        assertEquals("date <= 2021-03-01", dateFilter.getQuery());
    }

    @Test
    public void noDates() {
        assertThrows(IllegalArgumentException.class, () -> new DateFilter(null, null));
    }
}