package dev.migwel.javadeps.filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AndFilter implements Filter {
    private final List<Filter> filters = new ArrayList<>();

    public AndFilter() {
    }

    public AndFilter(Filter... filters) {
        Arrays.stream(filters).forEach(this::addFilter);
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public String getQuery() {
        return "(" +
                filters.stream().map(Filter::getQuery).collect(Collectors.joining(" AND ")) +
                ")";
    }
}
