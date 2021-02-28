package dev.migwel.javadeps.filters;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class DateFilter implements Filter {
    private final LocalDate fromDate;
    private final LocalDate toDate;

    public DateFilter(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null && toDate == null) {
            throw new IllegalArgumentException("Both dates cannot be null");
        }
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    @Override
    public String getQuery() {
        if (fromDate != null && toDate != null) {
            return "date: [" + fromDate.toString() + " TO " + toDate.toString() + "]";
        }
        if (fromDate != null) {
            return "date >= "+ fromDate.toString();
        }
        return "date <= "+ toDate.toString();
    }
}
